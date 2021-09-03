package com.spring.controller;
import java.util.ArrayList;
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
import com.spring.dao.DesignationDao;
import com.spring.dao.EmployeeDao;
import com.spring.dao.SalaryDao;
import com.spring.dao.SalaryHeadDao;
import com.spring.employee.Department;
import com.spring.employee.Designation;
import com.spring.employee.EmployeeMasterTable;
import com.spring.employee.SalaryDetails;
import com.spring.modalmaster.SalaryHead;
import com.spring.service.EmployeeService;

@Controller
public class EmpController {
	
	   @Autowired
	   private EmployeeService employeeService;
	   @Autowired
	   private EmployeeDao employeeDao;
	   @Autowired
	   private DesignationDao designationDao;
	   @Autowired
	   private DepartmentDao departmentDao;
	   @Autowired
	   private SalaryHeadDao salaryHeadDao;
	   @Autowired
	   private SalaryDao salaryDao;

	   
	   @RequestMapping(value="/saveEmployee",method = RequestMethod.POST)
	   public String saveEmployee(@ModelAttribute("userForm") EmployeeMasterTable employee,HttpServletRequest request) { 
	    		employee.setStatus(1L);
	    		List<SalaryDetails> salaryDetails = new ArrayList<SalaryDetails>();
	    		String[] salaryHeadIds = request.getParameterValues("salaryHeadId");
	    		String[] values = request.getParameterValues("value");
	    		String[] ids = request.getParameterValues("salaryDetailid");
	    		if(salaryHeadIds.length > 0) {
	    			for (int i = 0; i < salaryHeadIds.length; i++) {
						Long salaryHeadId = Long.parseLong(salaryHeadIds[i]);
						SalaryDetails salary = new SalaryDetails();
						salary.setSalaryHeadId(salaryHeadId);
						if(!values[i].equals(""))
							salary.setValue(Long.parseLong(values[i]));
						if(!ids[i].equals(""))
							salary.setId(Long.parseLong(ids[i]));
						salaryDetails.add(salary);
					}
	    		}
	    		employee.setSalaryDetails(salaryDetails);
			  employeeService.addEmployee(employee);	 
		    return "redirect:empList";
	    }
	    @RequestMapping(value="/addEmployee", method = {RequestMethod.GET,RequestMethod.POST})
		   public String addEmployee(EmployeeMasterTable employee,Model model) {
			   EmployeeMasterTable em=new EmployeeMasterTable();
			   List<SalaryDetails> salarDetails = new ArrayList<SalaryDetails>();
			   List<SalaryHead> salaryHeads = this.salaryHeadDao.listActiveSalaryHead();
			   for (SalaryHead salaryHead : salaryHeads) {
				   SalaryDetails salary = new SalaryDetails();
				   salary.setSalaryHeadId(salaryHead.getId());
				   salary.setSalaryHead(salaryHead);
				   salarDetails.add(salary);
			   }
			   em.setSalaryDetails(salarDetails);
				model.addAttribute("userForm", em);
				List<Designation> deList=designationDao.getDesignationList();
				//List<CommonResponsibleDropDownObject> deList=designationDao.getSelectionList();
				model.addAttribute("desList", deList);
				List<Department> depList=departmentDao.getDepartment();	
				//List<CommonResponsibleDropDownObject> depList=departmentDao.getSelectionList();	
				model.addAttribute("depList", depList);	
				List<SalaryDetails> salaryDetails=salaryDao.listSalary();
				model.addAttribute("salaryForm", salaryDetails);
				return "addEmployee";
		   }
		   @RequestMapping(value="/empList", method = {RequestMethod.GET,RequestMethod.POST})
		   public String listEmployees(Model model) {
		        model.addAttribute("userList", employeeService.getEmployeeList());	
				 List<EmployeeMasterTable> employeeMasterTables = employeeDao.getEmployeeList();
				  model.addAttribute("userList", employeeMasterTables);	 
		    return "empList";
		   }
		    @RequestMapping(value = "/update/{id}", method = {RequestMethod.GET,RequestMethod.POST})
		    public String editEmployee(@PathVariable("id") Long id,HttpServletRequest request,Model model){
		      EmployeeMasterTable em=new EmployeeMasterTable();
		      em = this.employeeDao.getEmployeeById(id);
		      List<SalaryDetails> salarDetails = em.getSalaryDetails();
			  List<SalaryHead> salaryHeads = this.salaryHeadDao.listActiveSalaryHead();
			  for (SalaryHead salaryHead : salaryHeads) {
				  	if(salarDetails.stream().filter(x->x.getSalaryHeadId()==salaryHead.getId()).toArray().length==0) {
				  		SalaryDetails salary = new SalaryDetails();
				  		salary.setSalaryHeadId(salaryHead.getId());
				  		salary.setSalaryHead(salaryHead);
				  		salarDetails.add(salary);
				  		System.out.println();
				  	}
			  }
				model.addAttribute("userForm", em);
				List<Designation> deList=designationDao.getDesignationList();	
				model.addAttribute("desList", deList);
				List<Department> depList=departmentDao.getDepartment();	
				model.addAttribute("depList", depList);
				return "addEmployee";
		    }
		    @RequestMapping(value="/delete/{id}",method = {RequestMethod.GET,RequestMethod.POST})
		    public String deleteEmployee(@PathVariable("id") Long id,Model model) {
		    		EmployeeMasterTable employeeById = employeeDao.getEmployeeById(id);
		    		employeeById.setStatus(3L);
				    employeeService.addEmployee(employeeById);
				    model.addAttribute("userList", employeeService.getEmployeeList());	
					 List<EmployeeMasterTable> employeeMasterTables = employeeDao.getEmployeeList();
					  model.addAttribute("userList", employeeMasterTables);	 
			    return "redirect:/empList";
		    }    
}

