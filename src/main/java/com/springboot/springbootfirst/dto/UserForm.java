package com.springboot.springbootfirst.dto;

import com.springboot.springbootfirst.model.User;

import java.util.Date;

public class UserForm {
    private String firstname;
    private String lastname;
    private Integer age;
    private String email;
    private String password;
    private String role;

    public UserForm () {}

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public Integer getAge() {return age;}

    public void setAge(Integer age) {this.age = age;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

}
