package com.zixue.demo.config.db;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;




@Aspect
@Component
public class DataSourceAop {
    @Before("execution(* com.zixue.demo.service..*.query*(..)) or execution(* com.zixue.demo.service..*.find*(..))" )
    public void setDataSource2test01() {
        System.err.println("查询业务【query,find】");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DB1);
    }

    @Before("execution(* com.zixue.demo.service..*.add*(..)) or "
    		+ "execution(* com.zixue.demo.service..*.del*(..)) or"
    		+ " execution(* com.zixue.demo.service..*.up*(..)) or "
    		+ " execution(* com.zixue.demo.service..*.select*(..)) ")
    public void setDataSource2test02() {
        System.err.println("修改业务【add,del,up,select】");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DB2);
    }
}