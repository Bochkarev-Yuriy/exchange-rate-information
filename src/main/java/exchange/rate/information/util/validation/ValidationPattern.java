package exchange.rate.information.util.validation;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

public interface ValidationPattern {
	String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	String PASSWORD_PATTERN = "[^\\s]+";
}
