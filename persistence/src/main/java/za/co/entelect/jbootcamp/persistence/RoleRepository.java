package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
