package ista.activosfijos.api.models.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import ista.activosfijos.api.models.entity.primary.Encabezado_ing;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface Encabezado_ingRepository extends JpaRepository<Encabezado_ing, Long> {

    @Query(value = "SELECT id_documento FROM documentos where nombre_documento = ?",
            nativeQuery = true
    )
    List<?> findBynombre_documento(String nombre_documento);

}