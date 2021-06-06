package com.pool.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.pool.modal.User;

@Service
public class RabbitMQConsumer {

	@RabbitListener(queues = {"TEST"})
	public void sendEmailConsumer(User user) {
		System.out.println(user.getUserName());
	}
}
