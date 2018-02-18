package exchange.rate.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

	@GetMapping()
	public ModelAndView getAdminIndexPage() {
		return new ModelAndView("user");
	}

}
