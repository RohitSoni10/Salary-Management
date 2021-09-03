package com.spring.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployeeDao;
import com.spring.employee.EmployeeMasterTable;
import com.spring.service.EmployeeService;
@Service
@EnableTransactionManagement
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public void addEmployee(EmployeeMasterTable employeeMasterTable) {
		employeeDao.addEmployee(employeeMasterTable);
	}
	@Override
	@Transactional
	public EmployeeMasterTable updateEmployee(Long id) {
		return employeeDao.updateEmployee(id);		
	}
	@Override
	@Transactional
	public List<EmployeeMasterTable> getEmployeeList() {
		return employeeDao.getEmployeeList();
	}
	@Override
	@Transactional
	public EmployeeMasterTable getEmployeeById(Long id) {	
		return employeeDao.getEmployeeById(id);
	}
	@Override
	@Transactional
	public void deleteEmployee(Long id) {
		employeeDao.deleteEmployee(id);
	}
	
	 
	  @Override
	  @Transactional 
	  public EmployeeMasterTable getSalary(Long id) {
	  return null; }
	 
}