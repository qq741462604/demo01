package com.study.demo01.mapper;

import com.study.demo01.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    int insert(User user);
}