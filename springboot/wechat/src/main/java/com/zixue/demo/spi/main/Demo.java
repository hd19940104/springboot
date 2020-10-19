package com.zixue.demo.spi.main;

import com.zixue.demo.spi.service.SpiDemo;

import java.util.ServiceLoader;

public class Demo {
    public static void main(String[] args) {
        ServiceLoader<SpiDemo> serviceLoader =ServiceLoader.load(SpiDemo.class);
        for (SpiDemo o: serviceLoader) {
            o.say();
        }

    }
}
