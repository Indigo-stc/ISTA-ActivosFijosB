package ista.activosfijos.api.models.dao.primary;

import ista.activosfijos.api.models.entity.primary.Detalle_Constatacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Detalle_constatacionRepository extends JpaRepository<Detalle_Constatacion, Long> {
}
