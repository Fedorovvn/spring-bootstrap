package com.springboot.springbootfirst.servise;

import com.springboot.springbootfirst.model.Role;
import com.springboot.springbootfirst.model.User;
import java.util.List;
import java.util.Set;

public interface UserService {

    void add(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    List<User> listUsers();

    void changeFirstname(Long id, String newFirstname);

    void changeLastname(Long id, String newLastname);

    void changeAge(Long id, Integer newAge);

    void changeEmail(Long id, String newEmail);

    void changePassword(Long id, String newPassword);

    void changeRoles(Long id, Set<Role> newRoles);
}
