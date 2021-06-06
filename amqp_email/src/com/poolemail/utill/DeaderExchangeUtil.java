package com.poolemail.utill;

import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.AMQP.BasicProperties;

public class DeaderExchangeUtil {

	public static Map<String, Object> studentHeaderValues = null;
	public static Map<String, Object> guideHeaderValues = null;
	public static Map<String, Object> parentHeaderValues = null;
	

	public static Map<String, Object> getStudentHeaderValues() {
		if (studentHeaderValues == null) {
			studentHeaderValues = new HashMap<>();
			studentHeaderValues.put("item1", "STUDENT");
			studentHeaderValues.put("item2", "STU");
		}
		return studentHeaderValues;
	}

	public static Map<String, Object> getGuideHeaderValues() {
		if(guideHeaderValues==null) {
			guideHeaderValues=new HashMap<>();
			guideHeaderValues.put("item1", "PARENT");
			guideHeaderValues.put("item2", "GUIDE");
		}
		return guideHeaderValues;
	}

	public static Map<String, Object> getParentHeaderValues() {
		if(parentHeaderValues==null) {
			parentHeaderValues=new HashMap<>();
			parentHeaderValues.put("item1", "PARENT");
			parentHeaderValues.put("item2", "STU");
		}
		return parentHeaderValues;
	}

	public static BasicProperties basicPropertiesBuilder(Map<String, Object> headers) {
		BasicProperties properties = new BasicProperties();
		properties = properties.builder().headers(headers).build();
		return properties;
	}

	public static Map<String,Map<String, Object>> headerData=null;
	
	public static Map<String, Object> getHeaderData(String key){
		if(headerData==null) {
			headerData=new HashMap<>();
			headerData.put("Student",getStudentHeaderValues());
			headerData.put("Guide",getGuideHeaderValues());
			headerData.put("Parent",getParentHeaderValues());
		}
		return headerData.get(key);
	}
	
	
}
