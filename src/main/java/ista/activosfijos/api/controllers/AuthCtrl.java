package ista.activosfijos.api.controllers;

import ista.activosfijos.api.models.dao.primary.RolRepositoryDao;
import ista.activosfijos.api.models.dao.primary.UsuariosRepositoryDao;
import ista.activosfijos.api.models.dtos.request.LoginRequest;
import ista.activosfijos.api.models.dtos.request.SignupRequest;
import ista.activosfijos.api.models.dtos.response.JwtResponse;
import ista.activosfijos.api.models.dtos.response.MessageResponse;
import ista.activosfijos.api.models.entity.primary.ERol;
import ista.activosfijos.api.models.entity.primary.Rol;
import ista.activosfijos.api.models.entity.primary.Usuario;
import ista.activosfijos.api.models.entity.primary.UsuarioPrincipal;
import ista.activosfijos.api.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/auth")
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

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getCedula(), loginRequest.getContrasenia()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UsuarioPrincipal userDetails = (UsuarioPrincipal) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId_usuario(),
                userDetails.getCedula(),
                userDetails.getCorreo(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByCedula(signUpRequest.getCedula())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        Usuario user = new Usuario(signUpRequest.getCedula(),
                signUpRequest.getNombre(),
                signUpRequest.getApellido(),
                passwordEncoder.encode(signUpRequest.getContrasenia()),
                signUpRequest.getCorreo());

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Rol> roles = new HashSet<>();

        if (strRoles == null || strRoles.isEmpty()) {
            Rol userRole = roleRepository.findByNombre(ERol.ROL_SOLICITANTE);
            roles.add(userRole);
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    private String nombre;
}
