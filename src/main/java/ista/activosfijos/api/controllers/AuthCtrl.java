package ista.activosfijos.api.controllers;

import ista.activosfijos.api.models.dao.primary.RolRepositoryDao;
import ista.activosfijos.api.models.dao.primary.UsuariosRepositoryDao;
import ista.activosfijos.api.models.dao.secundary.VerpersonafDao;
import ista.activosfijos.api.models.dtos.request.LoginRequest;
import ista.activosfijos.api.models.dtos.request.SignupRequest;
import ista.activosfijos.api.models.dtos.response.MessageResponse;
import ista.activosfijos.api.models.dtos.response.UserInfoResponse;
import ista.activosfijos.api.models.entity.primary.ERol;
import ista.activosfijos.api.models.entity.primary.Rol;
import ista.activosfijos.api.models.entity.primary.Usuario;
import ista.activosfijos.api.models.entity.primary.UsuarioPrincipal;
import ista.activosfijos.api.models.entity.secundary.verpersonaf;
import ista.activosfijos.api.models.services.IDocenteFenixService;
import ista.activosfijos.api.security.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthCtrl {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuariosRepositoryDao userRepository;

    @Autowired
    RolRepositoryDao roleRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    VerpersonafDao personaFenix;

    @Autowired
    private IDocenteFenixService docenteFenix;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        if(userRepository.existsByCorreo(loginRequest.getCorreo())){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getCorreo(), loginRequest.getContrasenia()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            UsuarioPrincipal userDetails = (UsuarioPrincipal) authentication.getPrincipal();
            ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);


            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                    .body(new UserInfoResponse(
                    userDetails.getId_usuario(),
                    userDetails.getCorreo(),
                    roles));
        }else{
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("No registrado!"));

        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        //Estamos verificando si esa en nuestra bd..
        if (!userRepository.existsByCedula(signUpRequest.getCedula())) {

            //Estamos verificando si el usuario que va registrarse esta en Fenix..
            if (personaFenix.existsByCedula(signUpRequest.getCedula())) {

                //Estamos comprobando que no se ingrese un correo que ya fue ingresado..
                if(!userRepository.existsByCorreo(signUpRequest.getCorreo())){
                    Usuario user = new Usuario(signUpRequest.getCedula(),
                            signUpRequest.getNombre(),
                            signUpRequest.getApellido(),
                            passwordEncoder.encode(signUpRequest.getContrasenia()),
                            signUpRequest.getCorreo());

                    Set<String> strRoles = signUpRequest.getRoles();
                    Set<Rol> roles = new HashSet<>();

                    if (strRoles == null || strRoles.isEmpty()) {
                        Rol userRole = roleRepository.findByNombre(ERol.ROLE_SOLICITANTE);
                        roles.add(userRole);
                    }

                    user.setRoles(roles);
                    userRepository.save(user);

                    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

                }else{
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Error: Usted no puede ingresar un correo existente!"));
                }

            }else{
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: El usuario no esta en FENIX!"));
            }

        }else{
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Usuario ya esta en la BD!"));
        }

    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }

    @GetMapping("/personafenix/{cedula}")
    public verpersonaf buscar(@PathVariable String cedula){
        return docenteFenix.findById(cedula);
    }

}
