package exchange.rate.information.service;

import exchange.rate.information.model.Role;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

public interface RoleService {

    void addRole(Role role);

    Role getRoleByRoleName(String roleName);

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    void updateRoles(Role role);

    void deleteRoleById(Long id);
}