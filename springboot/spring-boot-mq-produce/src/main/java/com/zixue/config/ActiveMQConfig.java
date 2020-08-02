package com.zixue.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
public class ActiveMQConfig {
	@Value("${queue}")
	private String queueName;
	@Bean
	public Queue queue() {
		return new ActiveMQQueue(queueName) ;
	}
}
