package za.co.entelect.jbootcamp.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import za.co.entelect.jbootcamp.domain.DeviceType;
import za.co.entelect.jbootcamp.services.DeviceTypeService;
import java.text.ParseException;
import java.util.Locale;

public class DeviceTypeFormatter implements Formatter<DeviceType> {

    @Autowired
    private DeviceTypeService deviceTypeService;

    public DeviceTypeFormatter() { super(); }

    public DeviceType parse(final String text, final Locale locale) throws ParseException {
        final Integer id = Integer.valueOf(text);
        return this.deviceTypeService.findById(id);
    }

    public String print(final DeviceType object, final Locale locale) {
        return (object != null ? Integer.toString(object.getId()) : "");
    }

}
