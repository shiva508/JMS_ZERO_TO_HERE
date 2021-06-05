package com.poolemail.producer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

class EmailProducerClient {
	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = null;
		Channel channel = null;
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			String myFirstQueMessage = "Hey Shiva one day i will come to you:NITHYA";
			List<String> messages=Arrays.asList("Shiva,Nithya","Sathish","Ravi","Gopi");
			for (String msg : messages) {
				channel.basicPublish("", "MAIL_QUEUE", null, msg.getBytes());
			}
			
			System.out.println("Message Sent");
			channel.close();
			connection.close();
		} catch (IOException | TimeoutException e) {

			e.printStackTrace();
		}
	}

}
