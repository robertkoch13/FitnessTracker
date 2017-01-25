package za.co.entelect.jbootcamp.FitnessTracker.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.FitnessTracker.domain.DeviceType;

public interface DeviceTypeRepository extends JpaRepository<DeviceType, Integer> {
}
