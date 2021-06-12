package com.poolemail.consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

//Changes
public class EmailConsumer {
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
			channel.basicConsume("MAIL_QUEUE", true, deliverCallback,consumerTag->{});
			
		} catch (IOException | TimeoutException e) {

			e.printStackTrace();
		}
	}
}
