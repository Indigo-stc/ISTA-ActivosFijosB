package ista.activosfijos.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.dao.primary.Historial_ingRepository;
import ista.activosfijos.api.models.entity.primary.Historial_ing;

@Service
public class Historial_ingService implements IHistorial_ingService {

	@Autowired
	private Historial_ingRepository historial_ingRepository;
			
	@Override
	@Transactional (readOnly= true)
	public List<Historial_ing> findAllHistorial_ing() {
		return (List<Historial_ing>) historial_ingRepository.findAll();
	}

	@Override
	public Historial_ing guardarHistorial_ing(Historial_ing historial_ing) {
		return historial_ingRepository.save(historial_ing);
	}

	@Override
	@Transactional (readOnly= true)
	public Historial_ing findByIdHistorial_ing(Long id) {
		return historial_ingRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarHistorial_ing(Long id) {
		this.historial_ingRepository.deleteById(id);
	}
}
