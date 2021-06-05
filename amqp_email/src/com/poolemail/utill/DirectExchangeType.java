package com.poolemail.utill;

public enum DirectExchangeType {
	STUDENT("SPDE_STUDENT"),GUIDE("SPDE_GUIDE"),PARENT("SPDE_PARENT");
	
	public String exchangeName;

	private DirectExchangeType(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getExchangeName() {
		return exchangeName;
	}
	
}
