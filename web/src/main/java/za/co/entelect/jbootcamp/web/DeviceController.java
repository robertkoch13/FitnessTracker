package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.entelect.jbootcamp.domain.Device;
import za.co.entelect.jbootcamp.services.DeviceService;

import java.util.List;

@Controller
public class DeviceController {
    private DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @RequestMapping("/devices/findbyproperty")
    public String show(@RequestParam("property") String property, @RequestParam("value") String value, Model model) {
        List<Device> devices = deviceService.findDeviceByProperty(property, value);
        model.addAttribute("devices", devices);
        return "devicesView";
    }
}
