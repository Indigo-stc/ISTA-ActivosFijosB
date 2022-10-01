package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.entity.primary.Encabezado_ing;


public interface IEncabezado_ingService {

	public List<Encabezado_ing> findAllEncabezado_ing();
	
	public Encabezado_ing guardarEncabezado_ing(Encabezado_ing encabezado_ing);

	public Encabezado_ing findByIdEncabezado_ing(Long id);
			
	public void eliminarEncabezado_ing(Long id);

	List<?> findBynombre_documento(String nombre_documento);
}
