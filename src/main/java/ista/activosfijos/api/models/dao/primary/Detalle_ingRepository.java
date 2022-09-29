package ista.activosfijos.api.models.dao.primary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ista.activosfijos.api.models.entity.primary.Detalle_ing;


public interface Detalle_ingRepository extends JpaRepository<Detalle_ing, Long>{

	@Query(value = "SELECT * FROM encabezado_ing e inner Join detalle_ing d  on d.id_encabezado_ing = e.id_encabezado_ing and d.estado_detalle=false and e.num_recep = ?",
			nativeQuery = true
	)
	List<Detalle_ing> findBynum_recep(String num_recep);

	@Query(value = "SELECT count(d.id_detalle_ing) FROM detalle_ing d WHERE d.id_encabezado_ing = ? AND d.estado_detalle = false",
			nativeQuery = true
	)
	List<?> contarLosDetalles(Long id_encabezado_ing);

}
