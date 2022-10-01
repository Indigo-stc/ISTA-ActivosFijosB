package ista.activosfijos.api.models.services;


import java.util.List;
import java.util.Optional;

import ista.activosfijos.api.models.dao.primary.Asignacion_responsableRepository;
import ista.activosfijos.api.models.entity.primary.Asignacion_Responsable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Asignacion_responsableService implements IAsignacion_responsableService{
	
	@Autowired
	private Asignacion_responsableRepository asignacion_responsableRepository;
		
	@Override
	@Transactional (readOnly= true)
	public List<Asignacion_Responsable> findAllAsignacion_Responsable() {
		return (List<Asignacion_Responsable>) asignacion_responsableRepository.findAll();
	}

	@Override
	public Asignacion_Responsable guardarAsignacion_Responsable(Asignacion_Responsable asignacion_Responsable) {
		return asignacion_responsableRepository.save(asignacion_Responsable);
	}

	@Override
	@Transactional (readOnly= true)
	public Asignacion_Responsable findByIdAsignacion_Responsable(Long id) {
		return asignacion_responsableRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarAsignacion_Responsable(Long id) {
		this.asignacion_responsableRepository.deleteById(id);
	}
	
	public boolean updateAsignacion_Responsable (Asignacion_Responsable asignacion_Responsable) {
	      Optional<Asignacion_Responsable> exists = asignacion_responsableRepository.findById(asignacion_Responsable.getId_asignacion_Responsable());
	        
	      if (exists.isPresent()) {
	    	  Asignacion_Responsable Asignacion_ResponsableActual = exists.get();
	    	  Asignacion_ResponsableActual.setFecha_asignacion(asignacion_Responsable.getFecha_asignacion());
	    	  Asignacion_ResponsableActual.setFecha_fin(asignacion_Responsable.getFecha_fin());
	    	  Asignacion_ResponsableActual.setId_activo(asignacion_Responsable.getId_activo());
	    	  Asignacion_ResponsableActual.setId_Uresponsable(asignacion_Responsable.getId_Uresponsable());
	    	  asignacion_responsableRepository.save(Asignacion_ResponsableActual);

	            return true;
	      } else {
	        	return false;
	     }
	}


}
