package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.MeasurementType;

public interface MeasurementTypeRepository extends JpaRepository<MeasurementType, Integer> {
}
