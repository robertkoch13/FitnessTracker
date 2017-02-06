package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.Device;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
    Device findDeviceByDeviceName(String deviceName);
    List<Device> findByDeviceNameContaining(String deviceName);
    Page<Device> findByDeviceNameContaining(String deviceName, Pageable pageable);
    List<Device> findByDeviceTypeName(String deviceTypeName);
    Page<Device> findByDeviceTypeName(String deviceTypeName, Pageable pageable);
    List<Device> findByDeviceManufacturerName(String deviceManufacturerName);
    Page<Device> findByDeviceManufacturerName(String deviceManufacturerName, Pageable pageable);
}
