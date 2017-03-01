package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import za.co.entelect.jbootcamp.domain.*;
import za.co.entelect.jbootcamp.enums.Gender;
import za.co.entelect.jbootcamp.enums.SystemOfMeasurement;
import za.co.entelect.jbootcamp.models.DashboardFilterObjectModel;
import za.co.entelect.jbootcamp.models.SearchObjectModel;
import za.co.entelect.jbootcamp.models.UserDeviceModel;
import za.co.entelect.jbootcamp.models.UserFitnessProfileModel;
import za.co.entelect.jbootcamp.services.*;
import za.co.entelect.jbootcamp.services.model.UserFitnessMeasurementModel;
import za.co.entelect.jbootcamp.services.model.UserFitnessMeasurementsFrequency;
import za.co.entelect.jbootcamp.utils.MyUtils;
import za.co.entelect.jbootcamp.utils.PagingBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserProfileController {

    private UserProfileService userProfileService;
    private UserDeviceService userDeviceService;
    private DeviceService deviceService;
    private UserGoalService userGoalService;
    private UserFitnessMeasurementService userFitnessMeasurementService;
    private MeasurementTypeService measurementTypeService;
    private PagingBuilder pagingBuilder;

    @Autowired
    public UserProfileController(UserProfileService userProfileService,
                                 UserDeviceService userDeviceService,
                                 DeviceService deviceService,
                                 UserGoalService userGoalService,
                                 UserFitnessMeasurementService userFitnessMeasurementService,
                                 MeasurementTypeService measurementTypeService,
                                 PagingBuilder pagingBuilder) {
        this.userProfileService = userProfileService;
        this.userDeviceService = userDeviceService;
        this.deviceService = deviceService;
        this.userGoalService = userGoalService;
        this.userFitnessMeasurementService = userFitnessMeasurementService;
        this.measurementTypeService = measurementTypeService;
        this.pagingBuilder = pagingBuilder;
    }

    @ModelAttribute("allDevices")
    public List<Device> populateDevices() {
        return this.deviceService.findAll();
    }

    private ModelAndView getDashboardModelAndView(DashboardFilterObjectModel dashboardFilterObjectModel, UserFitnessMeasurementModel userFitnessMeasurementModel) {
        if(dashboardFilterObjectModel == null) {
            dashboardFilterObjectModel = new DashboardFilterObjectModel(new Date(), new Date());
        }
        ModelAndView modelAndView = new ModelAndView("dashboard/dashboard");
        List<UserFitnessMeasurementsFrequency> userFitnessMeasurementsFrequencies = Arrays.asList(UserFitnessMeasurementsFrequency.values());
        modelAndView.addObject("allUserFitnessMeasurementsFrequencies",userFitnessMeasurementsFrequencies);
        modelAndView.addObject("allMeasurementTypes", measurementTypeService.findAll());
        modelAndView.addObject("dashboardFilterObject", dashboardFilterObjectModel);
        modelAndView.addObject("measurementCalculation", userFitnessMeasurementModel);

        return modelAndView;
    }

    @GetMapping({"", "/dashboard"})
    public ModelAndView root() {
        return getDashboardModelAndView(null, null);
    }

    @GetMapping("/dashboard/{measurementType}/{frequency}/{fromDate}/{toDate}")
    public ModelAndView root(@PathVariable Map<String, String> pathVariables) {
        DashboardFilterObjectModel dashboardFilterObjectModel = null;
        UserFitnessMeasurementModel userFitnessMeasurementModel = null;

        if (pathVariables.containsKey("measurementType")
                & pathVariables.containsKey("frequency")
                & pathVariables.containsKey("fromDate")
                & pathVariables.containsKey("toDate")) {

            Date fromDate = MyUtils.convertStringToDate(pathVariables.get("fromDate"), "yyyy-MM-dd");
            Date toDate = MyUtils.convertStringToDate(pathVariables.get("toDate"), "yyyy-MM-dd");
            String measurementType = pathVariables.get("measurementType");
            UserFitnessMeasurementsFrequency frequency = UserFitnessMeasurementsFrequency.valueOf(pathVariables.get("frequency"));

            userFitnessMeasurementModel = userFitnessMeasurementService.getCalculatedMeasurements(
                    userProfileService.findByUsername(getPrincipal()).getId(),
                    measurementType,
                    fromDate,
                    toDate,
                    frequency);

            dashboardFilterObjectModel = new DashboardFilterObjectModel(
                    measurementType, frequency, fromDate, toDate
            );
        }

        return getDashboardModelAndView(dashboardFilterObjectModel, userFitnessMeasurementModel);
    }


    @PostMapping({"/dashboard", "/"})
    public String getDashboardReport(@ModelAttribute DashboardFilterObjectModel dashboardFilterObjectModel) {
        return String.format("redirect:/dashboard/%s/%s/%s/%s",
                dashboardFilterObjectModel.getMeasurementType(),
                dashboardFilterObjectModel.getUserFitnessMeasurementsFrequency(),
                MyUtils.convertDateToString(dashboardFilterObjectModel.getFromDate(),"yyyy-MM-dd"),
                MyUtils.convertDateToString(dashboardFilterObjectModel.getToDate(),"yyyy-MM-dd"));
    }

    @RequestMapping( "/mydevices" )
    public ModelAndView showMyDevices(Pageable pageable) {

        String viewName = "dashboard/myDevices";

        Page<UserDevice> userDevices =  userDeviceService.findByUserId(userProfileService.findByUsername(getPrincipal()).getId(), pageable);

        return pagingBuilder.getModelAndView(viewName, userDevices, pageable);
    }

    @GetMapping("/dashboard/mydevice/add")
    public String addDevice(Model model) {
        model.addAttribute("device", new UserDeviceModel());
        return "dashboard/addDevice";
    }

    @PostMapping("/dashboard/mydevice/add")
    public String addDeviceSubmit(@ModelAttribute UserDeviceModel device) {
        userDeviceService.addDeviceToUser(getPrincipal(), device.getDeviceId(), device.getName(), device.getSerialNumber(), true);
        return "redirect:/mydevices";
    }

    @GetMapping("/dashboard/mydevice/edit")
    public String editDevice(@RequestParam("id") int id, Model model) {
        UserDevice userDevice = userDeviceService.findById(id);
        model.addAttribute("device", new UserDeviceModel(userDevice.getDevice().getId(), userDevice.getName(), userDevice.getSerialNumber(), userDevice.getActive()));
        model.addAttribute("collection", userFitnessMeasurementService.findDevicesByUserDeviceLastMonth(userDevice.getName()));
        return "dashboard/editDevice";
    }

    @PostMapping("/dashboard/mydevice/edit")
    public String editDeviceSubmit(@ModelAttribute UserDeviceModel device) {
        UserDevice userDevice = userDeviceService.findById(device.getDeviceId());
        userDevice.setName(device.getName());
        userDevice.setActive(device.getActive());
        userDevice.setSerialNumber(device.getSerialNumber());
        userDeviceService.update(userDevice);
        return "redirect:/mydevices";
    }

    @RequestMapping( "/mygoals" )
    public ModelAndView showMyGoals(Pageable pageable) {

        String viewName = "dashboard/myGoals";

        Page<UserGoal> userGoals =  userGoalService.findByUserId(userProfileService.findByUsername(getPrincipal()).getId(), pageable);

        return pagingBuilder.getModelAndView(viewName, userGoals, pageable);
    }

    @GetMapping("/myprofile")
    public String updateProfile(Model model) {
        UserFitnessProfile userFitnessProfile = userProfileService.findByUsername(getPrincipal()).getUserFitnessProfile();
        model.addAttribute("userProfile", new UserFitnessProfileModel(userFitnessProfile.getId(), userFitnessProfile.getGender(), userFitnessProfile.getDateOfBirth(), userFitnessProfile.getSystemOfMeasurementPreference()));
        List<Gender> allGenders = Arrays.asList(Gender.values());
        model.addAttribute("allGenders",allGenders);
        List<SystemOfMeasurement> allSystemOfMeasurementPreferences = Arrays.asList(SystemOfMeasurement.values());
        model.addAttribute("allSystemOfMeasurementPreferences",allSystemOfMeasurementPreferences);
        return "dashboard/myProfile";
    }

    @PostMapping("/myprofile")
    public String updateProfile(@ModelAttribute UserFitnessProfileModel userFitnessProfileModel) {
        userProfileService.updateUserFitnessProfile(getPrincipal(), userFitnessProfileModel.getGender(), userFitnessProfileModel.getSystemOfMeasurementPreference(), userFitnessProfileModel.getDob());
        return "redirect:/dashboard";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
