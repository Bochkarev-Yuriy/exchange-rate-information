package exchange.rate.information.util.initializer;

import exchange.rate.information.model.*;
import exchange.rate.information.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

public class TestDataInitializer {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProxyService proxyService;

	@Autowired
	private AdapterService adapterService;

	@Autowired
	private CurrencyService currencyService;

	@Autowired
	private MonitoringExchangeService monitoringExchangeService;

	private void init() {

//		<---Creating roles--->
		Role roleAdmin = new Role("ADMIN");
		Role roleUser = new Role("USER");

//		<---Adding roles into a DB--->
		roleService.addRole(roleAdmin);
		roleService.addRole(roleUser);

//		<---Creating users--->
		Set<Role> roleListAdmin = new HashSet();
		roleListAdmin.add(roleUser);
		roleListAdmin.add(roleAdmin);
		User admin = new User("admin@mail.ru", "admin", roleListAdmin);

//		<---Adding users into a DB--->
		userService.addUser(admin);

//		<---Adding currencies into a DB--->
		currencyService.addCurrencies(adapterService.mapCastToCurrencies(proxyService.getAllCurrencies()));

//		<---Adding MonitoringExchange into a DB--->
		MonitoringExchange monitoringExchange = new MonitoringExchange();
		monitoringExchange.setUser(admin);
		monitoringExchange.setSourceCurrency(currencyService.getCurrencyByBrief("USD"));
		monitoringExchange.setInterval(900000L);

		Set<Currency> currencies = new HashSet<>();
		currencies.add(currencyService.getCurrencyByBrief("FJD"));
		currencies.add(currencyService.getCurrencyByBrief("BIF"));
		currencies.add(currencyService.getCurrencyByBrief("MWK"));
		currencies.add(currencyService.getCurrencyByBrief("BYR"));
		currencies.add(currencyService.getCurrencyByBrief("AWG"));
		currencies.add(currencyService.getCurrencyByBrief("USD"));
		monitoringExchange.setCurrencies(currencies);

		monitoringExchangeService.addMonitoringExchange(monitoringExchange);

	}
}
