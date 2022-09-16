package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.entity.primary.Procedencia;


public interface IProcedenciaService {

	// Metodos CRUD
	
		public List<Procedencia> findAllProcedencia();
				
		public Procedencia guardarProcedencia(Procedencia activo);

		public Procedencia findByIdProcedencia(Long id);
				
		public void eliminarProcedencia(Long id);
}
