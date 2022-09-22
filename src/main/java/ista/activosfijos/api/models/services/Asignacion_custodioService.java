package ista.activosfijos.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.dao.primary.Asignacion_CustodioRepository;
import ista.activosfijos.api.models.entity.primary.Asignacion_Custodio;

@Service
public class Asignacion_custodioService implements IAsignacion_custodioService {

	@Autowired
	private Asignacion_CustodioRepository asignacioncustodioRepository;
			
	@Override
	@Transactional (readOnly= true)
	public List<Asignacion_Custodio> findAllAsignacionCustodio() {
		return (List<Asignacion_Custodio>) asignacioncustodioRepository.findAll();
	}

	@Override
	public Asignacion_Custodio guardarAsignacionCustodio(Asignacion_Custodio asignacioncustodio) {
		return asignacioncustodioRepository.save(asignacioncustodio);
	}

	@Override
	@Transactional (readOnly= true)
	public Asignacion_Custodio findByIdAsignacionCustodio(Long id) {
		return asignacioncustodioRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarAsignacionCustodio(Long id) {
		this.asignacioncustodioRepository.deleteById(id);
	}
}