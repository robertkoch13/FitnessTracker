package za.co.entelect.jbootcamp.FitnessTracker.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.FitnessTracker.domain.UserFitnessProfile;

public interface UserFitnessProfileRepository extends JpaRepository<UserFitnessProfile, Integer> {
}
