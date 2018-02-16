package exchange.rate.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

@RequestMapping(value = "/user")
@Controller
public class CurrencyController {

    @GetMapping(value = "/monitoring_currency_rate")
    public ModelAndView monitoringCurrencyRate() {
        ModelAndView modelAndView = new ModelAndView("monitoring_currency_rate");
        return modelAndView;
    }

    @GetMapping(value = "/statistics_exchange_rate")
    public ModelAndView getStatisticsExchangeRate() {
        ModelAndView modelAndView = new ModelAndView("statistics_exchange_rate");
        return modelAndView;
    }

}
