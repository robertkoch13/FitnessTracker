package za.co.entelect.jbootcamp.FitnessTracker.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.FitnessTracker.domain.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
