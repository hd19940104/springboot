package com.zixue.config.db;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.zixue.config.db.DataSourceType.DataBaseType;



@Aspect
@Component
public class DataSourceAop {
    @Before("execution(* com.zixue.service..*.query*(..)) or execution(* com.zixue.service..*.find*(..))" )
    public void setDataSource2test01() {
        System.err.println("查询业务【query,find】");
        DataSourceType.setDataBaseType(DataBaseType.DB1);
    }

    @Before("execution(* com.zixue.service..*.add*(..)) or "
    		+ "execution(* com.zixue.service..*.del*(..)) or"
    		+ " execution(* com.zixue.service..*.up*(..)) or "
    		+ " execution(* com.zixue.service..*.select*(..)) ")
    public void setDataSource2test02() {
        System.err.println("修改业务【add,del,up,select】");
        DataSourceType.setDataBaseType(DataBaseType.DB2);
    }
}