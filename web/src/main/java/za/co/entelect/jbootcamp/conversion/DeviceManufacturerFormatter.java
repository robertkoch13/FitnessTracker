package za.co.entelect.jbootcamp.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.entelect.jbootcamp.domain.DeviceManufacturer;
import za.co.entelect.jbootcamp.services.DeviceManufacturerService;

@Component
public class DeviceManufacturerFormatter extends GenericDomainFormatter<DeviceManufacturer, DeviceManufacturerService> {

    @Autowired
    public DeviceManufacturerFormatter(DeviceManufacturerService service) {
        super();
        this.service = service;
    }
}
