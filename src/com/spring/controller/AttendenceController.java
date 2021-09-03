package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.AttendenceDao;
import com.spring.employee.Attendence;
import com.spring.service.AttendenceService;
@Controller
public class AttendenceController {
	
	@Autowired
	private AttendenceService attendenceService;
	@Autowired
	private AttendenceDao attendenceDao;
	
	  @RequestMapping(value="/attendenceList", method = {RequestMethod.GET,RequestMethod.POST}) 
	  public String listAttendence(Model model) { 
		  model.addAttribute("attList", attendenceService.getAttendenceList()); 
		  List<Attendence> attendence= attendenceDao.getAttendenceList();
		  model.addAttribute("attList", attendence); 
		  return "attList"; 
		  }
	  
}
