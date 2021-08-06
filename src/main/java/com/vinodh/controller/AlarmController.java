package com.vinodh.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinodh.advanced.search.model.SearchParam;
import com.vinodh.dto.InPutParams;
import com.vinodh.dto.PagingResponseDTO;
import com.vinodh.model.Alarm;
import com.vinodh.service.AlarmService;
import com.vinodh.util.RestServicesUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/alarm")
@Api(value = "Alarm Controller",description = "Alarm Service")
public class AlarmController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmController.class.getName());

	@Autowired
	private AlarmService alarmService;

	@ApiOperation(value = "Save all Alarms in the System", response = List.class)
	@PostMapping(path= "/alarms", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> saveAlarms(@RequestBody List<Alarm> alarmList) {
		ResponseEntity<?> response;
		try {
			LOGGER.info("Alarm service called for saving alarms"+alarmList.size());
			alarmService.saveAlarms(alarmList);
			response = RestServicesUtil.getSuccessResponse("Alarms are saved successfully.");
		} catch (Exception e) {
			LOGGER.error("Exception occure saving alarms in  saveAlarms method "+e.getMessage());
			response = RestServicesUtil.getFailureResponse(e.getMessage());
		}
		return response;
	}
	
	@ApiOperation(value = "getSearchParamJson", response = SearchParam.class)
	@GetMapping(path= "/getSearchParamJson", produces = "application/json")
	public ResponseEntity<?> getSearchParamJson() {
		ResponseEntity<?> response;
		try {
			LOGGER.info("getSearchParamJson called for saving alarms");
			response = RestServicesUtil.getSuccessGetResponse(alarmService.getSearchParamJson());
		} catch (Exception e) {
			LOGGER.error("Exception occure saving alarms in  saveAlarms method "+e.getMessage());
			response = RestServicesUtil.getFailureResponse(e.getMessage());
		}
		return response;
	}

	@ApiOperation(value = "Return Alarm in the System", response = List.class)
	@PostMapping(path= "/alarm", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> saveAlarm(@RequestBody Alarm alarm) {
		ResponseEntity<?> response;
		try {
			LOGGER.info("Alarm service called for saving alarm"+alarm);
			response = RestServicesUtil.getSuccessGetResponse(alarmService.saveAlarm(alarm));
		} catch (Exception e) {
			LOGGER.error("Exception occure saving alarms in  saveAlarm method "+e.getMessage());
			response = RestServicesUtil.getFailureResponse(e.getMessage());
		}
		return response;
	}

	@ApiOperation(value = "Return Alarm for provided Id", response = Alarm.class)
	@GetMapping(path= "/alarms/{id}", produces = "application/json")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		ResponseEntity<?> response;
		Alarm alarm;
		try {
			alarm = alarmService.findById(id).get();
			response = RestServicesUtil.getSuccessGetResponse(alarm);
		} catch (Exception e) {
			response = RestServicesUtil.getFailureResponse(e.getMessage());
		}
		return response;
	}

	@ApiOperation(value = "Return all Alarms available in the System", response = ResponseEntity.class)
	@PostMapping(path= "/getAllAlarms", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> getAllAlarms(@RequestBody InPutParams inPutParams) {
		ResponseEntity<?> response;
		try {
			LOGGER.info("getAllAlarms ::: "+inPutParams);
			PagingResponseDTO alarms = alarmService.getAllAlarms(inPutParams);
			response = RestServicesUtil.getSuccessGetResponse(alarms);
		} catch (Exception e) {
			LOGGER.error("Exception occure getAllAlarms method "+e.getMessage());
			response = RestServicesUtil.getFailureResponse(e.getMessage());
		}
		return response;
	}

	@ApiOperation(value = "Return all Alarms available in the System", response = ResponseEntity.class)
	@PostMapping(path= "/advanceSearch/getAllAlarms", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> getAllAlarmsByCriteria(@RequestBody List<SearchParam> searchParams) {
		ResponseEntity<?> response;
		try {
			LOGGER.info("getAllAlarms ::: "+searchParams);
			PagingResponseDTO alarms = alarmService.getAllAlarmsBySpecifications(searchParams);
			response = RestServicesUtil.getSuccessGetResponse(alarms);
		} catch (Exception e) {
			LOGGER.error("Exception occure getAllAlarms method "+e.getMessage());
			response = RestServicesUtil.getFailureResponse(e.getMessage());
		}
		return response;
	}

	@ApiOperation(value = "Return all Alarms available in the System", response = ResponseEntity.class)
	@PostMapping(path= "/advanceSearch/getAllAlarmsByPredicates", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> getAllAlarmsByPredicates(@RequestBody List<SearchParam> searchParams) {
		ResponseEntity<?> response;
		try {
			LOGGER.info("getAllAlarms ::: "+searchParams);
			PagingResponseDTO alarms = alarmService.getAllAlarmsByPredicates(searchParams);
			response = RestServicesUtil.getSuccessGetResponse(alarms);
		} catch (Exception e) {
			LOGGER.error("Exception occure getAllAlarms method "+e.getMessage());
			response = RestServicesUtil.getFailureResponse(e.getMessage());
		}
		return response;
	}
}
