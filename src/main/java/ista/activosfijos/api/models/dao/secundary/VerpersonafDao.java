package ista.activosfijos.api.models.dao.secundary;

import ista.activosfijos.api.models.entity.secundary.verpersonaf;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VerpersonafDao extends JpaRepository<verpersonaf, String> {
	
    Boolean existsByCedula (String cedula);

}
