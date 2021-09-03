package com.spring.service;
import java.util.List;
import com.spring.employee.Designation;
  
public interface DesService { 
	public void saveDesignation(Designation designation); 
	public List<Designation> getDesignationList(); 
	public void deleteDesignation(int id); 
	public Designation updateDesignation(Long id);
	public Designation getDesignationById(Long id);
  }
 