package ista.activosfijos.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.dao.primary.Detalle_ingRepository;
import ista.activosfijos.api.models.entity.primary.Detalle_ing;


@Service
public class Detalle_ingService implements IDetalle_ingService{

	@Autowired
	private Detalle_ingRepository detalle_ingRepository;

	@Override
	@Transactional (readOnly= true)
	public List<Detalle_ing> findAllDetalle_ing() {
		return (List<Detalle_ing>) detalle_ingRepository.findAll();
	}

	@Override	
	public Detalle_ing guardarDetalle_ing(Detalle_ing detalle_ing) {
		return detalle_ingRepository.save(detalle_ing);
	}

	@Override
	@Transactional (readOnly= true)
	public Detalle_ing findByIdDetalle_ing(Long id) {
		return detalle_ingRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarDetalle_ing(Long id) {
		this.detalle_ingRepository.deleteById(id);
	}
}
