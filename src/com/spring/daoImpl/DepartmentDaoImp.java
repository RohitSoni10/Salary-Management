package com.spring.daoImpl; 
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.DepartmentDao;
import com.spring.employee.Department;
import com.spring.model.CommonResponsibleDropDownObject;

@Repository
@EnableTransactionManagement
public class DepartmentDaoImp implements DepartmentDao {

  private SessionFactory sessionFactory;
  
  @Autowired 
  public void setSessionFactory(SessionFactory sessionFactory){
  this.sessionFactory=sessionFactory; }//setSessionFactory
  
  @Override 
  @Transactional
  public void saveDepartment(Department department) { 
	  Session session= sessionFactory.openSession(); 
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(department);
	  tx.commit(); 
	  session.close(); }

  	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Department> getDepartment() { 
		Session session = sessionFactory.openSession(); 
		  List<Department> list = session.getSessionFactory().getCurrentSession().createQuery(" from Department where status!=3 order by id desc").list();
		  session.close();
		 return list;
		}
  
  @Override 
  @Transactional
  public Department getDepartmentById(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  // now retrieve/read from database using the primary key 
	  Department department= currentSession.get(Department.class, id); 
	  currentSession.close(); 
	  return department; }
  
  @Override 
  @Transactional
  public Department updateDepartment(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  Department department=currentSession.get(Department.class, id);
	  currentSession.update(department); 
	  currentSession.close(); 
	  return department; }
  
  @Override 
  @Transactional
  public void deleteDepartment(Long id) { 
	  Session currentSession = sessionFactory.openSession(); 
	  Department department=currentSession.get(Department.class, id);
	  currentSession.update(department);
	  currentSession.close(); }

@SuppressWarnings("unchecked")
@Override
@Transactional
public List<CommonResponsibleDropDownObject> getSelectionList() {
	Session session = sessionFactory.openSession();
	  List<CommonResponsibleDropDownObject> list = session.getSessionFactory().getCurrentSession().createQuery("select new com.spring.model.CommonResponsibleDropDownObject(d.id,d.department) from Department d where d.status!=3 order by d.id desc").list();
	  session.close();
	 return list;
} 
  }