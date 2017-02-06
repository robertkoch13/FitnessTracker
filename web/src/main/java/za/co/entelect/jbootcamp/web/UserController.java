package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import za.co.entelect.jbootcamp.domain.UserProfile;
import za.co.entelect.jbootcamp.models.EditUser;
import za.co.entelect.jbootcamp.services.UserProfileService;
import za.co.entelect.jbootcamp.utils.PagingBuilder;
import java.util.Map;

@Controller
public class UserController {

    private UserProfileService userProfileService;
    private PagingBuilder pagingBuilder;

    @Autowired
    public UserController(UserProfileService userProfileService, PagingBuilder pagingBuilder) {
        this.userProfileService = userProfileService;
        this.pagingBuilder = pagingBuilder;
    }

    @RequestMapping({ "/users/{property}/{value}", "/users" })
    public ModelAndView showUsers(@PathVariable Map<String, String> pathVariables, Pageable pageable) {

        String viewName = "users/usersView";

        Page<UserProfile> users;
        if (pathVariables.containsKey("property") & pathVariables.containsKey("value")) {
            users = userProfileService.findByProperty(pathVariables.get("property"), pathVariables.get("value"), pageable);
        } else {
            users = userProfileService.findAll(pageable);
        }

        return pagingBuilder.getModelAndView(viewName, users, pageable);
    }

    @GetMapping("/admin/user/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", new EditUser(userProfileService.findById(id)));
        return "users/editUser";
    }

    @PostMapping("/admin/user/edit")
    public String editDeviceSubmit(@ModelAttribute EditUser editUser) {
        UserProfile userProfile = userProfileService.findById(editUser.getId());
        userProfile.setFirstName(editUser.getFirstName());
        userProfile.setLastName(editUser.getLastName());
        userProfile.setUsername(editUser.getUsername());
        userProfileService.update(userProfile);
        return "redirect:/users";
    }
}
