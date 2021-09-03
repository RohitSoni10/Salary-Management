package com.spring.modalmaster;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.spring.user.BaseEntity;

@Entity
@Table(name = "salaryHead")
public class SalaryHead extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	

	@Column(name="title")
	private String title;
	
	@Column(name="salary_type")
	private String salaryType;
	
	@Column(name = "value_type")
	private String valueType;
	
	@Column(name="frequency")
	private String frequency;
	
	@Column(name="calculated_on")
	private String calculatedOn;

	@Transient
	private Long value;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public SalaryHead() {
		
	}

	public SalaryHead(Long Id,
			 String title, String salaryType, String valueType, String frequency,
			String calculatedOn) {
		
		this.id = Id;
		this.title = title; 
		this.salaryType = salaryType;
		this.valueType = valueType;
		this.frequency = frequency;
		this.calculatedOn = calculatedOn;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getCalculatedOn() {
		return calculatedOn;
	}

	public void setCalculatedOn(String calculatedOn) {
		this.calculatedOn = calculatedOn;
	}	

}
