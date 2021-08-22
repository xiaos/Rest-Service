package com.csz.rest.controller;

import com.csz.rest.model.User;
import com.csz.rest.service.UserService;
import com.csz.rest.validation.ValidGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser(int id) {
        Optional<User> oUser = userService.fetch(id);
        return oUser.orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping("/user/create")
    public String create(@Validated(value = ValidGroup.Crud.Create.class) @RequestBody User user) {
        log.info("create user:{}", user);
        userService.saveUser(user);
        return "created success.";
    }

    @PostMapping("/user/update")
    public String update(@Validated(value = ValidGroup.Crud.Update.class) @RequestBody User user) {
        log.info("update user:{}", user);
        userService.saveUser(user);
        return "update success.";
    }

    @GetMapping("/exception")
    public User exception() {
        throw new RuntimeException("exception");
    }
}
