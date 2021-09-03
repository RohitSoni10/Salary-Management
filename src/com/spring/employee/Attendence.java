package com.spring.employee;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "attendence")
public class Attendence {
	
	@Transient
	private Logger logger = LoggerFactory.getLogger(Attendence.class);
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	@Column(name="create_date",updatable = false)
	private Date createDate=new Date();
	
	@Column(name="AttendenceStatus")
	private String AttendenceStatus;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", insertable = false, updatable = false, nullable = true)
	private EmployeeMasterTable employeeMasterTable;
	
	
	
	public EmployeeMasterTable getEmployeeMasterTable() {
		return employeeMasterTable;
	}

	public void setEmployeeMasterTable(EmployeeMasterTable employeeMasterTable) {
		this.employeeMasterTable = employeeMasterTable;
	}

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
	
	

	public Attendence(Long id, String attendenceStatus, EmployeeMasterTable employeeMasterTable, String fromDate,
			String toDate) {
		super();
		this.id = id;
		this.AttendenceStatus = attendenceStatus;
		this.employeeMasterTable = employeeMasterTable;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public String getAttendenceStatus() {
		return AttendenceStatus;
	}

	public void setAttendenceStatus(String attendenceStatus) {
		AttendenceStatus = attendenceStatus;
	}

	public Attendence() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
