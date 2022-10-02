package ista.activosfijos.api.models.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import ista.activosfijos.api.models.entity.primary.Departamento;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DepartamentosRepository extends JpaRepository<Departamento, Long> {
    @Query(value = "SELECT * FROM departamento WHERE id_edificio = ?",
            nativeQuery = true
    )
    List<Departamento> buscarDepartamentoPorEdifico(long id);

    @Query(value = "SELECT d.nombre_departamento FROM departamento d WHERE UPPER(d.nombre_departamento) = UPPER(?)",
            nativeQuery = true
    )
    List<?> validarNombreDepartamento(String nombre_departamento);

}
