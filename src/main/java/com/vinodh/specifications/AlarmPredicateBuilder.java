package com.vinodh.specifications;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.vinodh.advanced.search.model.AlarmSearchField;
import com.vinodh.advanced.search.model.SearchOperation;
import com.vinodh.advanced.search.model.SearchParam;
import com.vinodh.model.QAlarm;


public class AlarmPredicateBuilder {

	public static final Logger logger = LoggerFactory.getLogger(AlarmPredicateBuilder.class);

	List<Predicate> predicates = null;

	private static final QAlarm alarm = QAlarm.alarm;

	public AlarmPredicateBuilder() {
		predicates = new ArrayList<Predicate>();
	}

	// Building Specifications based on search params
	public final AlarmPredicateBuilder with(final SearchParam searchParam) {
		if (searchParam.getValue() == null && searchParam.getValues() == null && searchParam.getValues().size() == 0) {
			return this;
		}
		AlarmSearchField searchField = (AlarmSearchField) searchParam.getField();
		switch (searchField) {
		case nodeName:
			String nodeName = getContainsLikePattern(searchParam.getValue());
			logger.debug("building with search String:::::::" + nodeName);
			predicates.add(hasNodeName(nodeName));
			break;
		case nodeIp:
			String nodeIp = getContainsLikePattern(searchParam.getValue());
			logger.debug("building with search String:::::::" + nodeIp);
			predicates.add(hasNodeIp(nodeIp));
			break;
		case emsName:
			String emsName = getContainsLikePattern(searchParam.getValue());
			logger.debug("building with search String:::::::" + emsName);
			predicates.add(hasEmsName(emsName));
			break;
		case emsIp:
			String emsIp = getContainsLikePattern(searchParam.getValue());
			logger.debug("building with search String:::::::" + emsIp);
			predicates.add(hasEmsIp(emsIp));
			break;
		case category:
			String category = getContainsLikePattern(searchParam.getValue());
			logger.debug("building with search String:::::::" + category);
			predicates.add(hasCategory(category));
			break;
		case severity:
			String severity = getContainsLikePattern(searchParam.getValue());
			logger.debug("building with search String:::::::" + severity);
			predicates.add(hasSeverity(severity));
			break;
		case deviceType:
			String deviceType = getContainsLikePattern(searchParam.getValue());
			logger.debug("building with search String:::::::" + deviceType);
			predicates.add(hasDeviceType(deviceType));
			break;
		case identifier:
			String identifier = getContainsLikePattern(searchParam.getValue());
			logger.debug("building with search String:::::::" + identifier);
			predicates.add(hasIdentifier(identifier));
			break;
		case receivedTime:
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(searchParam.getValue());
				Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				logger.debug("building with search String:::::::" + searchParam.getValue());
				predicates.add(hasReceivedTime(timestamp, searchParam.getOperation()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		return this;
	}
	
	
	public Predicate hasNodeName(String nodeName){
		return alarm.nodeName.like(nodeName);
	}
	
	public Predicate hasNodeIp(String nodeIp){
		return alarm.nodeIp.like(nodeIp);
	}
	
	public Predicate hasEmsName(String emsName){
		return alarm.emsName.like(emsName);
	}
	
	public Predicate hasEmsIp(String emsIp){
		return alarm.emsIp.like(emsIp);
	}
	
	public Predicate hasCategory(String category){
		return alarm.category.like(category);
	}
	
	public Predicate hasSeverity(String severity){
		return alarm.severity.like(severity);
	}
	
	public Predicate hasDeviceType(String deviceType){
		return alarm.deviceType.like(deviceType);
	}
	
	public Predicate hasIdentifier(String identifier){
		return alarm.identifier.like(identifier);
	}
	
	public Predicate hasReceivedTime(Timestamp receivedTime, SearchOperation operation){
		if(operation == SearchOperation.GREATER_THAN_OR_EQUAL){
			return alarm.receivedTime.goe(receivedTime);
		}else if(operation == SearchOperation.GREATER_THAN){
			return alarm.receivedTime.gt(receivedTime);
		}else if(operation == SearchOperation.LESS_THAN){
			return alarm.receivedTime.lt(receivedTime);
		}else{
			return alarm.receivedTime.loe(receivedTime);
		}
	}

	private String getContainsLikePattern(String searchTerm) {
		if (searchTerm == null || searchTerm.isEmpty()) {
			return "%";
		} else {
			return '%' + searchTerm + '%';
		}
	}
	
	public BooleanBuilder build() {
		logger.debug("building the predicate");
		if (predicates.size() == 0) {
			return null;
		}
		logger.debug("No Of Predicates:" + predicates.size());
		BooleanBuilder b = new BooleanBuilder();
		for (int i = 0; i < predicates.size(); i++) {
			b = b.and(predicates.get(i));
		}
		return b;

	}

}
