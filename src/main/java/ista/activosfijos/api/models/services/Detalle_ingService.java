package ista.activosfijos.api.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.dao.primary.Detalle_ingRepository;
import ista.activosfijos.api.models.entity.primary.Detalle_ing;


@Service
public class Detalle_ingService implements IDetalle_ingService{

	@Autowired
	private Detalle_ingRepository detalle_ingRepository;

	@Transactional
	public List<Detalle_ing> findBynum_recep(String num_recep) {
		return detalle_ingRepository.findBynum_recep(num_recep);
	}

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
	
	public List<Detalle_ing> findAllByDetalle_ings (Long id){
		List<Detalle_ing> estadosRespuesta= new ArrayList<Detalle_ing>();
		List<Detalle_ing> estados= detalle_ingRepository.findAll();
		for (int i=0; i<estados.size(); i++) {
			if (estados.get(i).getEncabezado_ing().getId_encabezado_ing()==id) {
				estadosRespuesta.add(estados.get(i));
			}
		}
		return estadosRespuesta;
	}
	// Update estado
	public boolean updateDetalleAlRegistrarActivo(Detalle_ing detalle_ing) {
		Optional<Detalle_ing> exists = detalle_ingRepository.findById(detalle_ing.getId_detalle_ing());
		if (exists.isPresent()) {
			Detalle_ing detalle_ingActual = exists.get();
			detalle_ingActual.setEstado_detalle(detalle_ing.getEstado_detalle());
			detalle_ingRepository.save(detalle_ingActual);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<?> contarLosDetallesTrue(Long id_encabezado_ing) {
		return detalle_ingRepository.contarLosDetalles(id_encabezado_ing);
	}
}
