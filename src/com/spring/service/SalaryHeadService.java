package com.spring.service;

import java.util.List;

import com.spring.modalmaster.SalaryHead;

public interface SalaryHeadService {
	  public void updateSalaryHead(Long id);
	  public List<SalaryHead> listSalaryHead();
	  public SalaryHead getSalaryHeadById(Long id);
	  public void deleteSalaryHead(Long id);
	  public void addSalaryHead(SalaryHead salaryHead);
}
