package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import za.co.entelect.jbootcamp.domain.Device;
import za.co.entelect.jbootcamp.models.SearchObject;
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

    @GetMapping("/devices/search")
    public String deviceSearchForm(Model model) {
        model.addAttribute("searchObject", new SearchObject("Device Name", ""));
        return "devicesSearch";
    }

    @PostMapping("/devices/search")
    public String deviceSearchSubmit(@ModelAttribute SearchObject searchObject) {
        return String.format("redirect:/devices/findbyproperty?property=%s&value=%s", searchObject.getProperty(), searchObject.getValue());
    }

}
