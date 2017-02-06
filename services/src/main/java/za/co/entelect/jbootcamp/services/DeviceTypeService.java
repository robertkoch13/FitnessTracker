package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.DeviceType;

import java.util.List;

public interface DeviceTypeService {
    DeviceType findById(int id);
    List<DeviceType> findAll();
    Page<DeviceType> findAll(Pageable pageable);
    List<DeviceType> findByProperty(String property, String searchCriteria);
    Page<DeviceType> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    DeviceType create(DeviceType object);
    DeviceType update(DeviceType object);
    List<String> getSearchProperties();
}
