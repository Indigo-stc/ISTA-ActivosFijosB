package ista.activosfijos.api.models.dao.primary;

import ista.activosfijos.api.models.entity.primary.ERol;
import ista.activosfijos.api.models.entity.primary.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RolRepositoryDao extends JpaRepository<Rol,Long> {

    Rol findByNombre(ERol nombre);

    //Optional<Rol> findByName(ERol name);
}
