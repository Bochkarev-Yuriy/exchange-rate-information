package exchange.rate.information.dao.impl;

import exchange.rate.information.dao.UserDao;
import exchange.rate.information.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

@Transactional
@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

	@Override
	public User getUserByLogin(String email) {
		return (User) getSession().createQuery("FROM User WHERE email = :email").setParameter("email", email).uniqueResult();
	}
}
