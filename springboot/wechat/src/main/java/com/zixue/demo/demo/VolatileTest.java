package com.zixue.demo.demo;

import java.util.TreeMap;

public class VolatileTest {


    public static void main(String[] args) {
        Test test = new Test();
        test.start();
        for (int i = 0; i < 10; i++) {
//            if (test.isFlag()){
//                System.out.println("有点东西");
//            }
            synchronized (test){
                if (test.isFlag()){
                    System.out.println("有点东西");
                }
            }
        }

    }

}

class  Test extends  Thread{
    private volatile Boolean flag=false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=true;
        System.out.println("this is flag="+flag);
    }


    public Boolean isFlag(){
        return  flag;
    }
}
