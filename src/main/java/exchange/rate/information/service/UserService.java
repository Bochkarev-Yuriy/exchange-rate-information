package exchange.rate.information.service;

import exchange.rate.information.model.User;

import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 16.02.18.
 */

public interface UserService {

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserById(Long id);

    List<User> getAllUser();

    User getUserByUsername(String username);
}
