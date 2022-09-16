package ista.activosfijos.api.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.dao.primary.ProcedenciaRepository;
import ista.activosfijos.api.models.entity.primary.Procedencia;



@Service
public class ProcedenciaService implements IProcedenciaService {
	
	@Autowired
	private ProcedenciaRepository procedenciaRepository;

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
	
	
}
