package ista.activosfijos.api.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ista.activosfijos.api.models.dao.primary.ProcedenciaRepository;
import ista.activosfijos.api.models.entity.primary.Procedencia;


@Service
public class ProcedenciaService implements IProcedenciaService {
	
	@Autowired
	private ProcedenciaRepository procedenciaRepository;

	
	public List<Procedencia>  List() {
		return (List<Procedencia>) procedenciaRepository.findAll();
	}
	
	@Override
	@Transactional (readOnly= true)
	public List<Procedencia> findAllProcedencia() {
		return (List<Procedencia>) procedenciaRepository.findAll();
	}

	@Override
	public Procedencia guardarProcedencia(Procedencia procedencia) {
		return procedenciaRepository.save(procedencia);
	}

	@Override
	@Transactional (readOnly= true)
	public Procedencia findByIdProcedencia(Long id) {
		return procedenciaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarProcedencia(Long id) {
		this.procedenciaRepository.deleteById(id);
	}
	
	
	public boolean updateProcedencia(Procedencia procedencia) {
	      Optional<Procedencia> exists = procedenciaRepository.findById(procedencia.getId_procedencia());
	        
	      if (exists.isPresent()) {
				Procedencia procedenciaActual = exists.get();
				procedenciaActual.setNombre_procedencia(procedencia.getNombre_procedencia());
				procedenciaActual.setDescripcion(procedencia.getDescripcion());
				procedenciaRepository.save(procedenciaActual);
	            return true;
	      } else {
	        	return false;
	     }
	}
	
}
