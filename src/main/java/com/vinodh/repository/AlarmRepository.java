package com.vinodh.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinodh.model.Alarm;

@Repository
public interface AlarmRepository extends GenericDAO<Alarm>{
	
	public Optional<Alarm> findById(Long id);
	
	public List<Alarm> findAll();
	
	@Transactional
	Page<Alarm> findAll(Specification<Alarm> spec, Pageable pageable);
}
