package ista.activosfijos.api.models.dao.primary;

import ista.activosfijos.api.models.entity.primary.ERol;
import ista.activosfijos.api.models.entity.primary.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositoryDao extends JpaRepository<Rol,Long> {

    public Rol findByNombre(ERol nombre);
}
