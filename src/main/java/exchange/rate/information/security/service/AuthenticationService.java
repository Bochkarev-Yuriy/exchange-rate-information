package exchange.rate.information.security.service;

import exchange.rate.information.model.User;
import exchange.rate.information.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		return user;
	}
}
