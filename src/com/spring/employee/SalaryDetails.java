package com.spring.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.spring.modalmaster.SalaryHead;

@Entity
@Table(name="salaryDetial")
public class SalaryDetails {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Long id;	

	@Column(name="salary_head_id")
	private Long salaryHeadId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="salary_head_id",updatable = false, insertable = false,nullable = true)
	private SalaryHead salaryHead;
	
	@Column(name="employee_id")
	private Long employee_id;
	
	@Column(name="value")
	private Long value;
	
	@Transient
	private Long HomeTakeSalary;
	
	@Transient
	private String fromDate;
	
	@Transient
	private String toDate;


	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Long getHomeTakeSalary() {
		return HomeTakeSalary;
	}

	public void setHomeTakeSalary(Long homeTakeSalary) {
		HomeTakeSalary = homeTakeSalary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Long getSalaryHeadId() {
		return salaryHeadId;
	}

	public void setSalaryHeadId(Long salaryHeadId) {
		this.salaryHeadId = salaryHeadId;
	}

	public SalaryHead getSalaryHead() {
		return salaryHead;
	}

	public void setSalaryHead(SalaryHead salaryHead) {
		this.salaryHead = salaryHead;
	}
	
	
}
