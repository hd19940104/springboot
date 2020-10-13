package com.zixue.demo.demo;

import java.sql.DriverManager;
import java.sql.SQLException;

public class LockTest {

    public synchronized  void test(){

        ClassLoader classLoader =new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                return super.findClass(name);
            }
        };
        Thread thread =new Thread();
        synchronized (new LockTest()){
            System.out.println("this is test");
        }

        try {
            DriverManager.getConnection("");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

