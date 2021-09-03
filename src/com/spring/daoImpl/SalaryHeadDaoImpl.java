package com.spring.daoImpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.SalaryHeadDao;
import com.spring.modalmaster.SalaryHead;  
  @Repository
  @EnableTransactionManagement
  public class SalaryHeadDaoImpl implements SalaryHeadDao {

  private SessionFactory sessionFactory;
  
  @Autowired 
  public void setSessionFactory(SessionFactory sessionFactory){
  this.sessionFactory=sessionFactory; }//setSessionFactory
  
  @Override 
  @Transactional
  public void addSalaryHead(SalaryHead salaryHead) { 	
	  
	  Session currentSession = sessionFactory.openSession(); 
	  Transaction tx = currentSession.beginTransaction();
	  currentSession.saveOrUpdate(salaryHead);
	  tx.commit(); 
	  currentSession.close(); }
  
  @Override 
  @Transactional
  public SalaryHead updateSalaryHead(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  SalaryHead salaryHead=currentSession.get(SalaryHead.class, id);
	  currentSession.update(salaryHead); 
	  currentSession.close(); 
	  return salaryHead; }
  
  @SuppressWarnings({ "unchecked"})
  @Override 
  @Transactional
  public List<SalaryHead> listSalaryHead() { 
	  Session session = sessionFactory.openSession();
//	  Criteria query= session.createCriteria(SalaryHead.class,"status!=3"); 
	  List<SalaryHead> list = session.getSessionFactory().getCurrentSession().createQuery(" "
	  		+ "from SalaryHead where status!=3 order by id desc").list();
	  session.close();
		  return list;
  }
  @SuppressWarnings("unchecked")
@Override 
  @Transactional
  public List<SalaryHead> listActiveSalaryHead() { 
	  Session session = sessionFactory.openSession();
  //Criteria query= session.createCriteria(SalaryHead.class,"status=1"); 
	  List<SalaryHead> list = session.getSessionFactory().getCurrentSession().createQuery(" "
	  		+ "from SalaryHead  where status=1 order by id desc").list();
	  session.close();
		  return list;
  }
  @Override 
  @Transactional
  public SalaryHead getSalaryHeadById(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  // now retrieve/read from database using the primary key 
	  SalaryHead salaryHead= currentSession.get(SalaryHead.class, id); 
	  currentSession.close(); 
	  return salaryHead; }
  
  @Override 
  @Transactional
  public void deleteSalaryHead(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  SalaryHead salaryHead=currentSession.get(SalaryHead.class, id);
	  //currentSession.delete(salaryHead);
	  currentSession.update(salaryHead);
	  currentSession.close();	  
  }

@SuppressWarnings("unchecked")
@Override
@Transactional
public List<SalaryHead> getAllocationList() {
	 Session session = sessionFactory.openSession();
	
//	Criteria query= session.createCriteria(SalaryHead.class,"status!=3 and salary_type = 'Allowance'"); 
	  List<SalaryHead> list = session.getSessionFactory().getCurrentSession().createQuery(" "
	  		+ "from SalaryHead where status!=3 and salary_type = 'Allowance' order by id desc").list();
	  session.close();
		  return list;
}

@SuppressWarnings("unchecked")
@Override
@Transactional
public List<SalaryHead> getDeductionlist() {
	 Session session = sessionFactory.openSession();
	
//	Criteria query= session.createCriteria(SalaryHead.class,"status!=3 and salary_type = 'Deduction'"); 
	  List<SalaryHead> list = session.getSessionFactory().getCurrentSession().createQuery(" "
	  		+ "from SalaryHead where status!=3 and salary_type = 'Deduction' order by id desc").list();
	  session.close();
		  return list;
}

}