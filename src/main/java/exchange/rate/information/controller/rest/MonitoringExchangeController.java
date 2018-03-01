package exchange.rate.information.controller.rest;

import exchange.rate.information.constant.Constant;
import exchange.rate.information.model.*;
import exchange.rate.information.service.CurrencyService;
import exchange.rate.information.service.MonitoringExchangeRateService;
import exchange.rate.information.service.MonitoringExchangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 22.02.18.
 */

@RestController
@RequestMapping(value = Constant.API_ROOT_ADDRESS)
@Api(value = Constant.API_ROOT_ADDRESS, tags = {"Модуль"}, description = "Методы бизнес объекта 'Модуль'")
public class MonitoringExchangeController {

    @Autowired
    private MonitoringExchangeService monitoringExchangeService;

    @Autowired
    private MonitoringExchangeRateService monitoringExchangeRateService;

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping(value = Constant.ADD_MONITORING_EXCHANGE, method = {RequestMethod.POST, RequestMethod.OPTIONS}, headers = Constant.JSON_FORMAT, produces = {Constant.CHARSET_UTF_8})
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Добавить мониторинг валюты с заданным интервалом", nickname = Constant.ADD_MONITORING_EXCHANGE, httpMethod = "POST")
    public ResponseEntity addMonitoringExchange(@RequestBody MonitoringExchange request) throws Exception {
        request.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        monitoringExchangeService.addMonitoringExchange(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = Constant.GET_ALL_CURRENCIES, method = {RequestMethod.GET, RequestMethod.OPTIONS}, headers = Constant.JSON_FORMAT, produces = {Constant.CHARSET_UTF_8})
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Просмотреть все валюты", nickname = Constant.GET_ALL_CURRENCIES, httpMethod = "GET")
    public ResponseEntity<List<Currency>> getAllCurrencies() throws Exception {
        return new ResponseEntity<>(currencyService.getAllCurrencies(), HttpStatus.OK);
    }

    @RequestMapping(value = Constant.GET_RATE_BY_TIME_FRAME, method = {RequestMethod.POST, RequestMethod.OPTIONS}, headers = Constant.JSON_FORMAT, produces = {Constant.CHARSET_UTF_8})
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Просмотреть курс валюты за определённый период", nickname = Constant.GET_RATE_BY_TIME_FRAME, httpMethod = "POST")
    public ResponseEntity<List<ExchangeRateInformationTimeFrame>> getRateByTimeFrame(@RequestBody TimeFrame request) throws Exception {
        request.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return new ResponseEntity<>(monitoringExchangeRateService.getRateByTimeFrame(request), HttpStatus.OK);
    }
}
