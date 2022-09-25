package ista.activosfijos.api.models.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import ista.activosfijos.api.models.entity.primary.Edificio;


public interface EdificiosRepository extends JpaRepository<Edificio, Long> {

	
}
