//package com.zixue.ribbitmq.producer.impl;
//
//import javax.annotation.Resource;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Service;
//
//import com.zixue.config.RabbitProducerConfig;

//@Service
//public class MessageProducerServiceImpl implements IMessageProducerService {
//	@Resource
//	private RabbitTemplate rabbitTemplate;
//	@Override
//	public void sendMessage(String msg) {
//		this.rabbitTemplate.convertAndSend(RabbitProducerConfig.EXCHANGE,
//				RabbitProducerConfig.ROUTINGKEY, msg);
//	}

//}
