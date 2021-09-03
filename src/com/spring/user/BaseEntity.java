package com.spring.user;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.status.Status;
@MappedSuperclass
public abstract class  BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Transient
	private Logger logger = LoggerFactory.getLogger(BaseEntity.class);
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date",updatable = false)
	private Date createDate=new Date();
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_date")
	private Date modifiedDate=new Date();
	
	@Column(name="status")
	private Long status;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status", insertable = false,updatable = false,nullable = true)
	private Status statusDetails;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Status getStatusDetails() {
		return statusDetails;
	}

	public void setStatusDetails(Status statusDetails) {
		this.statusDetails = statusDetails;
	}

	public BaseEntity() {
		
	}

	public BaseEntity(Date createDate, Date modifiedDate, Long status, Status statusDetails) {
		
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.statusDetails = statusDetails;
	}
	

} 