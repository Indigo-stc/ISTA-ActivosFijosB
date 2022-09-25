package ista.activosfijos.api.controllers;

import ista.activosfijos.api.models.dao.primary.RolRepositoryDao;
import ista.activosfijos.api.models.dao.primary.UsuariosRepositoryDao;
import ista.activosfijos.api.models.entity.primary.ERol;
import ista.activosfijos.api.models.entity.primary.Rol;
import ista.activosfijos.api.models.entity.primary.Usuario;
import ista.activosfijos.api.models.entity.secundary.verpersonaf;
import ista.activosfijos.api.models.services.IUsuarioService;
import ista.activosfijos.api.models.services.IDocenteFenixService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/user")

public class UserController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @Autowired
    private RolRepositoryDao rolrepo;

    @Autowired
    private UsuariosRepositoryDao usuariosDao;

   
    @GetMapping("/all")
    @PreAuthorize("hasRole('RESPONSABLE')")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return ResponseEntity.ok().body(iUsuarioService.getUsusarios());
    }

    @PostMapping("/rol/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/rol/save").toUriString());
        return ResponseEntity.created(uri).body(iUsuarioService.saveRole(rol));
    }

    @PutMapping("/rol/addtouser")
    @PreAuthorize("hasRole('RESPONSABLE')")
    public ResponseEntity<?> addRoletoUser(@RequestBody RolToUser usuario){
        Set<Rol> roles = new HashSet<>();
        String nrol;
        Usuario user = usuariosDao.findByCedula(usuario.getCedula());

        for (int i = 0; i < rolrepo.findAll().size(); i++) {
            Rol r=rolrepo.findAll().get(i);
            nrol = r.getNombre();
            if (usuario.getRoles().contains(nrol)) {
                System.out.println(r.getNombre());
                roles.add(r);
            }
        }
        //AGREGA EL ROL SOLICITANTE POR DEFECTO
        Rol userRole = rolrepo.findbynombre("ROLE_SOLICITANTE");
        roles.add(userRole);

        user.setRoles(roles);
        iUsuarioService.addRoleToUser(user);
        return ResponseEntity.ok().build();
    }

    //@DeleteMapping("/rol/deletetouser")
    //@PutMapping("/rol/deletetouser")

    @PostMapping("/rol/deletetouser")
    @PreAuthorize("hasRole('RESPONSABLE')")
    public ResponseEntity<?> removeRoletoUser(@RequestBody RolToUser form){
       //iUsuarioService.removeRoleToUser(form.getCedula(), form.getRolname());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{id}")
    public Usuario show(@PathVariable long id) {
        return iUsuarioService.findById(id);
    }


    //Metodos de Esteban ------------------------------------------------

    @GetMapping()
    public List<Usuario> listarUsuarios() {
        return iUsuarioService.findAllUsuario();
    }

    @GetMapping("{cedula}")
    public ResponseEntity<List<Usuario>> getAllUserByCedula(@PathVariable("cedula") String cedula) {
        return ResponseEntity.ok(iUsuarioService.buscarUsuario(cedula));

    }

    @GetMapping(value = "/buscar/{id}")
    public Usuario findById(@PathVariable("id") Long id) {
        return this.iUsuarioService.findByIdUsuario(id);
    }

}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class RolToUser {

    private Set<String> roles = new HashSet<>();
    private String cedula;


}
