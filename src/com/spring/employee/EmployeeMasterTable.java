package com.spring.employee;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.spring.user.BaseEntity;

@Entity
@Table(name = "employee")
public class EmployeeMasterTable extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private Long mobile;

	@Column(name = "whatsapp_number")
	private Long whatsappNumber;

	@Column(name = "gender")
	private String gender;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "spouse_name")
	private String spouseName;

	@Column(name = "address_perament")
	private String addressPermanent;

	@Column(name = "address_present")
	private String addressPresent;

	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "alter_number")
	private Long alterNumber;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "account_number")
	private Long accountNumber;

	@Column(name = "ifsc_code")
	private String ifscCode;

	@Column(name = "pan_no")
	private String panNo;

	@Column(name = "aadhar_number")
	private Long aadharNumber;

	@Column(name = "highest_qualification")
	private String highestQualification;

	@Column(name = "passport_number")
	private String passportNumber;

	@Column(name = "employee_code")
	private String employeeCode;

	@Column(name = "designation_id")
	private Long designationid;

	@Column(name = "department_id")
	private Long departmentId;
	
	@Column(name="attendence_id")
	private Long attendenceid;
	
	@Column(name = "ctc")
	private Double ctc;

	@Column(name = "remark")
	private String remark;

	@Column(name = "doj")
	@Temporal(TemporalType.DATE)
	private Date doj;

	@Column(name = "dob")
	private String dob;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", nullable = true)
	private List<SalaryDetails> salaryDetails;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "designation_id", insertable = false, updatable = false, nullable = true)
	private Designation designation;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id", insertable = false, updatable = false, nullable = true)
	private Department department;

	@Transient
	public double value;

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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Transient
	public List<MultipartFile> doc;

	@Transient
	public List<String> description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Long getDesignationid() {
		return designationid;
	}

	public void setDesignationid(Long designationid) {
		this.designationid = designationid;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Double getCtc() {
		return ctc;
	}

	public void setCtc(Double ctc) {
		this.ctc = ctc;
	}

	public Long getWhatsappNumber() {
		return whatsappNumber;
	}

	public void setWhatsappNumber(Long whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getAddressPermanent() {
		return addressPermanent;
	}

	public void setAddressPermanent(String addressPermanent) {
		this.addressPermanent = addressPermanent;
	}

	public String getAddressPresent() {
		return addressPresent;
	}

	public void setAddressPresent(String addressPresent) {
		this.addressPresent = addressPresent;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public Long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Long getAlterNumber() {
		return alterNumber;
	}

	public void setAlterNumber(Long alterNumber) {
		this.alterNumber = alterNumber;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public List<MultipartFile> getDoc() {
		return doc;
	}

	public void setDoc(List<MultipartFile> doc) {
		this.doc = doc;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public List<SalaryDetails> getSalaryDetails() {
		return salaryDetails;
	}

	public void setSalaryDetails(List<SalaryDetails> salaryDetails) {
		this.salaryDetails = salaryDetails;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmployeeMasterTable() {

	}

	public EmployeeMasterTable(Long id, String firstName, double basicSalary, String middleName, String lastName,
			String email, Long mobile, Long whatsappNumber, String gender, String fatherName, String motherName,
			String spouseName, String addressPermanent, String addressPresent, String maritalStatus, Long alterNumber,
			String bankName, Long accountNumber, String ifscCode, String panNo, Long aadharNumber,
			String highestQualification, String passportNumber, String employeeCode, Long designationid,
			Long departmentId, Double ctc, String remark, Date doj, String dob, List<SalaryDetails> salaryDetails,
			Designation designation, Department department, List<MultipartFile> doc, List<String> description) {
		super();
		this.id = id;
		this.firstName = firstName;
		//this.basicSalary = basicSalary;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.whatsappNumber = whatsappNumber;
		this.gender = gender;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.spouseName = spouseName;
		this.addressPermanent = addressPermanent;
		this.addressPresent = addressPresent;
		this.maritalStatus = maritalStatus;
		this.alterNumber = alterNumber;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.panNo = panNo;
		this.aadharNumber = aadharNumber;
		this.highestQualification = highestQualification;
		this.passportNumber = passportNumber;
		this.employeeCode = employeeCode;
		this.designationid = designationid;
		this.departmentId = departmentId;
		this.ctc = ctc;
		this.remark = remark;
		this.doj = doj;
		this.dob = dob;
		this.salaryDetails = salaryDetails;
		this.designation = designation;
		this.department = department;
		this.doc = doc;
		this.description = description;
	}
}