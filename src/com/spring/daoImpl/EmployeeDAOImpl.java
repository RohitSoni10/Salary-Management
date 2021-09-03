package com.spring.daoImpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployeeDao;
import com.spring.employee.EmployeeMasterTable;
@Repository
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDao{

	  private SessionFactory sessionFactory;
	  @Autowired 
	  public void setSessionFactory(SessionFactory sessionFactory){
	  this.sessionFactory=sessionFactory; 
	  }//setSessionFactory	
	@Override
	@Transactional
	public void addEmployee(EmployeeMasterTable employeeMasterTable) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(employeeMasterTable);
		  tx.commit();
		  session.close();	
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EmployeeMasterTable> getEmployeeList() {
		Session session = sessionFactory.openSession();
		  List<EmployeeMasterTable> list = session.getSessionFactory().getCurrentSession().createQuery(" "
		  		+ "from EmployeeMasterTable where status!=3 order by id desc").list();
		  session.close();
		 return list; 
	 }
	@Override
	@Transactional
	public EmployeeMasterTable getEmployeeById(Long id) {
		Session session = sessionFactory.openSession();	
			EmployeeMasterTable employeeMasterTable= session.get(EmployeeMasterTable.class, id);
			session.close();
			return employeeMasterTable;	
	}
	@Override
	@Transactional
	public EmployeeMasterTable updateEmployee(Long id) {
		Session session = sessionFactory.openSession();
		EmployeeMasterTable employeeMasterTable=session.get(EmployeeMasterTable.class, id);
		session.update(employeeMasterTable);
		session.close();
		return employeeMasterTable;
	}
	@Override
	@Transactional
	public void deleteEmployee(Long id) {
		Session session = sessionFactory.openSession();
		EmployeeMasterTable employeeMasterTable= session.get(EmployeeMasterTable.class, id);
		session.update(employeeMasterTable);
		session.close();
	}

}
