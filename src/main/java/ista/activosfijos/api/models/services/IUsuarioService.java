package ista.activosfijos.api.models.services;

import ista.activosfijos.api.models.entity.primary.Rol;
import ista.activosfijos.api.models.entity.primary.Usuario;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUsuarioService extends UserDetailsService{

    //Usuario saveUser(Usuario usuarios);
    
    Rol saveRole(Rol rol);

    void addRoleToUser(String cedula, String nombreRol);

    Usuario getUsuario(String cedula);

    List<Usuario>getUsusarios();
    
    public List<Usuario> findAllUsuario();
	
	List<Usuario> buscarUsuario(String cedula);
    
}
