package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.entity.primary.Asignacion_Responsable;

public interface IAsignacion_responsableService {
	public List<Asignacion_Responsable> findAllAsignacion_Responsable();
	
	public Asignacion_Responsable guardarAsignacion_Responsable(Asignacion_Responsable asignacion_Responsable);

	public Asignacion_Responsable findByIdAsignacion_Responsable(Long id);
			
	public void eliminarAsignacion_Responsable(Long id);
}
