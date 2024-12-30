package web.dao;

import java.util.List;
import web.model.User;

public interface UserDao {
    
    void addUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();

    void removeUser(Long id);

    void updateUser(Long id, User newUser);
}
