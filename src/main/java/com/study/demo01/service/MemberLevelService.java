package com.study.demo01.service;

import com.study.demo01.entity.MemberLevel;
import com.study.demo01.mapper.MemberLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MemberLevelService {
    
    @Autowired
    private MemberLevelMapper memberLevelMapper;
    
    @Transactional
    public MemberLevel createMemberLevel(MemberLevel memberLevel) {
        memberLevel.setCreateTime(new Date());
        memberLevel.setUpdateTime(new Date());
        memberLevelMapper.insert(memberLevel);
        return memberLevel;
    }
    
    @Transactional
    public MemberLevel updateMemberLevel(MemberLevel memberLevel) {
        memberLevel.setUpdateTime(new Date());
        memberLevelMapper.update(memberLevel);
        return memberLevel;
    }
    
    public MemberLevel getMemberLevelById(Long id) {
        return memberLevelMapper.selectById(id);
    }
    
    public MemberLevel getMemberLevelByCode(String levelCode) {
        return memberLevelMapper.selectByLevelCode(levelCode);
    }
    
    public List<MemberLevel> getAllMemberLevels() {
        return memberLevelMapper.selectAll();
    }
    
    public MemberLevel calculateMemberLevel(Integer points) {
        return memberLevelMapper.selectByPointsThreshold(points);
    }
    
    @Transactional
    public void deleteMemberLevel(Long id) {
        memberLevelMapper.deleteById(id);
    }
}