package com.vinodh.specifications;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import com.vinodh.advanced.search.model.AlarmSearchField;
import com.vinodh.advanced.search.model.SearchOperation;
import com.vinodh.advanced.search.model.SearchParam;
import com.vinodh.model.Alarm;

public class AlarmSpecificationBuilder {

	public static Logger logger = LoggerFactory.getLogger(AlarmSpecificationBuilder.class);

	private List<Specification<Alarm>> specs = null;

	public AlarmSpecificationBuilder() {
		super();
		specs = new ArrayList<Specification<Alarm>>();
	}

	// Building Specifications based on search params
	public final AlarmSpecificationBuilder with(final SearchParam searchParam) {
			if (searchParam.getValue() == null && searchParam.getValues() == null && searchParam.getValues().size() == 0) {
				return this;
			}
			AlarmSearchField searchField = (AlarmSearchField) searchParam.getField();
			switch (searchField) {
			case clli:
				String nodeName = getContainsLikePattern(searchParam.getValue());
				logger.debug("building with search String:::::::" + nodeName);
				specs.add(hasNodeName(nodeName));
				break;
			case nodeIp:
				String nodeIp = getContainsLikePattern(searchParam.getValue());
				logger.debug("building with search String:::::::" + nodeIp);
				specs.add(hasNodeIp(nodeIp));
				break;
			case emsName:
				String emsName = getContainsLikePattern(searchParam.getValue());
				logger.debug("building with search String:::::::" + emsName);
				specs.add(hasEmsName(emsName));
				break;
			case emsIp:
				String emsIp = getContainsLikePattern(searchParam.getValue());
				logger.debug("building with search String:::::::" + emsIp);
				specs.add(hasEmsIp(emsIp));
				break;
			case category:
				String category = getContainsLikePattern(searchParam.getValue());
				logger.debug("building with search String:::::::" + category);
				specs.add(hasCategory(category));
				break;
			case severity:
				String severity = getContainsLikePattern(searchParam.getValue());
				logger.debug("building with search String:::::::" + severity);
				specs.add(hasSeverity(severity));
				break;
			case deviceType:
				String deviceType = getContainsLikePattern(searchParam.getValue());
				logger.debug("building with search String:::::::" + deviceType);
				specs.add(hasDeviceType(deviceType));
				break;
			case location:
				String location = getContainsLikePattern(searchParam.getValue());
				logger.debug("building with search String:::::::" + location);
				specs.add(hasLocation(location));
				break;
			case receivedTime:
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				    Date parsedDate = dateFormat.parse(searchParam.getValue());
				    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				    logger.debug("building with search String:::::::" + searchParam.getValue());
				    specs.add(hasReceivedTime(timestamp, searchParam.getOperation()));
				} catch (ParseException e) {
					logger.error("Error in building search String for received time" + e);
				}
				break;
			default:
				break;
			}
			return this;
		}
	
	@SuppressWarnings("serial")
	private Specification<Alarm> hasNodeName(final String searchValue){
		return new Specification<Alarm>() {

			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.<String>get("nodeName"), searchValue);
			}
			
		};
	}
	
	@SuppressWarnings("serial")
	private Specification<Alarm> hasNodeIp(final String searchValue){
		return new Specification<Alarm>() {

			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.<String>get("nodeIp"), searchValue);
			}
			
		};
	}
	
	@SuppressWarnings("serial")
	private Specification<Alarm> hasEmsName(final String searchValue){
		return new Specification<Alarm>() {

			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.<String>get("emsName"), searchValue);
			}
			
		};
	}
	
	@SuppressWarnings("serial")
	private Specification<Alarm> hasEmsIp(final String searchValue){
		return new Specification<Alarm>() {

			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.<String>get("emsIp"), searchValue);
			}
			
		};
	}
	
	@SuppressWarnings("serial")
	private Specification<Alarm> hasCategory(final String searchValue){
		return new Specification<Alarm>() {

			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.<String>get("category"), searchValue);
			}
			
		};
	}
	
	@SuppressWarnings("serial")
	private Specification<Alarm> hasSeverity(final String searchValue){
		return new Specification<Alarm>() {

			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.<String>get("severity"), searchValue);
			}
			
		};
	}
	
	@SuppressWarnings("serial")
	private Specification<Alarm> hasDeviceType(final String searchValue){
		return new Specification<Alarm>() {

			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.<String>get("deviceType"), searchValue);
			}
			
		};
	}
	
	@SuppressWarnings({ "serial", "unused" })
	private Specification<Alarm> hasIdentifier(final String searchValue){
		return new Specification<Alarm>() {

			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.<String>get("identifier"), searchValue);
			}
			
		};
	}
	
	@SuppressWarnings({ "serial", "unused" })
	private Specification<Alarm> hasTrapRequestId(final Integer searchValue){
		return new Specification<Alarm>() {

			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.<Integer>get("trapRequestId"), searchValue);
			}
			
		};
	}
	
	@SuppressWarnings("serial")
	private Specification<Alarm> hasLocation(final String searchValue){
		return new Specification<Alarm>() {

			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.<String>get("location"), searchValue);
			}
			
		};
	}
	
	@SuppressWarnings("serial")
	private Specification<Alarm> hasReceivedTime(final Timestamp receivedTime, final SearchOperation operation){
		return new Specification<Alarm>() {
			
			public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if(operation == SearchOperation.GREATER_THAN_OR_EQUAL){
					return builder.greaterThanOrEqualTo(root.<Timestamp>get("receivedTime"), receivedTime);
				}else if(operation == SearchOperation.GREATER_THAN){
					return builder.greaterThan(root.<Timestamp>get("receivedTime"), receivedTime);
				}else if(operation == SearchOperation.LESS_THAN){
					return builder.lessThan(root.<Timestamp>get("receivedTime"), receivedTime);
				}else{
					return builder.lessThanOrEqualTo(root.<Timestamp>get("receivedTime"), receivedTime);
				}
			}
		};
	}
	
	private String getContainsLikePattern(String searchTerm) {
		if (searchTerm == null || searchTerm.isEmpty()) {
			return "%";
		} else {
			return '%' + searchTerm + '%';
		}
	}
	
	public Specification<Alarm> build() {
		logger.debug("building the Sprcification");
		if (specs.size() == 0) {
			return null;
		}
		logger.debug("no of secs:" + specs.size());
		Specification<Alarm> result = null;

		result = specs.get(0);
		for (int i = 1; i < specs.size(); i++) {
			result = Specification.where(result).and(specs.get(i));
		}

		return result;

	}

}
