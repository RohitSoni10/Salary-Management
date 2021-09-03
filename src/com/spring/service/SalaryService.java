package com.spring.service;
import java.util.List;
import com.spring.employee.SalaryDetails;
  
public interface SalaryService {  
  public void updateSalary(Long id);
  public List<SalaryDetails> listSalary();
  public SalaryDetails getSalaryById(Long id);
  public void deleteSalary(Long id);
  public void addSalary(SalaryDetails salaryDetails);
  }
 