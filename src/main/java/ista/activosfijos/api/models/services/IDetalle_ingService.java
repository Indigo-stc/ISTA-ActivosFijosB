package ista.activosfijos.api.models.services;

import java.util.List;

import ista.activosfijos.api.models.entity.primary.Detalle_ing;



public interface IDetalle_ingService {
	
	List<Detalle_ing> findBynum_recep(String num_recep);
	
	public List<Detalle_ing> findAllDetalle_ing();
				
	public Detalle_ing guardarDetalle_ing(Detalle_ing detalle_ing);

	public Detalle_ing findByIdDetalle_ing(Long id);
				
	public void eliminarDetalle_ing(Long id);

	List<?>  contarLosDetallesTrue(Long id_encabezado_ing);
}
