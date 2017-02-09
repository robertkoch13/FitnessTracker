package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import za.co.entelect.jbootcamp.domain.Device;
import za.co.entelect.jbootcamp.domain.DeviceManufacturer;
import za.co.entelect.jbootcamp.domain.DeviceType;
import za.co.entelect.jbootcamp.models.SearchObjectModel;
import za.co.entelect.jbootcamp.services.DeviceManufacturerService;
import za.co.entelect.jbootcamp.services.DeviceService;
import za.co.entelect.jbootcamp.services.DeviceTypeService;
import za.co.entelect.jbootcamp.utils.PagingBuilder;
import java.util.List;
import java.util.Map;

@Controller
public class DeviceController {

    private DeviceService deviceService;
    private DeviceManufacturerService deviceManufacturerService;
    private DeviceTypeService deviceTypeService;
    private PagingBuilder pagingBuilder;

    @Autowired
    public DeviceController(DeviceService deviceService, DeviceManufacturerService deviceManufacturerService, DeviceTypeService deviceTypeService, PagingBuilder pagingBuilder) {
        this.deviceService = deviceService;
        this.deviceManufacturerService = deviceManufacturerService;
        this.deviceTypeService = deviceTypeService;
        this.pagingBuilder = pagingBuilder;
    }

    @ModelAttribute("allDeviceTypes")
    public List<DeviceType> populateDeviceTypes() {
        return this.deviceTypeService.findAll();
    }

    @ModelAttribute("allDeviceManufacturers")
    public List<DeviceManufacturer> populateManufacturers() {
        return this.deviceManufacturerService.findAll();
    }

    @RequestMapping({ "/devices/{property}/{value}", "/devices" })
    public ModelAndView showDevices(@PathVariable Map<String, String> pathVariables, Pageable pageable) {

        String viewName = "devices/devicesView";

        Page<Device> devices;
        if (pathVariables.containsKey("property") & pathVariables.containsKey("value")) {
            devices = deviceService.findByProperty(pathVariables.get("property"), pathVariables.get("value"), pageable);
        } else {
            devices = deviceService.findAll(pageable);
        }

        return pagingBuilder.getModelAndView(viewName, devices, pageable);
    }

    @GetMapping("/devices/search")
    public String deviceSearchForm(Model model) {
        model.addAttribute("searchObject", new SearchObjectModel("Device Name", "", deviceService.getSearchProperties()));
        return "devices/devicesSearch";
    }

    @PostMapping("/devices/search")
    public String deviceSearchSubmit(@ModelAttribute SearchObjectModel searchObjectModel) {
        return String.format("redirect:/devices/%s/%s", searchObjectModel.getProperty(), searchObjectModel.getValue());
    }

    @GetMapping("/admin/device/add")
    public String addDevice(Model model) {
        model.addAttribute("device", new Device());
        return "devices/addDevice";
    }

    @PostMapping("/admin/device/add")
    public String addDeviceSubmit(@ModelAttribute Device device) {
        deviceService.create(device);
        return "redirect:/devices";
    }

    @GetMapping("/admin/device/edit")
    public String editDevice(@RequestParam("id") int id, Model model) {
        model.addAttribute("device", deviceService.findById(id));
        return "devices/editDevice";
    }

    @PostMapping("/admin/device/edit")
    public String editDeviceSubmit(@ModelAttribute Device device) {
        deviceService.update(device);
        return "redirect:/devices";
    }

    @RequestMapping({"/devices/manufacturers/{property}/{value}", "/devices/manufacturers"})
    public ModelAndView showDeviceManufacturers(@PathVariable Map<String, String> pathVariables, Pageable pageable) {

        String viewName = "devices/deviceManufacturersView";

        Page<DeviceManufacturer> deviceManufacturers;
        if (pathVariables.containsKey("property") & pathVariables.containsKey("value")) {
            deviceManufacturers = deviceManufacturerService.findByProperty(pathVariables.get("property"), pathVariables.get("value"), pageable);
        } else {
            deviceManufacturers = deviceManufacturerService.findAll(pageable);
        }

        return pagingBuilder.getModelAndView(viewName, deviceManufacturers, pageable);
    }

    @GetMapping("/admin/devicemanufacturer/add")
    public String addDeviceManufacturer(Model model) {
        model.addAttribute("deviceManufacturer", new DeviceManufacturer());
        return "devices/addDeviceManufacturer";
    }

    @PostMapping("/admin/devicemanufacturer/add")
    public String addDeviceManufacturerSubmit(@ModelAttribute DeviceManufacturer deviceManufacturer) {
        deviceManufacturerService.create(deviceManufacturer);
        return "redirect:/devices/manufacturers";
    }

    @GetMapping("/admin/devicemanufacturer/edit")
    public String editDeviceManufacturer(@RequestParam("id") int id, Model model) {
        model.addAttribute("deviceManufacturer", deviceManufacturerService.findById(id));
        return "devices/editDeviceManufacturer";
    }

    @PostMapping("/admin/devicemanufacturer/edit")
    public String editDeviceManufacturerSubmit(@ModelAttribute DeviceManufacturer deviceManufacturer) {
        deviceManufacturerService.update(deviceManufacturer);
        return "redirect:/devices/manufacturers";
    }

    @RequestMapping({"/devices/types/{property}/{value}", "/devices/types"})
    public ModelAndView showDeviceTypes(@PathVariable Map<String, String> pathVariables, Pageable pageable) {

        String viewName = "devices/deviceTypesView";

        Page<DeviceType> deviceTypes;
        if (pathVariables.containsKey("property") & pathVariables.containsKey("value")) {
            deviceTypes = deviceTypeService.findByProperty(pathVariables.get("property"), pathVariables.get("value"), pageable);
        } else {
            deviceTypes = deviceTypeService.findAll(pageable);
        }

        return pagingBuilder.getModelAndView(viewName, deviceTypes, pageable);
    }

    @GetMapping("/admin/devicetype/add")
    public String addDeviceType(Model model) {
        model.addAttribute("deviceType", new DeviceType());
        return "devices/addDeviceType";
    }

    @PostMapping("/admin/devicetype/add")
    public String addDeviceTypeSubmit(@ModelAttribute DeviceType deviceType) {
        deviceTypeService.create(deviceType);
        return "redirect:/devices/types";
    }

    @GetMapping("/admin/devicetype/edit")
    public String editDeviceType(@RequestParam("id") int id, Model model) {
        model.addAttribute("deviceType", deviceTypeService.findById(id));
        return "devices/editDeviceType";
    }

    @PostMapping("/admin/devicetype/edit")
    public String editDeviceTypeSubmit(@ModelAttribute DeviceType deviceType) {
        deviceTypeService.update(deviceType);
        return "redirect:/devices/types";
    }

}
