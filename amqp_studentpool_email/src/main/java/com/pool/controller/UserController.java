package com.pool.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.modal.User;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostMapping("/saveuser")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		rabbitTemplate.convertAndSend("TEST","TEST", user);
		System.out.println("SENT");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
