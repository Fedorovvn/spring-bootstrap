package com.springboot.springbootfirst.controller;

import com.springboot.springbootfirst.dto.UserForm;
import com.springboot.springbootfirst.model.Role;
import com.springboot.springbootfirst.model.User;
import com.springboot.springbootfirst.servise.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String userList(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("userform", new UserForm());
        return "userlist";
    }

    @RequestMapping(value = {"/admin/adduser"}, method = RequestMethod.GET)
    public String showAddUserPage(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userform", userForm);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "adduser";
    }

    @RequestMapping(value = {"/admin/adduser"}, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userform") UserForm userForm) {

        String firstname = userForm.getFirstname();
        String lastname = userForm.getLastname();
        Integer age = userForm.getAge();
        String email = userForm.getEmail();
        String password = userForm.getPassword();
        String role = userForm.getRole();

        if (firstname != null && firstname.length() > 0
                && lastname != null && email.length() > 0
                && age != null
                && email != null && email.length() > 0
                && password != null && password.length() > 0
                && role != null && role.length() > 0) {
            userService.add(new User(firstname, lastname, age, email, password, Collections.singleton(new Role(role))));
            return "redirect:";
        }
        return "adduser";
    }

    @RequestMapping(value = {"/admin/edit"}, method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userform") UserForm editForm, @RequestParam(value = "id") Long id) {
        String newLastname = editForm.getLastname();
        String newFirstname = editForm.getFirstname();
        Integer newAge = editForm.getAge();
        String newEmail = editForm.getEmail();
        String newPassword = editForm.getPassword();
        String newRole = editForm.getRole();

        if (newFirstname != null && newFirstname.length() > 0) {
            userService.changeFirstname(id, newFirstname);
        }
        if (newLastname != null && newLastname.length() > 0) {
            userService.changeLastname(id, newLastname);
        }
        if (newAge != null) {
            userService.changeAge(id, newAge);
        }
        if (newEmail != null && newEmail.length() > 0) {
            userService.changeEmail(id, newEmail);
        }
        if (newPassword != null && newPassword.length() > 0) {
            userService.changePassword(id, newPassword);
        }
        if (newRole != null && newRole.length() > 0) {
            userService.changeRoles(id, Collections.singleton(new Role(newRole)));
        }

        return "redirect:";
    }


    @RequestMapping(value = {"/admin/delete"})
    public String delete(@RequestParam(value = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:";
    }

    @RequestMapping(value = {"/user"}, method = RequestMethod.GET)
    public String showInfoPage(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "userinfo";
    }

}