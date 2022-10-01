package ista.activosfijos.api.models.services;

import ista.activosfijos.api.models.entity.primary.Asignacion_Departamento;

import java.util.List;



public interface IAsignacion_departamentoService {
	public List<Asignacion_Departamento> findAllAsignacion_Departamento();
	
	public Asignacion_Departamento guardarAsignacion_Departamento(Asignacion_Departamento asignacion_Departamento);

	public Asignacion_Departamento findByIdAsignacion_Departamento(Long id);
			
	public void eliminarAsignacion_Departamento(Long id);
}
