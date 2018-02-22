package exchange.rate.information.controller.rest;

import exchange.rate.information.constant.Constant;
import exchange.rate.information.model.MonitoringExchange;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yuriy Bochkarev
 * @since 22.02.18.
 */

@RestController
@RequestMapping(value = Constant.ROOT_ADDRESS)
@Api(value = Constant.ROOT_ADDRESS, tags = {"Модуль"}, description = "Методы бизнес объекта 'Модуль'")
public class MonitoringExchangeController {

    @RequestMapping(value = Constant.ADD_MONITORING_EXCHANGE, method = {RequestMethod.POST, RequestMethod.OPTIONS}, headers = Constant.JSON_FORMAT, produces = {Constant.CHARSET_UTF_8})
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Массовое добавление модулей", nickname = Constant.ADD_MONITORING_EXCHANGE, httpMethod = "POST")
    public ResponseEntity addMonitoringExchange(@RequestBody MonitoringExchange request) throws Exception {
//        moduleService.massInsertModules(request.getModules());
        System.out.println(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
