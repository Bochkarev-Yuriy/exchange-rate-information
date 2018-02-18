package exchange.rate.information.service.impl;

import exchange.rate.information.dao.RoleDao;
import exchange.rate.information.dao.exceptions.MergeException;
import exchange.rate.information.dao.exceptions.PersistException;
import exchange.rate.information.dao.exceptions.RemoveException;
import exchange.rate.information.model.Role;
import exchange.rate.information.service.RoleService;
import exchange.rate.information.service.exceptions.NotFoundException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

@Service
public class RoleServiceImpl implements RoleService {

    private final static Logger logger = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addRole(Role role) {
        try {
            roleDao.persist(role);
            logger.info("Added : " + role);
        } catch (HibernateException e) {
            logger.error("Failed to add an role " + role);
            throw new PersistException("Failed to add an role", e);
        }
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        Role roleFromDB = roleDao.getRoleByRoleName(roleName);

        if (roleFromDB == null) {
            throw new NotFoundException("The role is not found.");
        }
        return roleFromDB;
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getEntityByKey(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllEntity();
    }

    @Override
    public void updateRoles(Role role) {
        try {
            roleDao.update(role);
            logger.info("Update : " + role);
        } catch (HibernateException e) {
            logger.error("Failed to update an role " + role);
            throw new MergeException("Failed to update an role", e);
        }
    }

    @Override
    public void deleteRoleById(Long id) {
        try {
            roleDao.deleteByKey(id);
            logger.info("Deleted role id=" + id);
        } catch (HibernateException e) {
            logger.error("Failed to deleted an role id=" + id);
            throw new RemoveException("Failed to deleted an role", e);
        }
    }
}
