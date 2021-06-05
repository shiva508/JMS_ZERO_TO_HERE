package com.poolemail.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poolemail.modal.User;

public class JsonUtil {

	public static String jsonObjectGenerator(User user) {
		ObjectMapper mapper=new ObjectMapper();
		String userJSON="";
		try {
			userJSON = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return userJSON;
	}
}
