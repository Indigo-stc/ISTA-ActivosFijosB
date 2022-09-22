package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.entity.primary.Asignacion_Custodio;


public interface IAsignacion_custodioService{

public List<Asignacion_Custodio> findAllAsignacionCustodio();
	
	public Asignacion_Custodio guardarAsignacionCustodio(Asignacion_Custodio asignacioncustodio);

	public Asignacion_Custodio findByIdAsignacionCustodio(Long id);
			
	public void eliminarAsignacionCustodio(Long id);
}	