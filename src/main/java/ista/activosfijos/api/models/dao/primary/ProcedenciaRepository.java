package ista.activosfijos.api.models.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import ista.activosfijos.api.models.entity.primary.Procedencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedenciaRepository extends JpaRepository< Procedencia, Long> {

    @Query(value = "SELECT p.nombre_procedencia FROM procedencia p WHERE UPPER(p.nombre_procedencia) = UPPER(?)",
            nativeQuery = true
    )
    List<?> validarNombreProcedencia(String nombre_procedencia);

}
