package com.spring.controller; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.DesignationDao;
import com.spring.employee.Designation;
import com.spring.service.DesService;
  
@Controller 
public class DesController {
 
 @Autowired 
 private DesService desService;
 
 @Autowired 
 private DesignationDao designationDao; 
  @RequestMapping(value = "/saveDes", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String saveDesignation(@ModelAttribute("desForm") Designation designation,HttpServletRequest request) { 
	  designation.setStatus(1L);
	  desService.saveDesignation(designation);
  return "redirect:designationList"; 
  }  
  @RequestMapping(value="/addDesignation", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String addDesignation(Designation designation, Model model) { 
	  Designation em=new Designation(); 
	  model.addAttribute("desForm", em); 
	  return "addDes"; 
  }
  
  @RequestMapping(value="/designationList", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String listDesignation(Model model) { 
	  model.addAttribute("desList", desService.getDesignationList()); 
	  List<Designation> designations= designationDao.getDesignationList();
	  model.addAttribute("desList", designations); 
	  return "desList"; 
	  }
  
  @RequestMapping(value = "/updateDes/{id}", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String editDesignation(@PathVariable("id") Long id,HttpServletRequest request, Model model){ 
	  Designation em=new Designation(); 
	  em = this.designationDao.getDesignationById(id);
	  model.addAttribute("desForm", em); 
	  List<Designation> deList=designationDao.getDesignationList();	
		model.addAttribute("desList", deList);
  return "addDes"; 
  }
  @RequestMapping(value="/deleteDes/{id}",method = {RequestMethod.GET,RequestMethod.POST}) 
  public String deleteDesignation(@PathVariable("id") Long id,Model model) { 	
	  Designation designationById = designationDao.getDesignationById(id);
	  designationById.setStatus(3L);
	  desService.saveDesignation(designationById);
	  model.addAttribute("desList", desService.getDesignationList()); 
	  List<Designation> designations= designationDao.getDesignationList();
	  model.addAttribute("desList", designations);   
	    return "redirect:/designationList";
	  } 
  }
    
  

  
  
  
  
  
 