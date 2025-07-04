package com.study.demo01.mapper;

import com.study.demo01.entity.MemberLevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberLevelMapper {
    int insert(MemberLevel memberLevel);
    int update(MemberLevel memberLevel);
    MemberLevel selectById(Long id);
    MemberLevel selectByLevelCode(String levelCode);
    List<MemberLevel> selectAll();
    MemberLevel selectByPointsThreshold(Integer points);
    int deleteById(Long id);
}