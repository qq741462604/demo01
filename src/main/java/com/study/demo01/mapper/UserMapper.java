package com.study.demo01.mapper;

import com.study.demo01.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    int insert(User user);
    int update(User user);
    int updateLoginInfo(User user);
    User selectById(Long id);
    User selectByUsername(String username);
    User selectByEmail(String email);
    List<User> selectAll();
    int deleteById(Long id);
}