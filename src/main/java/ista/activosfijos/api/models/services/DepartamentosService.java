package ista.activosfijos.api.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.activosfijos.api.models.dao.primary.DepartamentosRepository;
import ista.activosfijos.api.models.entity.primary.Departamento;


@Service
public class DepartamentosService implements IDepartamentosService {
	

	@Autowired 
	private DepartamentosRepository departamentoRepository;
			
	@Override
	@Transactional (readOnly= true)
	public List<Departamento> findAllDepartamento() {
		return (List<Departamento>) departamentoRepository.findAll();
	}

	@Override
	public Departamento guardarDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	@Override
	@Transactional (readOnly= true)
	public Departamento findByIdDepartamento(Long id) {
		return departamentoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarDepartamento(Long id) {
		this.departamentoRepository.deleteById(id);
	}
	
	// EXTRA para hacer el combo anidado
	public List<Departamento> findAllByEdificio (Long id){
		List<Departamento> estadosRespuesta= new ArrayList<>();
		List<Departamento> estados= departamentoRepository.findAll();
		for (int i=0; i<estados.size(); i++) {
			if (estados.get(i).getEdificio().getId_edificio()==id) {
				estadosRespuesta.add(estados.get(i));
			}
		}
		return estadosRespuesta;
	}
}
