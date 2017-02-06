package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import za.co.entelect.jbootcamp.domain.Device;
import za.co.entelect.jbootcamp.domain.DeviceManufacturer;
import za.co.entelect.jbootcamp.domain.DeviceType;
import za.co.entelect.jbootcamp.utils.Pager;
import za.co.entelect.jbootcamp.models.SearchObject;
import za.co.entelect.jbootcamp.services.DeviceService;
import za.co.entelect.jbootcamp.utils.Paging;

import java.util.List;
import java.util.Map;

@Controller
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private Paging pagingConstructor;

    @ModelAttribute("allDeviceTypes")
    public List<DeviceType> populateDeviceTypes() {
        return this.deviceService.findDeviceTypeAll();
    }

    @ModelAttribute("allDeviceManufacturers")
    public List<DeviceManufacturer> populateVarieties() {
        return this.deviceService.findDeviceManufacturerAll();
    }

    @RequestMapping({ "/devices/{property}/{value}", "/devices" })
    public ModelAndView showDevices(@PathVariable Map<String, String> pathVariables,
                                    @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                    @RequestParam(value = "page", required = false) Integer page) {

        int evalPage = pagingConstructor.initialPage(page);
        int evalPageSize = pagingConstructor.initialPageSize(pageSize);
        String viewName = "devices/devicesView";

        Page<Device> devices;
        if (pathVariables.containsKey("property") & pathVariables.containsKey("value")) {
            devices = deviceService.findDeviceByProperty(pathVariables.get("property"), pathVariables.get("value"), new PageRequest(evalPage, evalPageSize));
        } else {
            devices = deviceService.findDeviceAll(new PageRequest(evalPage, evalPageSize));
        }

        return pagingConstructor.getModelAndView(viewName, devices, evalPageSize);
    }

    @GetMapping("/devices/search")
    public String deviceSearchForm(Model model) {
        model.addAttribute("searchObject", new SearchObject("Device Name", "", deviceService.getDeviceSearchProperties()));
        return "devices/devicesSearch";
    }

    @PostMapping("/devices/search")
    public String deviceSearchSubmit(@ModelAttribute SearchObject searchObject) {
        return String.format("redirect:/devices/%s/%s", searchObject.getProperty(), searchObject.getValue());
    }

    @GetMapping("/admin/devices/add")
    public String addDevice(Model model) {
        model.addAttribute("device", new Device());
        return "devices/addDevice";
    }

    @PostMapping("/admin/devices/add")
    public String addDeviceSubmit(@ModelAttribute Device device) {
        deviceService.createDevice(device);
        return "redirect:/devices";
    }

    @GetMapping("/admin/devices/edit")
    public String editDevice(@RequestParam("id") int id, Model model) {
        model.addAttribute("device", deviceService.findDeviceById(id));
        return "devices/editDevice";
    }

    @PostMapping("/admin/devices/edit")
    public String editDeviceSubmit(@ModelAttribute Device device) {
        deviceService.updateDevice(device);
        return "redirect:/devices";
    }

    @RequestMapping({"/devices/manufacturers/{property}/{value}", "/devices/manufacturers"})
    public ModelAndView showDeviceManufacturers(@PathVariable Map<String, String> pathVariables,
                                    @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                    @RequestParam(value = "page", required = false) Integer page) {

        int evalPage = pagingConstructor.initialPage(page);
        int evalPageSize = pagingConstructor.initialPageSize(pageSize);
        String viewName = "devices/deviceManufacturersView";

        Page<DeviceManufacturer> deviceManufacturers;
        if (pathVariables.containsKey("property") & pathVariables.containsKey("value")) {
            deviceManufacturers = deviceService.findDeviceManufacturerByProperty(pathVariables.get("property"), pathVariables.get("value"), new PageRequest(evalPage, evalPageSize));
        } else {
            deviceManufacturers = deviceService.findDeviceManufacturerAll(new PageRequest(evalPage, evalPageSize));
        }

        return pagingConstructor.getModelAndView(viewName, deviceManufacturers, evalPageSize);
    }

    @GetMapping("/admin/devicemanufacturer/add")
    public String addDeviceManufacturer(Model model) {
        model.addAttribute("deviceManufacturer", new DeviceManufacturer());
        return "devices/addDeviceManufacturer";
    }

    @PostMapping("/admin/devicemanufacturer/add")
    public String addDeviceManufacturerSubmit(@ModelAttribute DeviceManufacturer deviceManufacturer) {
        deviceService.createDeviceManufacturer(deviceManufacturer);
        return "redirect:/devices/manufacturers";
    }

    @GetMapping("/admin/devicemanufacturer/edit")
    public String editDeviceManufacturer(@RequestParam("id") int id, Model model) {
        model.addAttribute("deviceManufacturer", deviceService.findDeviceManufacturerById(id));
        return "devices/editDeviceManufacturer";
    }

    @PostMapping("/admin/devicemanufacturer/edit")
    public String editDeviceManufacturerSubmit(@ModelAttribute DeviceManufacturer deviceManufacturer) {
        deviceService.updateDeviceManufacturer(deviceManufacturer);
        return "redirect:/devices/manufacturers";
    }

    @RequestMapping({"/devices/types/{property}/{value}", "/devices/types"})
    public ModelAndView showDeviceTypes(@PathVariable Map<String, String> pathVariables,
                                                @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                @RequestParam(value = "page", required = false) Integer page) {

        int evalPage = pagingConstructor.initialPage(page);
        int evalPageSize = pagingConstructor.initialPageSize(pageSize);
        String viewName = "devices/deviceTypesView";

        Page<DeviceType> deviceTypes;
        if (pathVariables.containsKey("property") & pathVariables.containsKey("value")) {
            deviceTypes = deviceService.findDeviceTypeByProperty(pathVariables.get("property"), pathVariables.get("value"), new PageRequest(evalPage, evalPageSize));
        } else {
            deviceTypes = deviceService.findDeviceTypeAll(new PageRequest(evalPage, evalPageSize));
        }

        return pagingConstructor.getModelAndView(viewName, deviceTypes, evalPageSize);
    }

    @GetMapping("/admin/devicetype/add")
    public String addDeviceType(Model model) {
        model.addAttribute("deviceType", new DeviceType());
        return "devices/addDeviceType";
    }

    @PostMapping("/admin/devicetype/add")
    public String addDeviceTypeSubmit(@ModelAttribute DeviceType deviceType) {
        deviceService.createDeviceType(deviceType);
        return "redirect:/devices/types";
    }

    @GetMapping("/admin/devicetype/edit")
    public String editDeviceType(@RequestParam("id") int id, Model model) {
        model.addAttribute("deviceType", deviceService.findDeviceTypeById(id));
        return "devices/editDeviceType";
    }

    @PostMapping("/admin/devicetype/edit")
    public String editDeviceTypeSubmit(@ModelAttribute DeviceType deviceType) {
        deviceService.updateDeviceType(deviceType);
        return "redirect:/devices/types";
    }

}
