package com.spring.daoImpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.DesignationDao;
import com.spring.employee.Designation;
import com.spring.model.CommonResponsibleDropDownObject;
  
  @Repository 
  @EnableTransactionManagement

  public class desDaoImpl implements DesignationDao{

  private SessionFactory sessionFactory;
  @Autowired 
  public void setSessionFactory(SessionFactory sessionFactory){
  this.sessionFactory=sessionFactory; }//setSessionFactory
  
  @Override 
  public void addDesignation(Designation des) { 
	  Session currentSession = sessionFactory.openSession(); 
	  Transaction tx = currentSession.beginTransaction(); 
	  currentSession.saveOrUpdate(des);
	  tx.commit(); 
	  currentSession.close(); }
  
  @SuppressWarnings("unchecked")
  @Override
  @Transactional 
  public List<Designation> getDesignationList() { 
		Session session = sessionFactory.openSession(); 
		  List<Designation> list = session.getSessionFactory().getCurrentSession().createQuery(" from Designation where status!=3 order by id desc").list(); 
		  session.close();
		 return list; }
  
  @Override 
  @Transactional
  public Designation updateDesignation(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  Designation designation=currentSession.get(Designation.class, id);
	  currentSession.saveOrUpdate(designation); 
	  currentSession.close(); 
	  return designation; }
  
  @Override 
  @Transactional
  public void deleteDes(int id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  Designation designation= currentSession.get(Designation.class, id);
	  currentSession.delete(designation); 
	  currentSession.close(); }
  
  @Override 
  @Transactional
  public Designation getDesignationById(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  // now retrieve/read from database using the primary key 
	  Designation designation= currentSession.get(Designation.class, id); 
	  currentSession.close(); 
	  return designation; }

@SuppressWarnings("unchecked")
@Override
@Transactional
public List<CommonResponsibleDropDownObject> getSelectionList() {
	Session session = sessionFactory.openSession(); 
	  List<CommonResponsibleDropDownObject> list = session.getSessionFactory().getCurrentSession().createQuery("  select new com.spring.model.CommonResponsibleDropDownObject(d.id,d.designation) from Designation d where d.status!=3 order by d.id desc").list(); 
	  session.close();
	 return list; 
	}
  }