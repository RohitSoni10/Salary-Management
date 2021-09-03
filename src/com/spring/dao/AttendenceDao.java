package com.spring.dao;

import java.util.List;

import com.spring.employee.Attendence;

public interface AttendenceDao {

	public List<Attendence> getAttendenceList();
	public Attendence getAttendenceById(Long id);
	List<Attendence> findCustom(Long id, String string, String string2);


}
