package exchange.rate.information.service.exceptions;

/**
 * Thrown when the user tried finding non-exist object in the DataBase.
 *
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 * @see {@link exchange.rate.information.service.impl.RoleServiceImpl#getRoleByRoleName(String)}
 */
public class NotFoundException extends RuntimeException {

	/**
	 * Constructor a NotFoundException using the given exception message.
	 *
	 * @param message The message explaining the reason for the exception.
	 */
	public NotFoundException(String message) {
		super(message);
	}
}
