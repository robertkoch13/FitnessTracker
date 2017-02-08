package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.UserGoal;

public interface UserGoalRepository extends JpaRepository<UserGoal, Integer> {
    Page<UserGoal> findByUserFitnessProfileId(int userId, Pageable pageable);
}
