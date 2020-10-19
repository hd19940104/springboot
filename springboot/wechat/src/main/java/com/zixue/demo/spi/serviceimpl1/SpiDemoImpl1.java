package com.zixue.demo.spi.serviceimpl1;

import com.zixue.demo.spi.service.SpiDemo;

public class SpiDemoImpl1  implements SpiDemo {
    @Override
    public void say() {
        System.out.println("this is SpiDemoImpl1");
    }
}
