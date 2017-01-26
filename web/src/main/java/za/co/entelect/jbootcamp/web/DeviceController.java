package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.entelect.jbootcamp.domain.Device;
import za.co.entelect.jbootcamp.services.DeviceService;

@Controller
public class DeviceController {
    private DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @RequestMapping("/device/show")
    public String show(@RequestParam("name") String name, Model model) {
        Device device = deviceService.searchForDeviceByDeviceName(name);
        model.addAttribute("device", device);
        return "deviceView";
    }
}
