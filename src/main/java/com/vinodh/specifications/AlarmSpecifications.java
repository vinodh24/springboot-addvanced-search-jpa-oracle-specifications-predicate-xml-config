package com.vinodh.specifications;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vinodh.advanced.search.model.AlarmSearchField;
import com.vinodh.advanced.search.model.SearchOperation;
import com.vinodh.advanced.search.model.SearchParam;
import com.vinodh.model.Alarm;

public class AlarmSpecifications implements Specification<Alarm>{
	private static final long serialVersionUID = 1L;
	private List<SearchParam> list;

    public AlarmSpecifications() {
        this.list = new ArrayList<>();
    }

    public void add(SearchParam criteria) {
        list.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        //create a new predicate list
        List<Predicate> predicates = new ArrayList<>();

        //add add criteria to predicates
        for (SearchParam criteria : list) {
        	AlarmSearchField searchField = (AlarmSearchField) criteria.getField();
        	String key = searchField.getName();
            if (criteria.getOperation().equals(SearchOperation.LIKE)) {
                predicates.add(builder.like(
                        builder.lower(root.get(key)),
                        "%" + criteria.getValue().toString().toLowerCase() + "%"));
            }else if (criteria.getOperation().equals(SearchOperation.STARTS_WITH)) {
                predicates.add(builder.like(
                        builder.lower(root.get(key)),
                        criteria.getValue().toString().toLowerCase() + "%"));
            }else if (criteria.getOperation().equals(SearchOperation.ENDS_WITH)) {
                predicates.add(builder.like(
                        builder.lower(root.get(key)),
                        criteria.getValue().toString().toLowerCase() + "%"));
            }else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_OR_EQUAL)) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get(key), criteria.getValue().toString()));
            }else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_OR_EQUAL_DATE)) {
            	Timestamp timestamp = new Timestamp(Long.parseLong(criteria.getValue()));
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get(key), timestamp));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_OR_EQUAL)) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(key), criteria.getValue().toString()));
            }else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_OR_EQUAL_DATE)) {
            	Timestamp timestamp1 = new Timestamp(Long.parseLong(criteria.getValue()));
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(key), timestamp1));
            }else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(builder.notEqual(builder.lower(root.get(key)), criteria.getValue().toString().toLowerCase()));
            }else if (criteria.getOperation().equals(SearchOperation.EQUALITY)) {
                predicates.add(builder.equal(builder.lower(root.get(key)), criteria.getValue().toString().toLowerCase()));
            }else if(criteria.getOperation().equals(SearchOperation.EQUAL)) {
            	Integer trapRequestId = Integer.parseInt(criteria.getValue().toString());
            	predicates.add(builder.equal(root.get(key), trapRequestId));
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }

}
