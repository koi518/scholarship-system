package com.example.demo.controller;

import com.example.demo.entity.Rule;
import com.example.demo.entity.StudentInfo;
import com.example.demo.util.RuleEngine;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/rule")
public class RuleController {

    @GetMapping("/list")
    public List<Rule> getRuleList(){
        return new ArrayList<>();
    }

    @PostMapping("/save")
    public String saveRule(@RequestBody Rule rule){
        return "规则配置成功";
    }

    @GetMapping("/calcRank")
    public List<StudentInfo> getRankList(){
        List<StudentInfo> studentList = new ArrayList<>();
        List<Rule> ruleList = new ArrayList<>();

        StudentInfo s1 = new StudentInfo();
        s1.setName("张三");
        s1.setIsFile(1);
        s1.setFailCourseNum(0);
        studentList.add(s1);

        StudentInfo s2 = new StudentInfo();
        s2.setName("李四");
        s2.setPunishStatus(1);
        studentList.add(s2);

        Rule r1 = new Rule();
        r1.setRuleType("add");
        r1.setCondition("isFile=1");
        r1.setScore(20);
        r1.setStatus(1);
        ruleList.add(r1);

        Rule r2 = new Rule();
        r2.setRuleType("forbid");
        r2.setCondition("punishStatus=1");
        r2.setStatus(1);
        ruleList.add(r2);

        for(StudentInfo info : studentList){
            RuleEngine.calculateScore(info,ruleList);
        }
        studentList.removeIf(StudentInfo::getIsForbid);
        studentList.sort(Comparator.comparing(StudentInfo::getTotalScore).reversed());
        return studentList;
    }
}