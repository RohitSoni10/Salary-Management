package com.spring.serviceImpl; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.DepartmentDao; 
import com.spring.employee.Department;
import com.spring.service.DepService;

@Service 
@EnableTransactionManagement
public class DepServiceImpl implements DepService{
  
  @Autowired 
  private DepartmentDao dao;
  
  @Override 
  @Transactional
  public void addDepartment(Department department) {
  dao.saveDepartment(department); }
  
  @Override 
  @Transactional
  public Department updateDepartment(Long id) { 
	  return dao.updateDepartment(id); }
  
  @Override 
  @Transactional
  public List<Department> listDepartment() { 
	  return dao.getDepartment(); }
  
  @Override 
  @Transactional
  public Department getDepartmentById(Long id) { 
	  return dao.getDepartmentById(id); }
  
  @Override 
  @Transactional
  public void deleteDepartment(Long id) { 
	  dao.deleteDepartment(id); }
  }
