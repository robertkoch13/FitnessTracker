package za.co.entelect.jbootcamp.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.entelect.jbootcamp.domain.*;
import za.co.entelect.jbootcamp.persistence.*;
import za.co.entelect.jbootcamp.services.DeviceService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DeviceServiceImpl extends GenericServiceImpl<Device, DeviceRepository> implements DeviceService {

    @Override
    public Page<Device> findByProperty(String property, String searchCriteria, Pageable pageable) {
        if(property.toUpperCase().equals("DEVICE NAME")) {
            return repository.findByDeviceNameContaining(searchCriteria, pageable);
        } else if(property.toUpperCase().equals("DEVICE TYPE")) {
            return repository.findByDeviceTypeName(searchCriteria, pageable);
        } else if(property.toUpperCase().equals("DEVICE MANUFACTURER")) {
            return repository.findByDeviceManufacturerName(searchCriteria, pageable);
        } else
            return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public List<String> getSearchProperties() {
        return Arrays.asList("Device Name", "Device Type", "Device Manufacturer");
    }
}
