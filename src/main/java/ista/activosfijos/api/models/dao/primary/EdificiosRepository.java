package ista.activosfijos.api.models.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import ista.activosfijos.api.models.entity.primary.Edificio;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EdificiosRepository extends JpaRepository<Edificio, Long> {

    @Query(value = "SELECT e.nombre_edificio FROM edificio e WHERE UPPER(e.nombre_edificio) = UPPER(?)",
            nativeQuery = true
    )
    List<?> validarNombreEdificio(String nombre_edificio);
}
