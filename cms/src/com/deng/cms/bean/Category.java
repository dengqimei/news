package com.deng.cms.bean;

public class Category {

	private Long id;
	private String name;
	private Integer code;
	
	public Category(){
		
	}
	
	public Category(String name, Integer code) {
		super();
		this.name = name;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
