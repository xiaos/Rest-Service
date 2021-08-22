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

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser(int id) {
        User user = new User();
        return user;
    }

    @PostMapping("/user/create")
    public String create(@Validated(value = ValidGroup.Crud.Create.class) @RequestBody User user) {
        log.info("create user:{}", user);
        userService.addUser(user);
        return "user created";
    }

    @PostMapping("/user/update")
    public String update(@Validated(value = ValidGroup.Crud.Update.class) @RequestBody User user) {
        log.info("update user:{}", user);
        return "update success";
    }

    @PostMapping("/user/update2")
    public String update2(@Validated User user) {
        return "update 2";
    }

    @GetMapping("/text")
    public String text() {
        log.info("Test text");
        return "hello spring boot";
    }

    @GetMapping("/exception")
    public User exception() {
        throw new RuntimeException("exception");
    }
}
