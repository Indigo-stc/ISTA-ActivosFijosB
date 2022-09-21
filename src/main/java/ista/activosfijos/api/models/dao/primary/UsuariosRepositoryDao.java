package ista.activosfijos.api.models.dao.primary;


import ista.activosfijos.api.models.entity.primary.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepositoryDao extends JpaRepository<Usuario,Long> {

    public Usuario findByCedula(String cedula);

    public Usuario findByCorreo(String correo);
    
    Boolean existsByCedula (String cedula);

    Boolean existsByCorreo(String correo);
    
    //Metodos Query
 		@Query(value = "SELECT * FROM usuario WHERE cedula = ?",
 				nativeQuery = true
 				)
     List<Usuario> buscarUsuario(String cedula);
    
   

}
