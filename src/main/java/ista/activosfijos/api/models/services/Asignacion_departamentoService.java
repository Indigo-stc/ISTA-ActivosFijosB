package ista.activosfijos.api.models.services;

import java.util.List;
import java.util.Optional;

import ista.activosfijos.api.models.dao.primary.Asignacion_departamentoRepository;
import ista.activosfijos.api.models.entity.primary.Asignacion_Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Asignacion_departamentoService implements IAsignacion_departamentoService {
	
	@Autowired
	private Asignacion_departamentoRepository asignacion_departamentoRepository;
			
	@Override
	@Transactional (readOnly= true)
	public List<Asignacion_Departamento> findAllAsignacion_Departamento() {
		return (List<Asignacion_Departamento>) asignacion_departamentoRepository.findAll();
	}

	@Override
	public Asignacion_Departamento guardarAsignacion_Departamento(Asignacion_Departamento asignacion_Departamento) {
		return asignacion_departamentoRepository.save(asignacion_Departamento);
	}

	@Override
	@Transactional (readOnly= true)
	public Asignacion_Departamento findByIdAsignacion_Departamento(Long id) {
		return asignacion_departamentoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarAsignacion_Departamento(Long id) {
		this.asignacion_departamentoRepository.deleteById(id);
	}
	
	public boolean updateAsignacion_Departamento (Asignacion_Departamento asignacion_Departamento) {
	      Optional<Asignacion_Departamento> exists = asignacion_departamentoRepository.findById(asignacion_Departamento.getId_asignacion_Departamento());
	        
	      if (exists.isPresent()) {
	    	  Asignacion_Departamento Asignacion_DepartamentoActual = exists.get();
	    	  Asignacion_DepartamentoActual.setFecha_asignacion(asignacion_Departamento.getFecha_asignacion());
	    	  Asignacion_DepartamentoActual.setFecha_fin(asignacion_Departamento.getFecha_fin());
	    	  Asignacion_DepartamentoActual.setId_activo(asignacion_Departamento.getId_activo());
	    	  Asignacion_DepartamentoActual.setId_departamento(asignacion_Departamento.getId_departamento());
	    	  asignacion_departamentoRepository.save(Asignacion_DepartamentoActual);

	            return true;
	      } else {
	        	return false;
	     }
	}


	
}
