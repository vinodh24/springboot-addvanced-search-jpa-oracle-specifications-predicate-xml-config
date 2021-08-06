package com.vinodh.dto;

import java.util.List;

import org.springframework.data.domain.Page;

public class PagingResponseDTO {
	
	private List<?> content;
	private long totalElements;
	private int totalPages;
	private int size;
	private int number;
	private int numberOfElements;
	
	public PagingResponseDTO() {
		super();
	}
	
	public PagingResponseDTO(Page<?> pagingResult) {
		super();
		this.setContent(pagingResult.getContent());
		this.setNumber(pagingResult.getNumber());
		this.setNumberOfElements(pagingResult.getNumberOfElements());
		this.setSize(pagingResult.getSize());
		this.setTotalElements(pagingResult.getTotalElements());
		this.setTotalPages(pagingResult.getTotalPages());
	}
	
	public boolean isEmpty() {
		if(this.content != null) {
			return false;
		} else {
			return true;
		}
	}

	public List<?> getContent() {
		return content;
	}
	public void setContent(List<?> content) {
		this.content = content;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	
}
