package za.co.entelect.jbootcamp.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import za.co.entelect.jbootcamp.domain.Device;
import za.co.entelect.jbootcamp.services.DeviceService;

import java.text.ParseException;
import java.util.Locale;

public class DeviceFormatter implements Formatter<Device> {

    @Autowired
    private DeviceService deviceService;

    public DeviceFormatter() { super(); }

    public Device parse(final String text, final Locale locale) throws ParseException {
        final Integer id = Integer.valueOf(text);
        return this.deviceService.findById(id);
    }

    public String print(final Device object, final Locale locale) {
        return (object != null ? Integer.toString(object.getId()) : "");
    }

}
