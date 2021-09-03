package com.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.SalaryHeadDao;
import com.spring.modalmaster.SalaryHead;
import com.spring.service.SalaryHeadService;

@Service
@EnableTransactionManagement 
public class SalaryHeadServiceImpl implements SalaryHeadService {
  @Autowired 
  private SalaryHeadDao salaryHeadDao;
  @Override
  @Transactional 
  public void updateSalaryHead(Long id) {
	  salaryHeadDao.updateSalaryHead(id); }
  
  @Override
  @Transactional 
  public List<SalaryHead> listSalaryHead() { 
	  return salaryHeadDao.listSalaryHead(); }
  
  @Override 
  @Transactional 
  public SalaryHead getSalaryHeadById(Long id) { 
	  return salaryHeadDao.getSalaryHeadById(id); }
  
  @Override
  @Transactional 
  public void deleteSalaryHead(Long id) {
	  salaryHeadDao.deleteSalaryHead(id); }
  
  @Override 
  @Transactional 
  public void addSalaryHead(SalaryHead salaryHead) {
	  salaryHeadDao.addSalaryHead(salaryHead); }  
  }
