package za.co.entelect.jbootcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class UserProfileController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView root() {
        return new ModelAndView("dashboard");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLogin() {
        return "login";
    }

    @RequestMapping(value = "/loginPassed", method = RequestMethod.GET)
    public ModelAndView loginPassed(Principal principal, HttpSession session) {

        return new ModelAndView("dashboard", null);
    }

}
