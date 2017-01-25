package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.MeasurementFrequency;

public interface MeasurementFrequencyRepository extends JpaRepository<MeasurementFrequency, Integer> {
}
