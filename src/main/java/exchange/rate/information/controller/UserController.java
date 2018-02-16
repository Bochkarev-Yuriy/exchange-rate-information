package exchange.rate.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @GetMapping()
    public ModelAndView getUserIndexPage() {
        return new ModelAndView("user");
    }
}
