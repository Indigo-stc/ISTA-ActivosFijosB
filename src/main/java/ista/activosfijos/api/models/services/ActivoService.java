package ista.activosfijos.api.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.dao.primary.ActivoRepository;
import ista.activosfijos.api.models.entity.primary.Activo;

@Service
public class ActivoService implements IActivoService {
	
	
	// Crear una instacia (EVITAR PONER EL NEW ACTIVO)
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
}
