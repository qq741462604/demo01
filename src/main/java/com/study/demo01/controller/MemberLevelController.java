package com.study.demo01.controller;

import com.study.demo01.entity.MemberLevel;
import com.study.demo01.service.MemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member-levels")
public class MemberLevelController {
    
    @Autowired
    private MemberLevelService memberLevelService;
    
    @PostMapping
    public MemberLevel createMemberLevel(@RequestBody MemberLevel memberLevel) {
        return memberLevelService.createMemberLevel(memberLevel);
    }

    /**
     *
     * @param id
     * @param memberLevel
     * @return
     */
    @PutMapping("/{id}")
    public MemberLevel updateMemberLevel(@PathVariable Long id, @RequestBody MemberLevel memberLevel) {
        memberLevel.setId(id);
        return memberLevelService.updateMemberLevel(memberLevel);
    }
    
    @GetMapping("/{id}")
    public MemberLevel getMemberLevel(@PathVariable Long id) {
        return memberLevelService.getMemberLevelById(id);
    }
    
    @GetMapping
    public List<MemberLevel> getAllMemberLevels() {
        return memberLevelService.getAllMemberLevels();
    }
    
    @GetMapping("/calculate")
    public MemberLevel calculateMemberLevel(@RequestParam Integer points) {
        return memberLevelService.calculateMemberLevel(points);
    }
    
    @DeleteMapping("/{id}")
    public void deleteMemberLevel(@PathVariable Long id) {
        memberLevelService.deleteMemberLevel(id);
    }
}