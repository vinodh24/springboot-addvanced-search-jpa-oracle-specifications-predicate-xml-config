package com.vinodh.advanced.search.model;

import java.util.HashMap;
import java.util.Map;

public enum AlarmSearchField{
	
	nodeName("nodeName", "nodeName"), nodeIp("nodeIp", "nodeIp"), emsName("emsName", "emsName"), emsIp("emsIp", "emsIp"),category("category", "category"),
	severity("severity", "severity"), deviceType("deviceType", "deviceType"), identifier("identifier", "identifier"), receivedTime("receivedTime", "receivedTime"),
	trapRequestId("trapRequestId", "trapRequestId"),location("location", "location"),clli("clli", "clli");
	
	
	private final String name;
	private final String field;
	
	private AlarmSearchField(String name, String field) {
		this.name = name;
		this.field = field;
	}
	
	public String getName() {
		return name;
	}
	public String getField() {
		return field;
	}
	
	// This is look up map to get Enum value from int value.
	private final static Map<String, AlarmSearchField> map = new HashMap<String, AlarmSearchField>();

	// In Enum, static block will be executed after creating all Enum values.
	static {
		for (AlarmSearchField sfield : AlarmSearchField.values()) {
			map.put(sfield.getName(), sfield);
		}
	}

	public final static String getFieldName(String name) {

		return map.get(name).getField();
	}

	public final static AlarmSearchField getSearchField(String name) {

		return map.get(name);
	}
	
	
	

}
