package com.example.demo.entity;

import lombok.Data;

@Data
public class Rule {
    private Integer id;
    private String ruleName;
    private String ruleType;
    private String condition;
    private Integer score;
    private Integer status;
}