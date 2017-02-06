package za.co.entelect.jbootcamp.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.entelect.jbootcamp.domain.DeviceType;
import za.co.entelect.jbootcamp.services.DeviceTypeService;

@Component
public class DeviceTypeFormatter extends GenericDomainFormatter<DeviceType, DeviceTypeService> {

    @Autowired
    public DeviceTypeFormatter(DeviceTypeService service) {
        super();
        this.service = service;
    }
}
