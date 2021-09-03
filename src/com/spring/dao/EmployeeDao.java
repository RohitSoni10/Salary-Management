package com.spring.dao;
import java.util.List;

import com.spring.employee.EmployeeMasterTable;


public interface EmployeeDao{

	public void addEmployee(EmployeeMasterTable employeeMasterTable);
	public EmployeeMasterTable updateEmployee(Long id);
	public List<EmployeeMasterTable> getEmployeeList();
	public EmployeeMasterTable getEmployeeById(Long id);
	public void deleteEmployee(Long id);
	
}
