package com.vinodh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.vinodh.advanced.search.model.AlarmSearchField;
import com.vinodh.advanced.search.model.SearchOperation;
import com.vinodh.advanced.search.model.SearchParam;
import com.vinodh.dto.InPutParams;
import com.vinodh.dto.PagingResponseDTO;
import com.vinodh.model.Alarm;
import com.vinodh.repository.AlarmRepository;
import com.vinodh.repository.GenericExampleExecutor;
import com.vinodh.specifications.AlarmPredicateBuilder;
import com.vinodh.specifications.AlarmSpecifications;

@Service
public class AlarmService {
	public static Logger logger = LoggerFactory.getLogger(AlarmService.class);

	@Autowired
	private GenericExampleExecutor genericExampleExecutor;

	@Autowired
	private AlarmRepository alarmRepository;

	public void saveAlarms(List<Alarm> alarmList) {
		alarmRepository.saveAll(alarmList);
	}

	public Alarm saveAlarm(Alarm alarm) {
		return alarmRepository.save(alarm);
	}

	public Optional<Alarm> findById(Long id) {
		return alarmRepository.findById(id);
	}

	public PagingResponseDTO getAllAlarms(InPutParams inPutParams) {
		Example<Alarm> example=genericExampleExecutor.getExampleExecutor(inPutParams.getAlarm());
		Pageable paging = PageRequest.of(inPutParams.getOffset(), inPutParams.getLimit());
		Page<Alarm> alarms =alarmRepository.findAll(example,paging);
		return new PagingResponseDTO(alarms);
	}

	public PagingResponseDTO getAllAlarmsBySpecifications(List<SearchParam> searchParams) {
		AlarmSpecifications specifications = new AlarmSpecifications();
		Pageable pageable = PageRequest.of(0, 10);
		for(SearchParam param : searchParams) {
			specifications.add(param);
		}
		return new PagingResponseDTO(alarmRepository.findAll(specifications, pageable));
	}

	public Predicate generateAlarmPredictors(List<SearchParam> paramList){
		final AlarmPredicateBuilder builder = new AlarmPredicateBuilder();
		for(SearchParam param : paramList){
			logger.debug("building specifications with 1" + param.getField() + "," + param.getOperation()
			+ "," + param.getValue());
			builder.with(param);
		}
		return builder.build();
	}

	public PagingResponseDTO getAllAlarmsByPredicates(List<SearchParam> searchParams) {
		Pageable pageable = PageRequest.of(0, 10);
		Predicate predicate = generateAlarmPredictors(searchParams);
		Page<Alarm> alarmsPage = alarmRepository.findAll(predicate, pageable);
		return new PagingResponseDTO(alarmsPage);
	}

	public List<SearchParam> getSearchParamJson() {
		List<SearchParam> searchParams=new ArrayList<SearchParam>();
		SearchParam searchParam=new SearchParam();
		searchParam.setField(AlarmSearchField.emsName);
		searchParam.setOperation(SearchOperation.CONTAINS);
		searchParam.setValues(List.of("vinodh", "navya"));
		searchParams.add(searchParam);
		SearchParam searchParamOne=new SearchParam();
		searchParamOne.setField(AlarmSearchField.nodeName);
		searchParamOne.setOperation(SearchOperation.CONTAINS);
		searchParamOne.setValues(List.of("vinodh", "navya"));
		searchParams.add(searchParamOne);
		return searchParams;		
	}

}
