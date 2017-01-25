package za.co.entelect.jbootcamp.FitnessTracker.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.FitnessTracker.domain.MeasurementFrequency;

public interface MeasurementFrequencyRepository extends JpaRepository<MeasurementFrequency, Integer> {
}
