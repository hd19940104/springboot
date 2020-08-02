package com.zixue.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitConsumerConfig {
//	public static final String EXCHANGE = "com.zixue.rabbit.exchange"; // 交换空间名称
//	public static final String ROUTINGKEY = "com.zixue.rabbit.routingkey"; // 设置路由key
//	public static final String QUEUE_NAME = "com.zixue.rabbit.queue"; // 队列名称
//	@Bean
//	public Queue queue() { // 要穿件的队列信息
//		return new Queue(QUEUE_NAME);
//	}
//	@Bean
//	public DirectExchange getDirectExchange() { // 使用直连的模式
//		return new DirectExchange(EXCHANGE, true, true);
//	}
//	@Bean
//	public Binding bindingExchangeQueue(DirectExchange exchange,Queue queue) {
//		return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY) ;
//	}
}
