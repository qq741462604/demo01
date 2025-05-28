package com.study.demo01.controller;

import com.study.demo01.entity.User;
import com.study.demo01.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/createUser")
    public String createUser(@RequestParam String name, @RequestParam String email) {
        User user = new User(name, email);
        // 打印用户信息
        log.info("User Created: {}", user);
        return "User Created: " + user.getName() + ", " + user.getEmail();
    }

    @GetMapping("queryUser")
    public List<User> queryUser(){
        List<User> list = userService.getAllUsers();
        log.info("queryUser is {}", list);
        return list;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        int result = userService.addUser(user);
        if (result > 0) {
            log.info("User added successfully: {}", user);
            return "User added successfully: " + user.getName();
        } else {
            log.error("Failed to add user: {}", user);
            return "Failed to add user: " + user.getName();
        }
    }
}