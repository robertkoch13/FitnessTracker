package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
