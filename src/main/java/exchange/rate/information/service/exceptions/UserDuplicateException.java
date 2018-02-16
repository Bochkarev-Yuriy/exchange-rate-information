package exchange.rate.information.service.exceptions;

import exchange.rate.information.model.User;
import exchange.rate.information.service.impl.UserServiceImpl;

/**
 * Indicates that an exception occurred upon attempt to write an existing {@link User} in the DataBase.
 *
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 * @see {@link UserServiceImpl#addUser(User)}
 */
public class UserDuplicateException extends RuntimeException {

	/**
	 * Constructor a UserDuplicateException using the given exception message.
	 *
	 * @param message The message explaining the reason for the exception.
	 */
	public UserDuplicateException(String message) {
		super(message);
	}
}
