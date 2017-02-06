package za.co.entelect.jbootcamp.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.entelect.jbootcamp.domain.DeviceManufacturer;
import za.co.entelect.jbootcamp.persistence.DeviceManufacturerRepository;
import za.co.entelect.jbootcamp.services.DeviceManufacturerService;

import java.util.List;

@Service
public class DeviceManufacturerServiceImpl extends GenericServiceImpl<DeviceManufacturer, DeviceManufacturerRepository> implements DeviceManufacturerService {
    @Override
    public Page<DeviceManufacturer> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return null;
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }
}
