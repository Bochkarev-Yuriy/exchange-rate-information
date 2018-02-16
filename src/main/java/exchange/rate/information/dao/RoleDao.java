package exchange.rate.information.dao;

import exchange.rate.information.model.Role;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

public interface RoleDao extends GenericDao<Long, Role> {

	Role getRoleByRoleName(String roleName);
}