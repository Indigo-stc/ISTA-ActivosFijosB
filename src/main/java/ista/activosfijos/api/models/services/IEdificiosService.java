package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.entity.primary.Edificio;


public interface IEdificiosService {
	
	public List<Edificio> findAllEdificio();
	
	public Edificio guardarEdificio(Edificio edificio);

	public Edificio findByIdEdificio(Long id);
			
	public void eliminarEdificio(Long id);

	List<?>  validarExistenciaNombreEdificio(String nombre_edificio);

}
