package com.zixue.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@Controller
public class WechatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatApplication.class, args);
    }

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/")
    @ResponseBody
    public String root() {
        return "hello root";
    }
}
