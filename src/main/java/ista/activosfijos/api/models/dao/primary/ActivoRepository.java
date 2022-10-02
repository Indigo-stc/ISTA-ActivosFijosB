package ista.activosfijos.api.models.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import ista.activosfijos.api.models.entity.primary.Activo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ActivoRepository extends JpaRepository<Activo, Long> {
    @Query(value = "SELECT a.codigo_activo FROM activo a WHERE a.codigo_activo = ?",
            nativeQuery = true
    )
    List<?> validarCodigoActivos(String codigo_activo);


	
}


// Necesitamos los servisos para poder ser implementados