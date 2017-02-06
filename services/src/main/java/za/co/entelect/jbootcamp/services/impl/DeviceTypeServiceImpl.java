package za.co.entelect.jbootcamp.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.entelect.jbootcamp.domain.DeviceType;
import za.co.entelect.jbootcamp.persistence.DeviceTypeRepository;
import za.co.entelect.jbootcamp.services.DeviceTypeService;

import java.util.List;

@Service
public class DeviceTypeServiceImpl extends GenericServiceImpl<DeviceType, DeviceTypeRepository> implements DeviceTypeService {
    @Override
    public Page<DeviceType> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return null;
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }
}
