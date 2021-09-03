package com.spring.dao;
import java.util.List;

import com.spring.employee.SalaryDetails;
  
public interface SalaryDao {
  public SalaryDetails updateSalary(Long id); 
  public List<SalaryDetails> listSalary();
  public SalaryDetails getSalaryById(Long id);
  public void deleteSalary(Long id);
  public void addSalary(SalaryDetails salaryDetails);
  public List<SalaryDetails> findCustom(Long salaryHeadId);
  }
 