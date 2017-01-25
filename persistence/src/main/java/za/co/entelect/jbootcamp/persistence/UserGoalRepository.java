package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.UserGoal;

public interface UserGoalRepository extends JpaRepository<UserGoal, Integer> {
}
