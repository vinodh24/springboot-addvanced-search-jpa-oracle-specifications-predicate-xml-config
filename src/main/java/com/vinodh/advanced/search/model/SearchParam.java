package com.vinodh.advanced.search.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties
public class SearchParam {
	
	@ApiModelProperty(notes = "Name of the the field to search",name="field",required=true,value="emsName")
	private AlarmSearchField field;
	@ApiModelProperty(notes = "Name of the the Operation to search",name="operation",required=true,value="CONTAINS")
	private SearchOperation operation;
	@ApiModelProperty(notes = "Name of the the Value to search",name="value",required=true,value="alarm")
	private String value;
	private List<String> values;
	
	public SearchParam() {
		
	}
	
	public AlarmSearchField getField() {
		return field;
	}
	
	public void setField(AlarmSearchField field) {
		this.field = field;
	}
	public SearchOperation getOperation() {
		return operation;
	}
	
	public void setOperation(SearchOperation operation) {
		this.operation = operation;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}

}
