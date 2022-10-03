package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.dao.primary.Activo_constatacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.entity.primary.activo_constatacion;


@Service
public class Activo_constatacionService implements IActivo_constatacionService{
	
	@Autowired
	private Activo_constatacionRepository activo_constatacionRepository;

	@Override
	@Transactional (readOnly= true)
	public List<activo_constatacion> findAll() {
		// TODO Auto-generated method stub
		return (List<activo_constatacion>) activo_constatacionRepository.findAll();
	}

}
