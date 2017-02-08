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
import za.co.entelect.jbootcamp.domain.Device;
import za.co.entelect.jbootcamp.domain.UserDevice;
import za.co.entelect.jbootcamp.domain.UserFitnessProfile;
import za.co.entelect.jbootcamp.domain.UserGoal;
import za.co.entelect.jbootcamp.enums.Gender;
import za.co.entelect.jbootcamp.enums.SystemOfMeasurement;
import za.co.entelect.jbootcamp.models.UserDeviceModel;
import za.co.entelect.jbootcamp.models.UserFitnessProfileModel;
import za.co.entelect.jbootcamp.services.DeviceService;
import za.co.entelect.jbootcamp.services.UserDeviceService;
import za.co.entelect.jbootcamp.services.UserGoalService;
import za.co.entelect.jbootcamp.services.UserProfileService;
import za.co.entelect.jbootcamp.utils.PagingBuilder;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserProfileController {

    private UserProfileService userProfileService;
    private UserDeviceService userDeviceService;
    private DeviceService deviceService;
    private UserGoalService userGoalService;
    private PagingBuilder pagingBuilder;

    @Autowired
    public UserProfileController(UserProfileService userProfileService,
                                 UserDeviceService userDeviceService,
                                 DeviceService deviceService,
                                 UserGoalService userGoalService,
                                 PagingBuilder pagingBuilder) {
        this.userProfileService = userProfileService;
        this.userDeviceService = userDeviceService;
        this.deviceService = deviceService;
        this.userGoalService = userGoalService;
        this.pagingBuilder = pagingBuilder;
    }

    @ModelAttribute("allDevices")
    public List<Device> populateDevices() {
        return this.deviceService.findAll();
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView root() {
        return new ModelAndView("dashboard/dashboard");
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
