package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.co.entelect.jbootcamp.models.LoginUser;
import za.co.entelect.jbootcamp.services.UserProfileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LoginController {

    private UserProfileService userProfileService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(UserProfileService userProfileService, PasswordEncoder passwordEncoder) {
        this.userProfileService = userProfileService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login/login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/createlogin")
    public String createLogin(Model model) {
        LoginUser loginUser = new LoginUser();
        model.addAttribute("loginUser", loginUser);
        return "login/createlogin";
    }

    @PostMapping("/createlogin")
    public String createLoginPost(
            @ModelAttribute("loginUser") @Valid LoginUser loginUser,
            BindingResult bindingResult) {

        userProfileService.createUserProfile(
                loginUser.getUsername(),
                passwordEncoder.encode(loginUser.getPassword()),
                loginUser.getFirstName(),
                loginUser.getLastName());

        return "redirect:/login";
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
