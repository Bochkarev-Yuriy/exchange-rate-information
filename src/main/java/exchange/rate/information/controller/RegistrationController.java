package exchange.rate.information.controller;

import exchange.rate.information.model.Role;
import exchange.rate.information.model.User;
import exchange.rate.information.service.RoleService;
import exchange.rate.information.service.UserService;
import exchange.rate.information.util.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView saveNewUser() {
        ModelAndView model = new ModelAndView("registration");
        model.addObject("user", new User());
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView getRegistrationForm(@RequestParam(value = "confirmPassword") String confirmPassword,
                                            @Valid User userFromPage, BindingResult bindingResult) {

        ModelAndView model = new ModelAndView("registration");
        model.addObject("user", userFromPage);

        boolean isConfEqualToPass =
                PasswordValidator.validatePassword(userFromPage.getPassword(), confirmPassword);

        if (bindingResult.hasErrors()) {
            return model;
        } else if (!isConfEqualToPass) {
            model.addObject("errorConfirm", "Error confirm pass");
            return model;
        }

        String username = userFromPage.getUsername();
        boolean isUser = userService.getUserByUsername(username) != null;

        if (isUser) {
            model.addObject("errorEmail", "Duplicate email");
            return model;
        } else {
            Role role = roleService.getRoleByRoleName("USER");
            Set<Role> roles = new LinkedHashSet<>();
            roles.add(role);
            userFromPage.setRoles(roles);
            userService.addUser(userFromPage);
            model.addObject("congratulations", "registration completed successfully");
        }
        return model;
    }
}
