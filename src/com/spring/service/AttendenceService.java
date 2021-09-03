package com.spring.service;

import java.util.List;

import com.spring.employee.Attendence;

public interface AttendenceService {
	public List<Attendence> getAttendenceList();
	public Attendence getAttendenceById(Long id);
}
