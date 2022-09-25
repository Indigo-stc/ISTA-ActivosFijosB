package ista.activosfijos.api.models.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import ista.activosfijos.api.models.entity.primary.Departamento;


public interface DepartamentosRepository extends JpaRepository<Departamento, Long> {

}
