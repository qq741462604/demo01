package com.study.demo01.controller;

import com.study.demo01.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @GetMapping("/createUser")
    public String createUser(@RequestParam String name, @RequestParam String email) {
        User user = new User(name, email);
        // 打印用户信息
        log.info("User Created: {}", user);
        return "User Created: " + user.getName() + ", " + user.getEmail();
    }
}