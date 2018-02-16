package exchange.rate.information.dao.impl;

import exchange.rate.information.dao.RoleDao;
import exchange.rate.information.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

@Transactional
@Repository
public class RoleDaoImpl extends AbstractDao<Long, Role> implements RoleDao {

	public Role getRoleByRoleName(String name) {
		return (Role) getSession().createQuery("FROM Role WHERE name = :name").setParameter("name", name).uniqueResult();
	}
}