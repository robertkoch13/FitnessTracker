package za.co.entelect.jbootcamp.FitnessTracker.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.FitnessTracker.domain.UserFitnessMeasurement;

public interface UserFitnessMeasurementRepository extends JpaRepository<UserFitnessMeasurement, Integer> {
}
