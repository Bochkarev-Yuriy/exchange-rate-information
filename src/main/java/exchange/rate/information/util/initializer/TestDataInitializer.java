package exchange.rate.information.util.initializer;

import exchange.rate.information.model.Role;
import exchange.rate.information.model.User;
import exchange.rate.information.service.RoleService;
import exchange.rate.information.service.UserService;
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

	}
}