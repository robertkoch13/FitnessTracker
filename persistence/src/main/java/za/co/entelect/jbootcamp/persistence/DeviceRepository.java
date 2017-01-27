package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.Device;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
    List<Device> findDeviceByDeviceName(String deviceName);
    Page<Device> findDeviceByDeviceName(String deviceName, Pageable pageable);
    List<Device> findDeviceByDeviceNameContaining(String deviceName);
    Page<Device> findDeviceByDeviceNameContaining(String deviceName, Pageable pageable);
}
