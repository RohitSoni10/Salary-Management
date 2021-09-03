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

import com.spring.dao.SalaryHeadDao;
import com.spring.modalmaster.SalaryHead;
import com.spring.service.SalaryHeadService;

  
@Controller 
public class SalHeadController {
  
  @Autowired 
  private SalaryHeadService salaryHeadService;
  @Autowired 
  private SalaryHeadDao salaryHeadDao;
  @RequestMapping(value = "/saveSalaryHead", method =RequestMethod.POST) 
  public String saveSalaryHead(@ModelAttribute("salaryHeadForm") SalaryHead details,HttpServletRequest request) { 
	  details.setStatus(1L);
	  salaryHeadService.addSalaryHead(details);	 
    return "redirect:SalaryHeadList"; 
	  }
  @RequestMapping(value="/addSalaryHead", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String addSalaryHead(SalaryHead salaryHead, Model model){ 
	  SalaryHead details=new SalaryHead(); 
	  model.addAttribute("salaryHeadForm",details); 
	  return "salaryHead"; 
	  }
  
  @RequestMapping(value="/SalaryHeadList", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String listSalaryHead( Model model) { 
	  model.addAttribute("salHeadList", salaryHeadService.listSalaryHead());
	  List<SalaryHead> salaryHead= salaryHeadService.listSalaryHead();
	  model.addAttribute("salHeadList", salaryHead); 
	  return "salaryHeadList"; 
	  }
  
  @RequestMapping(value="/deleteSalaryHead/{id}",method = {RequestMethod.GET,RequestMethod.POST}) 
  public String deleteSalaryHead(@PathVariable("id") Long id,Model model) {
	  SalaryHead salaryHeadById = salaryHeadDao.getSalaryHeadById(id);
	  salaryHeadById.setStatus(3L);
	  salaryHeadService.addSalaryHead(salaryHeadById);
	  model.addAttribute("salaryHeadList", salaryHeadById);
		 List<SalaryHead> salaryHeads = salaryHeadService.listSalaryHead();
		  model.addAttribute("salaHeadList", salaryHeads); 
  return "redirect:/SalaryHeadList"; 
  }
  
  @RequestMapping(value = "/updateSalaryHead/{id}", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String updateSalaryHead( @PathVariable("id")Long id,HttpServletRequest request,Model model) { 
	  SalaryHead salaryHead = new SalaryHead();
	  salaryHead=this.salaryHeadDao.getSalaryHeadById(id);
	  model.addAttribute("salaryHeadForm", salaryHead);
	  List<SalaryHead> list = salaryHeadDao.listSalaryHead();
	  model.addAttribute("salaryHeadList", list); 
	  return "salaryHead"; 
	  } 
  }


