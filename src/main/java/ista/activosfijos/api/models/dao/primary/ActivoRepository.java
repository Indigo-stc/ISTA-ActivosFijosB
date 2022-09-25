package ista.activosfijos.api.models.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import ista.activosfijos.api.models.entity.primary.Activo;




public interface ActivoRepository extends JpaRepository<Activo, Long> {

	
}


// Necesitamos los servisos para poder ser implementados