package com.spring.dao;
import java.util.List;
import com.spring.employee.Designation;
import com.spring.model.CommonResponsibleDropDownObject;
  
public interface DesignationDao {
  
  public void addDesignation(Designation desModal); 
  public List<Designation> getDesignationList(); 
  public void deleteDes(int id); 
  public Designation updateDesignation(Long id); 
  public Designation getDesignationById(Long id);
  public List<CommonResponsibleDropDownObject> getSelectionList(); 
  }
 