package ista.activosfijos.api.controllers;

import ista.activosfijos.api.models.entity.primary.Rol;
import ista.activosfijos.api.models.entity.primary.Usuario;
import ista.activosfijos.api.models.entity.secundary.verpersonaf;
import ista.activosfijos.api.models.services.IUsuarioService;
import ista.activosfijos.api.models.services.IDocenteFenixService;
import lombok.Data;
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

    @PostMapping("/rol/addtouser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addRoletoUser(@RequestBody RolToUserForm form){
        iUsuarioService.addRoleToUser(form.getCedula(), form.getRolname());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{id}")
    public Usuario show(@PathVariable long id) {
        return iUsuarioService.findById(id);
    }


    //Metodos de Esteban ------------------------------------------------

    @GetMapping
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

@Data
class RolToUserForm {
    private String cedula;
    private String rolname;
}
