package com.poolemail.topic.consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.poolemail.utill.DirectExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class EmailJsonTopicConsumerClient {
	
	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = null;
		Channel channel = null;
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			DeliverCallback deliverCallback = (consumerTag, message) -> {
				String emailBody=new String(message.getBody());
				System.out.println("MESSAGE:"+emailBody);
			};
			channel.basicConsume(DirectExchangeType.GUIDE.exchangeName, true, deliverCallback,consumerTag->{});
			channel.basicConsume(DirectExchangeType.STUDENT.exchangeName, true, deliverCallback,consumerTag->{});
			
		} catch (IOException | TimeoutException e) {

			e.printStackTrace();
		}
	}
}
