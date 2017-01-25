package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.DeviceType;

public interface DeviceTypeRepository extends JpaRepository<DeviceType, Integer> {
}
