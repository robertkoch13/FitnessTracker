package za.co.entelect.jbootcamp.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.entelect.jbootcamp.domain.Device;
import za.co.entelect.jbootcamp.services.DeviceService;

@Component
public class DeviceFormatter extends GenericDomainFormatter<Device, DeviceService> {

    @Autowired
    public DeviceFormatter(DeviceService service) {
        super();
        this.service = service;
    }

}
