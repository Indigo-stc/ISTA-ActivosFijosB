package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.entity.primary.Departamento;


public interface IDepartamentosService {
	
	
	public List<Departamento> findAllDepartamento();
	
	public Departamento guardarDepartamento(Departamento departamento);

	public Departamento findByIdDepartamento(Long id);
			
	public void eliminarDepartamento(Long id);

	List<Departamento> buscarDepartamentoPorEdifico(Long id);

}
