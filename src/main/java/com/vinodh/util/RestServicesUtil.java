package com.vinodh.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vinodh.dto.ResponseDTO;
public class RestServicesUtil {
	public static ResponseEntity<?> getFailureResponse(String errorMsg) {
		return getResponseObj(HttpStatus.INTERNAL_SERVER_ERROR, errorMsg);
	}
	
	public static ResponseEntity<?> getSuccessResponse(String message) {
		return getResponseObj(HttpStatus.OK, message);
	}
	
	public static ResponseEntity<?> getSuccessGetResponse(Object entity) {
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}
	
	public static ResponseEntity<?> getResponseObj(HttpStatus status, String message) {
		ResponseDTO response = new ResponseDTO();
		response.setResponseCode(status.value());
		response.setResponseMessage(message);
		return ResponseEntity.status(status).body(response);
	}
	
	
	public static ResponseEntity<?> getFailureResponseEntity(Object response) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
