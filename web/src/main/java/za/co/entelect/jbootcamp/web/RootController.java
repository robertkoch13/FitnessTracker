package za.co.entelect.jbootcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping("")
    public String getSiteRoot() {
        return "dashboard/dashboard";
    }
}