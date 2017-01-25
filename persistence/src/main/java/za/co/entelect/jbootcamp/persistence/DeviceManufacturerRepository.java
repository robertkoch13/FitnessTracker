package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.DeviceManufacturer;

public interface DeviceManufacturerRepository extends JpaRepository<DeviceManufacturer, Integer> {
}
