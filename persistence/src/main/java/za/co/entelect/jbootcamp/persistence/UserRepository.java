package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
