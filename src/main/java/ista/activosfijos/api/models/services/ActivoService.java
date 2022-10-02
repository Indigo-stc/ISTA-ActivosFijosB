package ista.activosfijos.api.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.dao.primary.ActivoRepository;
import ista.activosfijos.api.models.entity.primary.Activo;

@Service
public class ActivoService implements IActivoService {
	
	@Autowired
	private ActivoRepository activoRepository;
			
	@Override
	@Transactional (readOnly= true)
	public List<Activo> findAllActivo() {
		return (List<Activo>) activoRepository.findAll();
	}

	@Override
	public Activo guardarActivo(Activo activo) {
		return activoRepository.save(activo);
	}

	@Override
	@Transactional (readOnly= true)
	public Activo findByIdActivo(Long id) {
		return activoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarActivo(Long id) {
		this.activoRepository.deleteById(id);
	}
	
	public boolean updateActivo (Activo activo) {
	      Optional<Activo> exists = activoRepository.findById(activo.getId_activo());
	        
	      if (exists.isPresent()) {
	    	  Activo activoActual = exists.get();
	    	  activoActual.setNombre(activo.getNombre());
	    	  activoActual.setSerie(activo.getSerie());
	    	  activoActual.setMarca(activo.getMarca());
	    	  activoActual.setModelo(activo.getModelo());
	    	  activoActual.setImagen(activo.getImagen());
	    	  activoActual.setDescripcion(activo.getDescripcion());
	    	  activoActual.setCosto(activo.getCosto());
	    	  activoActual.setEstado_fisico(activo.getEstado_fisico());
	    	  activoActual.setDisponibilidad(activo.isDisponibilidad());
	    	  activoRepository.save(activoActual);

	            return true;
	      } else {
	        	return false;
	     }
	}
	@Override
	public List<?> validarExistenciaCodigoActivo(String codigo_activo) {
		return activoRepository.validarCodigoActivos(codigo_activo);
	}
}
