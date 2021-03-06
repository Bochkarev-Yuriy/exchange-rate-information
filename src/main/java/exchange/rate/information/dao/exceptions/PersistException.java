package exchange.rate.information.dao.exceptions;

import exchange.rate.information.dao.impl.AbstractDao;

/**
 * Exception used to indicate a problem with adding a object to DataBase.
 *
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 * @see {@link AbstractDao#persist(Object)}
 */
public class PersistException extends RuntimeException {

	/**
	 * Constructor a PersistException using the given exceptions message.
	 *
	 * @param message The message explaining the reason for the exceptions.
	 */
	public PersistException(String message) {
		super(message);
	}

	/**
	 * Constructs a PersistException using the given message and underlying cause.
	 *
	 * @param message The message explaining the reason for the exceptions.
	 * @param cause   The underlying cause.
	 */
	public PersistException(String message, Throwable cause) {
		super(message, cause);
	}
}
