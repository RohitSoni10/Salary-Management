package com.spring.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.AttendenceDao;
import com.spring.employee.Attendence;
@Repository 
@EnableTransactionManagement
public class AttendenceDaoImpl implements AttendenceDao{
	

	  private SessionFactory sessionFactory;
	  
	  @Autowired 
	  public void setSessionFactory(SessionFactory sessionFactory){
	  this.sessionFactory=sessionFactory; 
	  }//setSessionFactory

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Attendence> getAttendenceList() {
		Session session = sessionFactory.openSession();
			  List<Attendence> list = session.getSessionFactory().getCurrentSession().createQuery(" "
			  		+ "from Attendence").list();
			  session.close();
			 return list; 
	}
	@Override
	public Attendence getAttendenceById(Long id) {
		Session session = sessionFactory.openSession();	
		// now retrieve/read from database using the primary key
			Attendence Attendence= session.get(Attendence.class, id);
			session.close();
			return Attendence;
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Attendence> findCustom(Long id, String fromDate, String toDate) {
		Session session = sessionFactory.openSession();
		List<Attendence> listAttendence =  session.getSessionFactory().getCurrentSession().createQuery(" "
		  		+ "from Attendence where employeeMasterTable.id = '"+id+"' and AttendenceStatus !='Absent' and create_date between '"+fromDate+"' "
		  				+ "and '"+toDate+"'  order by id desc").list();
		session.close();
		return listAttendence;

	}

}
