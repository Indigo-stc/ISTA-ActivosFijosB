package ista.activosfijos.api.models.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.dao.primary.Encabezado_ingRepository;
import ista.activosfijos.api.models.entity.primary.Encabezado_ing;


@Service
public class Encabezado_ingService implements IEncabezado_ingService{

	@Autowired
	private Encabezado_ingRepository encabezado_ingRepository;
			
	@Override
	@Transactional (readOnly= true)
	public List<Encabezado_ing> findAllEncabezado_ing() {
		return (List<Encabezado_ing>) encabezado_ingRepository.findAll();
	}

	@Override
	public Encabezado_ing guardarEncabezado_ing(Encabezado_ing encabezado_ing) {
		return encabezado_ingRepository.save(encabezado_ing);
	}

	@Override
	@Transactional (readOnly= true)
	public Encabezado_ing findByIdEncabezado_ing(Long id) {
		return encabezado_ingRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarEncabezado_ing(Long id) {
		this.encabezado_ingRepository.deleteById(id);
	}
	
	// ACTUALIZAR SU EL ESTADO AL HACER EL REGISTRO DEL ACTIVO
	
	public boolean actualizarEstadoDeEncabezado(Encabezado_ing encabezado_ing) {
		Optional<Encabezado_ing> exists = encabezado_ingRepository.findById(encabezado_ing.getId_encabezado_ing());
		        
		 if (exists.isPresent()) {
			 Encabezado_ing encabezado_ingActual = exists.get();
			 encabezado_ingActual.setEstado(encabezado_ing.isEstado());
			 //encabezado_ingActual.setDocumento(encabezado_ing.getDocumento());
			 encabezado_ingRepository.save(encabezado_ingActual);
		    return true;
		    
		} else {
		    return false;
	    }
	}
}
