package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.entity.primary.Historial_ing;


public interface IHistorial_ingService {

	// Metodos CRUD
	
		public List<Historial_ing> findAllHistorial_ing();
				
		public Historial_ing guardarHistorial_ing(Historial_ing historial_ing);

		public Historial_ing findByIdHistorial_ing(Long id);
				
		public void eliminarHistorial_ing(Long id);
}
