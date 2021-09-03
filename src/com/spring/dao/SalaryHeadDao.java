package com.spring.dao;
import java.util.List;
import com.spring.modalmaster.SalaryHead;
public interface SalaryHeadDao {
	  public SalaryHead updateSalaryHead(Long id); 
	  public List<SalaryHead> listSalaryHead();
	  public SalaryHead getSalaryHeadById(Long id);
	  public void deleteSalaryHead(Long id);
	  public void addSalaryHead(SalaryHead salaryHead);
	public List<SalaryHead> getAllocationList();
	public List<SalaryHead> getDeductionlist();
	List<SalaryHead> listActiveSalaryHead();
}
