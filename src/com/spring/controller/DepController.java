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

import com.spring.dao.DepartmentDao;
import com.spring.employee.Department;
import com.spring.service.DepService;
  
  @Controller 
  public class DepController {
  
  @Autowired 
  private DepartmentDao departmentDao;
  
  @Autowired
  private DepService depService;
 
  @RequestMapping(value = "/saveDep", method =RequestMethod.POST) 
  public String saveDepartment(@ModelAttribute("depForm") Department department ,HttpServletRequest request) {
	  department.setStatus(1L);
		  depService.addDepartment(department);	 
	    return "redirect:departmentList"; 
  }
  @RequestMapping(value="/addDepartment", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String addDepartment(Department department, Model model) { 
	  Department em=new Department(); 
	  model.addAttribute("depForm", em);
  return "addDep"; 
  }
  @RequestMapping(value="/departmentList", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String listDepartment(Model model) { 
	  model.addAttribute("depList", depService.listDepartment());
		 List<Department> departments= departmentDao.getDepartment();
		  model.addAttribute("depList", departments);	 
		  return "depList";
	  }
  @RequestMapping(value = "/updateDep/{id}", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String editDepartment(@PathVariable("id") Long id,HttpServletRequest request,Model model){ 
	  Department em=new Department();
      em = this.departmentDao.getDepartmentById(id);
		model.addAttribute("depForm", em);
		List<Department> deList=departmentDao.getDepartment();
		model.addAttribute("depList", deList);
		return "addDep";
	  }
  @RequestMapping(value="/deleteDep/{id}",method = {RequestMethod.GET,RequestMethod.POST}) 
  public String deleteDepartment( @PathVariable("id")Long id,Model model) { 
	  Department departmentById = departmentDao.getDepartmentById(id);
	  departmentById.setStatus(3L);
	  depService.addDepartment(departmentById);
	  model.addAttribute("depList", depService.listDepartment());	
		 List<Department> department = departmentDao.getDepartment();
		  model.addAttribute("depList", department);	
		return "redirect:/departmentList"; 
	  } 
  }

  
  
  
 