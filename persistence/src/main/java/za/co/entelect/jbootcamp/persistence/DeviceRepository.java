package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
    Device findDeviceByDeviceName(String deviceName);
}
