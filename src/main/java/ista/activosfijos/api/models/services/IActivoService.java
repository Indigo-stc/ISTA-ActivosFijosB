package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.entity.primary.Activo;



public interface IActivoService {

	// METOD CRUD
	public List<Activo> findAllActivo();
			
	public Activo guardarActivo(Activo activo);

	public Activo findByIdActivo(Long id);
			
	public void eliminarActivo(Long id);

	List<?>  validarExistenciaCodigoActivo(String codigo_activo);
}
