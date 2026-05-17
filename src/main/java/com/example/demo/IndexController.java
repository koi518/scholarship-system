package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "<h1 style='text-align:center;margin-top:100px;'>✅ 助学金管理系统启动成功！</h1>" +
               "<h2 style='text-align:center;'>数据库连接正常</h2>" +
               "<h3 style='text-align:center;'>端口：10086</h3>" +
               "<p style='text-align:center;font-size:18px;'>学生：可申请助学金</p>" +
               "<p style='text-align:center;font-size:18px;'>老师：可审核申请</p>" +
               "<p style='text-align:center;font-size:18px;'>管理员：可管理系统</p>";
    }
}