package com.study.demo01.controller;

import com.study.demo01.entity.User;
import com.study.demo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    @PostMapping("/login")
    public User login(@RequestBody User user, HttpServletRequest request) {
        User existingUser = userService.getUserByUsername(user.getUsername());
        if (existingUser != null && userService.verifyPassword(user.getPassword(), existingUser.getPassword())) {
            userService.updateLoginInfo(existingUser, request.getRemoteAddr());
            return existingUser;
        }
        return null;
    }
}