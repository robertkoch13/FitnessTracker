package za.co.entelect.jbootcamp.FitnessTracker.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.FitnessTracker.domain.UserGoal;

public interface UserGoalRepository extends JpaRepository<UserGoal, Integer> {
}
