package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.Device;

import java.util.List;

public interface DeviceService {
    Device findById(int id);
    List<Device> findAll();
    Page<Device> findAll(Pageable pageable);
    List<Device> findByProperty(String property, String searchCriteria);
    Page<Device> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    Device create(Device object);
    Device update(Device object);
    List<String> getSearchProperties();
}
