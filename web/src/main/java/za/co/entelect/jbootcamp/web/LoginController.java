package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import za.co.entelect.jbootcamp.domain.Role;
import za.co.entelect.jbootcamp.domain.UserProfile;
import za.co.entelect.jbootcamp.models.LoginUser;
import za.co.entelect.jbootcamp.services.UserProfileService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    private UserProfileService userProfileService;

    @Autowired
    public LoginController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @RequestMapping(value = "/createlogin", method = RequestMethod.GET)
    public ModelAndView createLogin() {
        List<UserProfile> userProfileList = userProfileService.findUserProfileAll();
        LoginUser loginUser = new LoginUser();
        ModelMap model = new ModelMap();
        model.addAttribute("userProfileList", userProfileList);
        model.addAttribute("loginUser", loginUser);
        return new ModelAndView("createlogin", model);
    }

    @RequestMapping(value = "/createlogin", method = RequestMethod.POST)
    public ModelAndView createLoginPost(
            @ModelAttribute("loginUser") @Valid LoginUser loginUser,
            BindingResult bindingResult) {

        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(loginUser.getUsername());
        userProfile.setPassword(hashWithSha256(loginUser.getPassword(), loginUser.getUsername()));

        userProfile.setFirstName(loginUser.getFirstName());
        userProfile.setLastName(loginUser.getLastName());

        userProfile = userProfileService.createUserProfile(userProfile);

        Role role = userProfileService.findRoleByName("Standard");
        userProfile.getRoles().add(role);

        userProfileService.createUserProfile(userProfile);

        return new ModelAndView("redirect:/login", null);
    }
    public static String hashWithSha256(String value, String salt) {
        BasePasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);
        return  passwordEncoder.encodePassword(value, salt);
    }


}
