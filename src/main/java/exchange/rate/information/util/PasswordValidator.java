package exchange.rate.information.util;

import org.springframework.stereotype.Service;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

@Service
public class PasswordValidator {

	public static boolean validatePassword(String password, String confirmPassword) {
		if (confirmPassword.isEmpty() || !password.equals(confirmPassword)) {
			return false;
		}
		return true;
	}
}
