package com.example.demo.util;

import com.example.demo.entity.Rule;
import com.example.demo.entity.StudentInfo;
import org.springframework.util.StringUtils;
import java.util.List;



public class RuleEngine {

    public static void calculateScore(StudentInfo student, List<Rule> ruleList) {
        int total = 0;
        boolean forbidFlag = false;
        for (Rule rule : ruleList) {
            if(rule.getStatus() != 1){
                continue;
            }
            boolean isMatch = matchCondition(student,rule.getCondition());
            if(!isMatch){
                continue;
            }
            switch (rule.getRuleType()){
                case "add":
                    total += rule.getScore();
                    break;
                case "reduce":
                    total -= rule.getScore();
                    break;
                case "forbid":
                    forbidFlag = true;
                    break;
            }
        }
        student.setTotalScore(total);
        student.setIsForbid(forbidFlag);
    }

    private static boolean matchCondition(StudentInfo student,String condition){
        if(!StringUtils.hasText(condition)){
            return false;
        }
        if(condition.contains("=")){
            String[] split = condition.split("=");
            String field = split[0];
            String val = split[1];
            return getFieldValue(student,field).equals(val);
        }
        if(condition.contains(">")){
            String[] split = condition.split(">");
            String field = split[0];
            int num = Integer.parseInt(split[1]);
            return Integer.parseInt(getFieldValue(student,field)) > num;
        }
        return false;
    }

    private static String getFieldValue(StudentInfo student,String field){
        switch (field){
            case "isFile":
                return student.getIsFile().toString();
            case "isLowIncome":
                return student.getIsLowIncome().toString();
            case "failCourseNum":
                return student.getFailCourseNum().toString();
            case "punishStatus":
                return student.getPunishStatus().toString();
            case "povertyLevel":
                return student.getPovertyLevel().toString();
            default:
                return "0";
        }
    }
}