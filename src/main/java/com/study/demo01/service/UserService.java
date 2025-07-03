package com.study.demo01.service;

import com.study.demo01.entity.User;
import com.study.demo01.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Transactional
    public User createUser(User user) {
        // 加密密码
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus(1); // 默认启用
        userMapper.insert(user);
        return user;
    }
    
    @Transactional
    public User updateUser(User user) {
        user.setUpdateTime(new Date());
        userMapper.update(user);
        return user;
    }
    
    @Transactional
    public void updateLoginInfo(User user, String loginIp) {
        user.setLastLoginIp(loginIp);
        user.setLastLoginTime(new Date());
        userMapper.updateLoginInfo(user);
    }
    
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
    
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
    
    public User getUserByEmail(String email) {
        return userMapper.selectByEmail(email);
    }
    
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }
    
    @Transactional
    public void deleteUser(Long id) {
        userMapper.deleteById(id);
    }
    
    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}