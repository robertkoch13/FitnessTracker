package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import za.co.entelect.jbootcamp.services.UserProfileService;

@Controller
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView root() {
        return new ModelAndView("dashboard");
    }

}
