package za.co.entelect.jbootcamp.FitnessTracker.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.FitnessTracker.domain.UnitOfMeasurement;

public interface UnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Integer> {
}
