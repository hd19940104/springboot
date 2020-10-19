package com.zixue.demo.spi.serviceimpl2;

import com.zixue.demo.spi.service.SpiDemo;


public class SpiDemoImpl2 implements SpiDemo  {
    @Override
    public void say() {
        System.out.println("this is SpiDemoImpl2");
    }
}
