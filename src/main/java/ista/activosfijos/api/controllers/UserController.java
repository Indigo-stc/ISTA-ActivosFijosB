package ista.activosfijos.api.controllers;

import ista.activosfijos.api.models.entity.primary.Rol;
import ista.activosfijos.api.models.entity.primary.Usuario;
import ista.activosfijos.api.models.entity.secundary.verpersonaf;
import ista.activosfijos.api.models.services.IUsuarioService;
import ista.activosfijos.api.models.services.IUsuarioServiceImpl;
import ista.activosfijos.api.models.services.IDocenteFenixService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.*;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UserController {

    private IUsuarioService iUsuarioService;
    //private final FiltrosAuthentication filtrosAuthentication;
   
    @GetMapping("/users/all")
    @PreAuthorize("hasRole('RESPONSABLE')")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return ResponseEntity.ok().body(iUsuarioService.getUsusarios());
    }
 
    /*@PostMapping("/users/save")
    public ResponseEntity<Usuarios> guardarUser(@RequestBody Usuarios usuarios){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/save").toUriString());
        Rol rol = new Rol(62L, "USER");
        usuarios.setRoles(Arrays.asList(rol));
        return ResponseEntity.created(uri).body(iUsuarioService.saveUser(usuarios));
    }*/

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

    //Estos datos son de fenix

    /*@Autowired
    private IDocenteFenixService docenteFenix;*/

    //Listar empleado------VALIDO
    /*@GetMapping("/persona")
    public List<verpersonaf> indext(){
        return docenteFenix.findAll();
    }*/


    /*@GetMapping("/personafenix/{cedula}")
    public verpersonaf buscar(@PathVariable String cedula){
        return docenteFenix.findById(cedula);
    }*/
    
    
   /* @GetMapping("/users")
    public List<verpersonaf> newa(){
        return docenteFenix.findAll();
    }*/

}

@Data
class RolToUserForm {
    private String cedula;
    private String rolname;
}
