package com.spring.model;

public class CommonResponsibleDropDownObject {
	private Long id;
	private String title;
	public CommonResponsibleDropDownObject(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public CommonResponsibleDropDownObject() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

}
