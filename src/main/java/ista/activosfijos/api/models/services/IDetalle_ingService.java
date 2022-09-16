package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.entity.primary.Detalle_ing;



public interface IDetalle_ingService {
	
	// Metodos CRUD
	
		public List<Detalle_ing> findAllDetalle_ing();
				
		public Detalle_ing guardarDetalle_ing(Detalle_ing detalle_ing);

		public Detalle_ing findByIdDetalle_ing(Long id);
				
		public void eliminarDetalle_ing(Long id);
}
