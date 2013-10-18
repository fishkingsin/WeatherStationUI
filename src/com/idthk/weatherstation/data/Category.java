package com.idthk.weatherstation.data;

public enum Category {

	TEMPERATURE(0),

	HUMIDITY(1),

	PRESSURE(2);

	private final Integer id;

	Category(Integer id) {
		this.id = id;
	}

	public Integer getValue() {
		return id;
	}

}