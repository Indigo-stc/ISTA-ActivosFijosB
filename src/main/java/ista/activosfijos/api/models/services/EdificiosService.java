package ista.activosfijos.api.models.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.dao.primary.EdificiosRepository;
import ista.activosfijos.api.models.entity.primary.Edificio;


@Service
public class EdificiosService  implements IEdificiosService {
	

	@Autowired
	private EdificiosRepository edificioRepository;
			
	@Override
	@Transactional (readOnly= true)
	public List<Edificio> findAllEdificio() {
		return (List<Edificio>) edificioRepository.findAll();
	}

	@Override
	public Edificio guardarEdificio(Edificio edificio) {
		return edificioRepository.save(edificio);
	}

	@Override
	@Transactional (readOnly= true)
	public Edificio findByIdEdificio(Long id) {
		return edificioRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarEdificio(Long id) {
		this.edificioRepository.deleteById(id);
	}
}
