package za.co.entelect.jbootcamp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import za.co.entelect.jbootcamp.domain.UserProfile;
import za.co.entelect.jbootcamp.models.EditUserModel;
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

    private ModelAndView getUsersView(Page<UserProfile> userProfiles, Pageable pageable) {
        String viewName = "users/usersView";
        return pagingBuilder.getModelAndView(viewName, userProfiles, pageable);
    }

    @GetMapping("/users" )
    public ModelAndView showUsers(Pageable pageable) {
        return getUsersView(userProfileService.findAll(pageable), pageable);
    }

    @GetMapping("/users/{property}/{value}")
    public ModelAndView showUsers(@PathVariable Map<String, String> pathVariables, Pageable pageable) {
        return getUsersView(userProfileService.findByProperty(pathVariables.get("property"), pathVariables.get("value"), pageable), pageable);
    }

    @GetMapping("/admin/user/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        UserProfile user = userProfileService.findById(id);
        model.addAttribute("user", new EditUserModel(
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getId(),
                userProfileService.getRoles(user.getUsername())
        ));
        return "users/editUser";
    }

    @PostMapping("/admin/user/edit")
    public String editDeviceSubmit(@ModelAttribute EditUserModel editUserModel) {
        UserProfile userProfile = userProfileService.findById(editUserModel.getId());
        userProfile.setFirstName(editUserModel.getFirstName());
        userProfile.setLastName(editUserModel.getLastName());
        userProfile.setUsername(editUserModel.getUsername());
        userProfileService.update(userProfile);
        return "redirect:/users";
    }
}
