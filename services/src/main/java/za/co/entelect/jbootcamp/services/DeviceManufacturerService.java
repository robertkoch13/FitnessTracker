package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.DeviceManufacturer;

import java.util.List;

public interface DeviceManufacturerService {
    DeviceManufacturer findById(int id);
    List<DeviceManufacturer> findAll();
    Page<DeviceManufacturer> findAll(Pageable pageable);
    List<DeviceManufacturer> findByProperty(String property, String searchCriteria);
    Page<DeviceManufacturer> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    DeviceManufacturer create(DeviceManufacturer object);
    DeviceManufacturer update(DeviceManufacturer object);
    List<String> getSearchProperties();
}
