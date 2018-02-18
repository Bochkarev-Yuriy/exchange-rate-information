package exchange.rate.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @GetMapping()
    public ModelAndView getUserIndexPage() {
        return new ModelAndView("user");
    }
}
