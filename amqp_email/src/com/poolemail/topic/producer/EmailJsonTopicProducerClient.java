package com.poolemail.topic.producer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.poolemail.json.JsonUtil;
import com.poolemail.modal.User;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmailJsonTopicProducerClient {
	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = null;
		Channel channel = null;
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			List<User> users = Arrays.asList(
					new User().setUserId(508).setUserName("Shiva").setUserType("Student").setRoutingKey("STUDENT"),
					new User().setUserId(504).setUserName("Nithya").setUserType("Guide").setRoutingKey("GUIDE"),
					new User().setUserId(888).setUserName("God").setUserType("Parent").setRoutingKey("PARENT"));
			for (User user : users) {
				channel.basicPublish("STUDENT_POOL_FANOUT_EXCHANGE", "", null,
						JsonUtil.jsonObjectGenerator(user).getBytes());
			}

			System.out.println("Message Sent");
			channel.close();
			connection.close();
		} catch (IOException | TimeoutException e) {

			e.printStackTrace();
		}
	}
}
