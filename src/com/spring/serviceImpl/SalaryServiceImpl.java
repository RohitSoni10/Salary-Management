package com.spring.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.spring.dao.SalaryDao; 
import com.spring.employee.SalaryDetails;
import com.spring.service.SalaryService;
  
@Service
@EnableTransactionManagement 
public class SalaryServiceImpl implements SalaryService {
  @Autowired 
  private SalaryDao salaryDao;
  @Override
  @Transactional 
  public void updateSalary(Long id) {
  salaryDao.updateSalary(id); }
  
  @Override
  @Transactional 
  public List<SalaryDetails> listSalary() { 
	  return salaryDao.listSalary(); }
  
  @Override 
  @Transactional 
  public SalaryDetails getSalaryById(Long id) { 
	  return salaryDao.getSalaryById(id); }
  
  @Override
  @Transactional 
  public void deleteSalary(Long id) {
  salaryDao.deleteSalary(id); }
  
  @Override 
  @Transactional 
  public void addSalary(SalaryDetails salaryDetails) {
	  
  salaryDao.addSalary(salaryDetails); }  
  }
