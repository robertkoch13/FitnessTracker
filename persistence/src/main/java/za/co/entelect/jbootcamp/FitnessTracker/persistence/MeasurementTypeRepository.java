package za.co.entelect.jbootcamp.FitnessTracker.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.FitnessTracker.domain.MeasurementType;

public interface MeasurementTypeRepository extends JpaRepository<MeasurementType, Integer> {
}
