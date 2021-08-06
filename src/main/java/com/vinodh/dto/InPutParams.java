package com.vinodh.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vinodh.model.Alarm;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class InPutParams {
	
	private int offset;
	private Integer limit;
	private Date startDate;
	private Date endDate;
	private Alarm alarm;
	private boolean isAscOder;
	
	
	public boolean isAscOder() {
		return isAscOder;
	}
	public void setAscOder(boolean isAscOder) {
		this.isAscOder = isAscOder;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getOffset() {
		return offset;
	}
	public Alarm getAlarm() {
		return alarm;
	}
	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
	
	
	
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
