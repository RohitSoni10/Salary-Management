package com.spring.serviceImpl; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.DesignationDao; 
import com.spring.employee.Designation;
import com.spring.service.DesService;
  
  @Service 
  @EnableTransactionManagement
  public class DesServiceImpl implements DesService{
 
  @Autowired 
  private DesignationDao desDeo;
  @Override 
  @Transactional
  public List<Designation> getDesignationList() { 
	  return desDeo.getDesignationList(); }
  
  @Override 
  @Transactional
  public void deleteDesignation(int id) { 
	  desDeo.deleteDes(id); }
  
  @Override 
  @Transactional
  public void saveDesignation(Designation designation) {
  desDeo.addDesignation(designation); }
  
  @Override 
  @Transactional
  public Designation updateDesignation(Long id) { 
	  return desDeo.updateDesignation(id); }
  
  @Override 
  @Transactional
  public Designation getDesignationById(Long id) { 
	  return desDeo.getDesignationById(id); } 
  }