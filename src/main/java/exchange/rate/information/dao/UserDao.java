package exchange.rate.information.dao;

import exchange.rate.information.model.User;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

public interface UserDao extends GenericDao<Long, User> {

    User getUserByLogin(String login);
}
