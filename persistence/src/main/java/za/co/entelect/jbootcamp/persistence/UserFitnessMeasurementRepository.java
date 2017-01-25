package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.UserFitnessMeasurement;

public interface UserFitnessMeasurementRepository extends JpaRepository<UserFitnessMeasurement, Integer> {
}
