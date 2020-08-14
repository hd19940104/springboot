package com.zixue.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class PrintLog {

    public void log(String info){

        System.out.println(info);

    }

}
