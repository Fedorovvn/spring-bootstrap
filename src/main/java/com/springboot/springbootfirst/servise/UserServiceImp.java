package com.springboot.springbootfirst.servise;

import com.springboot.springbootfirst.dao.UserDao;
import com.springboot.springbootfirst.model.Role;
import com.springboot.springbootfirst.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) { userDao.add(user); }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void changeEmail(Long id, String newEmail){ userDao.changeEmail(id, newEmail); }

    @Override
    public void changePassword(Long id, String newPassword){ userDao.changePassword(id, newPassword); }

    @Override
    public void changeFirstname(Long id, String newFirstname){ userDao.changeFirstname(id, newFirstname); }

    @Override
    public void changeLastname(Long id, String newLastname){ userDao.changeLastname(id, newLastname); }

    @Override
    public void changeAge(Long id, Integer newAge){ userDao.changeAge(id, newAge); }

    @Override
    public void changeRoles(Long id, Set<Role> newRoles){ userDao.changeRoles(id, newRoles); }
}
