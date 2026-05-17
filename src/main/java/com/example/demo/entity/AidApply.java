package com.example.demo.entity;

import lombok.Data;
import java.util.Date;

@Data
public class AidApply {
    private Integer id;
    private String stuId;
    private String applyReason;
    private String materialUrl;
    private Integer status;
    private String currentAuditor;
    private Date createTime;
}