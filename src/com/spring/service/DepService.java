package com.spring.service;
import java.util.List;
import com.spring.employee.Department;
  
public interface DepService {
  public void addDepartment(Department department);
  public Department updateDepartment(Long id);
  public List<Department> listDepartment();
  public Department getDepartmentById(Long id);
  public void deleteDepartment(Long id); 
  }
 