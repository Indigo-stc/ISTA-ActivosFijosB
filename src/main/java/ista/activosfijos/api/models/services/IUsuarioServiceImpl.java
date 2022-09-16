package ista.activosfijos.api.models.services;

import ista.activosfijos.api.models.dao.primary.RolRepositoryDao;
import ista.activosfijos.api.models.dao.primary.UsuariosRepositoryDao;
import ista.activosfijos.api.models.dao.secundary.VerpersonafDao;
import ista.activosfijos.api.models.entity.primary.Rol;
import ista.activosfijos.api.models.entity.primary.UsuarioPrincipal;
import ista.activosfijos.api.models.entity.primary.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

//Este va ser el servicio principal del login.
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class IUsuarioServiceImpl implements IUsuarioService {

    private final UsuariosRepositoryDao usuariosDao;
    private final RolRepositoryDao rolRepositoryDao;
    private final VerpersonafDao consultaFenix;
    
    @Override
    public Usuario saveUser(Usuario usuarios) {
    	
    	if(!usuariosDao.existsByCedula(usuarios.getCedula())) {
    		if(consultaFenix.existsByCedula(usuarios.getCedula())){
                log.info("Guardado Nuevo usuario con la cedula {} y con nombre {} en la BD", usuarios.getCedula(), usuarios.getNombres());
                usuarios.setContrasenia(usuarios.getContrasenia());
               // addRoleToUser(usuarios.getCedula(), "USER");
                //usuarios.getRoles().add(new Rol ("USER"));
                return usuariosDao.save(usuarios);  
            }else{
                log.info("El usuario con la cedula {} no esta en la bda de FENIX", usuarios.getCedula());
                return null;
            }
    	}else {
    		log.info("El usuario con la cedula {} ya esta registrado..", usuarios.getCedula());
            return null;
    	}
    	
    }

    @Override
    public Rol saveRole(Rol rol) {
        log.info("Guardado nuevo rol {} en la BD", rol.getNombre());
        return rolRepositoryDao.save(rol);
    }

    @Override
    public void addRoleToUser(String cedula, String nombreRol) {
        /*log.info("Añadido rol {} a usuario {}", nombreRol, cedula);
        Usuarios usuarios = usuariosDao.findByCedula(cedula);
        Rol rol = rolRepositoryDao.findByNombre(nombreRol);
        usuarios.getRoles().add(rol);*/
    }

    @Override
    public Usuario getUsuario(String cedula) {
        log.info("Fetching usuario {}", cedula);
        return usuariosDao.findByCedula(cedula);
    }

    @Override
    public List<Usuario> getUsusarios() {
        log.info("Recorrido de todos los usuarios");
        return usuariosDao.findAll();
    } 

    @Override
    public UserDetails loadUserByUsername(String cedula) throws UsernameNotFoundException {
        Usuario user = usuariosDao.findByCedula(cedula);
        if (user == null){
            log.error("Ususario no esta en la base de datos..");
            throw new UsernameNotFoundException("Ususario no esta en la base de datos..");
        } else {
            log.info("Usuarion en la base de datos: {}", cedula);
        }
        return UsuarioPrincipal.build(user);
    }
    
    //Metodos generados-------------------------------------------------------------------
	
	// EXTRA LOS DATOS DE USUARIO
		public List<Usuario> findAllByName (String cedula){
			List<Usuario> estadosRespuesta= new ArrayList<>();
			List<Usuario> user = usuariosDao.findAll();
			for (int i=0; i<user.size(); i++) {
				if (user.get(i).getCedula() == cedula) {
					estadosRespuesta.add(user.get(i));
				}
			}
			return estadosRespuesta;
		}

	@Override
	public List<Usuario> findAllUsuario() {
		return (List<Usuario>) usuariosDao.findAll();
	}

	@Override
	public List<Usuario> buscarUsuario(String cedula) {
		return usuariosDao.buscarUsuario(cedula);
	}

}
