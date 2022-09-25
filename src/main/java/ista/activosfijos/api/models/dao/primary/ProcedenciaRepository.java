package ista.activosfijos.api.models.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import ista.activosfijos.api.models.entity.primary.Procedencia;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedenciaRepository extends JpaRepository< Procedencia, Long> {


}
