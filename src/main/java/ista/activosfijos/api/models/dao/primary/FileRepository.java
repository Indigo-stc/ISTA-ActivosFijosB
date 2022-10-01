package ista.activosfijos.api.models.dao.primary;

import ista.activosfijos.api.models.entity.primary.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, String> {
}
