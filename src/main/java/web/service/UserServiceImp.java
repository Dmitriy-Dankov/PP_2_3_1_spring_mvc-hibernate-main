package web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImp;
import web.model.User;

@Service
public class UserServiceImp implements UserService {
    private final UserDaoImp userDaoImp;

    public UserServiceImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Override
    public void addUser(User user) {
        userDaoImp.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoImp.getAllUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDaoImp.getUser(id);
    }

    @Override
    public void removeUser(Long id) {
        userDaoImp.removeUser(id);
    }

    @Override
    public void updateUser(Long id, User newUser) {
        userDaoImp.updateUser(id, newUser);
    }
}
