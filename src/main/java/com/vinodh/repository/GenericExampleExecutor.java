package com.vinodh.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;


@Service
public class GenericExampleExecutor {

	public <T> Example<T> getExampleExecutor(T obj){
		Example<T> example=null;
		if(obj!=null && !obj.equals(null)) {
			example=Example.of(obj,getMatcher());
		}
		return example;
	}

	public ExampleMatcher getMatcher(){
		ExampleMatcher matcher = ExampleMatcher.matchingAll()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase();
		return matcher;		
	}

}
