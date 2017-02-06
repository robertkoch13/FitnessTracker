package za.co.entelect.jbootcamp.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import za.co.entelect.jbootcamp.domain.DeviceManufacturer;
import za.co.entelect.jbootcamp.services.DeviceService;

import java.text.ParseException;
import java.util.Locale;

public class DeviceManufacturerFormatter implements Formatter<DeviceManufacturer> {

    @Autowired
    private DeviceService deviceService;

    public DeviceManufacturerFormatter() {
        super();
    }

    public DeviceManufacturer parse(final String text, final Locale locale) throws ParseException {
        final Integer deviceManufacturerId = Integer.valueOf(text);
        return this.deviceService.findDeviceManufacturerById(deviceManufacturerId);
    }


    public String print(final DeviceManufacturer object, final Locale locale) {
        return (object != null ? Integer.toString(object.getId()) : "");
    }

}
