package com.zixue;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@EnableCaching
@EnableAsync
//@EnableScheduling
@EnableRedisHttpSession
public class SpringBootStart {
	private static Logger logger = Logger.getLogger(SpringBootStart.class);

	public static void main(String[] args) {
		logger.info("启动spring-boot 程序...");
		SpringApplication.run(SpringBootStart.class, args);
		logger.info("启动成功");
	}
}
