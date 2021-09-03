package com.spring.daoImpl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.SalaryDao;
import com.spring.employee.SalaryDetails;  
  @Repository
  @EnableTransactionManagement
  public class SalaryDaoImpl implements SalaryDao {

  private SessionFactory sessionFactory;
  
  @Autowired 
  public void setSessionFactory(SessionFactory sessionFactory){
  this.sessionFactory=sessionFactory; }//setSessionFactory
  
  @Override 
  @Transactional
  public void addSalary(SalaryDetails salaryDetails) { 	
	  
	  Session currentSession = sessionFactory.openSession(); 
	  Transaction tx = currentSession.beginTransaction();
	  currentSession.saveOrUpdate(salaryDetails);
	  tx.commit(); 
	  currentSession.close(); }
  
  @Override 
  @Transactional
  public SalaryDetails updateSalary(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  SalaryDetails salaryDetails=currentSession.get(SalaryDetails.class, id);
	  currentSession.update(salaryDetails); 
	  currentSession.close(); 
	  return salaryDetails; }
  
  @SuppressWarnings("unchecked")
  @Override 
  @Transactional
  public List<SalaryDetails> listSalary() { 
	  Session session = sessionFactory.openSession();
		  List<SalaryDetails> list = session.getSessionFactory().getCurrentSession().createQuery("from SalaryDetails").list();
		  session.close(); 
		  return list;
	   }
  @Override 
  @Transactional
  public SalaryDetails getSalaryById(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  // now retrieve/read from database using the primary key 
	  SalaryDetails salaryDetails= currentSession.get(SalaryDetails.class, id); 
	  currentSession.close(); 
	  return salaryDetails; }
  
  @Override 
  @Transactional
  public void deleteSalary(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  SalaryDetails salaryDetails=currentSession.get(SalaryDetails.class, id);
	  currentSession.delete(salaryDetails); 
	  currentSession.close();
	  
  }

@SuppressWarnings({ "unchecked", "unused" })
@Override
@Transactional
public  List<SalaryDetails> findCustom(Long salaryHeadId) {
	Session session = sessionFactory.openSession();
	Criteria query= session.createCriteria(SalaryDetails.class);
	  List<SalaryDetails> salaryDetails = session.getSessionFactory().getCurrentSession().createQuery("from SalaryDetails where salary_head_id =salaryHeadId").list();
	  session.close(); 
	  return salaryDetails;
} 
  }