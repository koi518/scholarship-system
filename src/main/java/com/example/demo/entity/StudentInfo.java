package com.example.demo.entity;

import lombok.Data;

@Data
public class StudentInfo {
    private String stuId;
    private String name;
    private String college;
    private String className;
    private Integer povertyLevel;
    private Integer isFile;
    private Integer isLowIncome;
    private Integer failCourseNum;
    private Integer punishStatus;
    private Integer totalScore;
    private Boolean isForbid;
}