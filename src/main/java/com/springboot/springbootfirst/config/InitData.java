package com.springboot.springbootfirst.config;

import org.springframework.stereotype.Component;
import com.springboot.springbootfirst.model.Role;
import com.springboot.springbootfirst.model.User;
import com.springboot.springbootfirst.servise.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Set;

@Component
public class InitData {
    private final UserService userService;

    public InitData(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void load() {
        userService.add(new User("Oleg", "Karelov", 26, "ok1994@mail.ru", "0", Collections.singleton(new Role("ROLE_ADMIN"))));
        userService.add(new User("Viktor", "Bitz", 36, "bitz@list.ru", "0", Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER"))));
        userService.add(new User("Sergey", "Logvinov", 41, "vote_now@yandex.ru", "0", Collections.singleton(new Role("ROLE_USER"))));
        userService.add(new User("Boris", "Rogulov", 15, "urban@gmail.com", "0", Collections.singleton(new Role("ROLE_USER"))));
    }
}