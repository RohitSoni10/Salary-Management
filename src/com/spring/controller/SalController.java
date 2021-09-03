package com.spring.controller; 
import java.text.ParseException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dao.AttendenceDao;
import com.spring.dao.EmployeeDao;
import com.spring.dao.SalaryDao;
import com.spring.dao.SalaryHeadDao;
import com.spring.employee.Attendence;
import com.spring.employee.EmployeeMasterTable;
import com.spring.employee.SalaryDetails;
import com.spring.modalmaster.SalaryHead;
import com.spring.service.EmployeeService;
import com.spring.service.SalaryService;

  
@Controller 
public class SalController {
  
  @Autowired 
  private SalaryService salaryService;
  @Autowired 
  private SalaryDao salaryDao;
  @Autowired
  private SalaryHeadDao salaryHeadDao;
  @Autowired
  private EmployeeService employeeService;
  @Autowired
  private EmployeeDao employeeDao;
  @Autowired
  private AttendenceDao attendenceDao;
 
  @RequestMapping(value = "/saveSalary", method =RequestMethod.POST) 
  public String saveSalary(@ModelAttribute("salList") SalaryDetails Details,HttpServletRequest request,Model model) { 
	  salaryService.addSalary(Details);	
	  model.addAttribute("salList", salaryService.listSalary());
	  List<SalaryDetails> salaryDetails= salaryDao.listSalary();
	  model.addAttribute("salList", salaryDetails);
    return "redirect:salaryList"; 
	  }
  
  @RequestMapping(value="/addSalary", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String addSalary(Model model){ 
	  model.addAttribute("userList", employeeService.getEmployeeList());	
		 List<EmployeeMasterTable> employeeMasterTables = employeeDao.getEmployeeList();
		  model.addAttribute("userList", employeeMasterTables);	 
		  model.addAttribute("userForm", salaryService.listSalary());
		  List<SalaryDetails> salaryDetails= salaryDao.listSalary();
		  model.addAttribute("userForm", salaryDetails);
	  SalaryDetails details=new SalaryDetails(); 
	  model.addAttribute("salaryForm",details); 
	  return "salary"; 
	  }
  
  @RequestMapping(value="/salaryList", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String listSalary( Model model) { 
	  model.addAttribute("salList", salaryService.listSalary());
	  List<SalaryDetails> salaryDetails= salaryDao.listSalary();
	  model.addAttribute("salList", salaryDetails); 
	  return "salaryList"; 
	  }
  
  @RequestMapping(value="/deleteSalary",method = RequestMethod.GET) 
  public String deleteSalary(@RequestParam("id") Long id,HttpServletRequest request,Model model) {
  model.addAttribute("salList",this.salaryDao.getSalaryById(id));
  salaryDao.deleteSalary(id); 
  return "salaryList"; 
  }
  
  @RequestMapping(value = "/updateSalary/{id}", method = {RequestMethod.GET,RequestMethod.POST}) 
  public String updateSalary( @PathVariable("id")Long id,HttpServletRequest request,Model model) { 
	  SalaryDetails details = salaryDao.getSalaryById(id);
	  salaryService.addSalary(details);
	  model.addAttribute("salaryForm", salaryService.listSalary());
	  List<SalaryDetails> deList=salaryDao.listSalary();
	  model.addAttribute("salList", deList); 
	  return "redirect:salaryList"; 
  	  } 
  @SuppressWarnings("unused")
  @RequestMapping(value = "/details", method = {RequestMethod.GET,RequestMethod.POST})
  public String getEmployeeById(Model model,@ModelAttribute("salaryForm") EmployeeMasterTable employee) throws ParseException {	
	  EmployeeMasterTable em=new EmployeeMasterTable();
	  List<Attendence> attendence = new ArrayList<Attendence>();
	  
      em = this.employeeDao.getEmployeeById(employee.getId());
      
	  attendence=this.attendenceDao.findCustom(employee.getId(),employee.getFromDate(),employee.getToDate());
	  List<Attendence> presentDay=attendence.stream().filter(it->it.getAttendenceStatus().equalsIgnoreCase("Present")).collect(Collectors.toList());
	  System.out.println("presentDay count " +presentDay.size());
	  
	  
	  List<Attendence> halfday=attendence.stream().filter(it->it.getAttendenceStatus().equalsIgnoreCase("HalfDay")).collect(Collectors.toList());
	  System.out.println("half day count " +halfday.size());
	  
	  List<Attendence> Leave=attendence.stream().filter(it->it.getAttendenceStatus().equalsIgnoreCase("Leave")).collect(Collectors.toList());
	  System.out.println("Leave count " +Leave.size());
	  
      double allAmount=0;
     
      float ammount1=0;
      float ammount2=0;
      float ammount11=0;
      int homeTakeSalary=0;
      Long basicPayment=0L;
      double dedudctionAmmount=0;
      Optional<SalaryDetails> basicPay=em.getSalaryDetails().stream()
    		  .filter(it->it.getSalaryHead().getCalculatedOn().equalsIgnoreCase("Basic_Pay") &&
    				  it.getSalaryHead().gettitle().equalsIgnoreCase("Basic Salary")).findAny();
      
      if(basicPay.isPresent()) {
    	  SalaryDetails Basicsalary=basicPay.get();
    	  basicPayment =Basicsalary.getValue();
    	  System.out.println("basic pay :"+basicPayment);
      }
      for(SalaryDetails salary:em.getSalaryDetails())
      {
    	  SalaryHead salaryHead=salary.getSalaryHead();
    	  
    	  if(salaryHead.getCalculatedOn().equals("Basic_Pay"))
    	  {
	    	  if(salaryHead.getSalaryType().equals("Allowance"))
	    	  {
	    		  if(salaryHead.getValueType().equalsIgnoreCase("Amount")) {allAmount=allAmount+salary.getValue(); }
		    		  else { 
			    			  	 
			    			      ammount1=ammount1+salary.getValue();
			    			     
		    		  		}
	    		  
	    		      if(ammount1 >0) {
	    		    	  double per= allAmount*ammount1;
	    	 			     allAmount = allAmount+(per/100);
	    	 			     System.out.println("Percent amount: "+allAmount);
	    		      }
	    	  }
	    	  else {
			      if(salaryHead.getSalaryType().equals("Deduction"))
				  {
					  if(salaryHead.getValueType().equalsIgnoreCase("Amount"))
						  dedudctionAmmount=dedudctionAmmount+salary.getValue();  
					  else {
						  ammount11=ammount11+salary.getValue();
					  		} 
					  if(ammount11>0) {
						  double per= basicPayment*ammount11;
						  dedudctionAmmount = dedudctionAmmount+(per/100);
					  }
					  
					  
				  }
    	  }
    	  
    	  if(salaryHead.getCalculatedOn().equals("Current_Earning"))
    	  {
	    	  if(salaryHead.getSalaryType().equals("Allowance"))
	    	  {
	    		  if(salaryHead.getValueType().equalsIgnoreCase("Amount")) {allAmount=allAmount+salary.getValue(); }
		    		  else { 
		    			  
		    			  ammount2=ammount2+salary.getValue();
		    		  		}  
	    		  if(ammount2 >0) {
    		    	  double per= allAmount*ammount2;
    	 			     allAmount = allAmount+(per/100);
    	 			     System.out.println("Percent amount: "+allAmount);
    		      }
	    	  }
    	  
		    	  else {
					      if(salaryHead.getSalaryType().equals("Deduction"))
						  {
							  if(salaryHead.getValueType().equalsIgnoreCase("Amount"))
								  dedudctionAmmount=dedudctionAmmount+salary.getValue();  
							  else {
								  ammount2=0;
								  ammount2=ammount2+salary.getValue();
							  		} 
							  if(ammount2>0) {
								  double per= basicPayment*ammount2;
								  dedudctionAmmount = dedudctionAmmount+(per/100);
							  }
							  
						  }
    	  		}
    	  }
      }
      }
      System.out.println("total Allowance:"+allAmount);
      System.out.println("total Deduction:"+dedudctionAmmount);

      
      String fromDate = employee.getFromDate();
      String toDate = employee.getToDate();
      model.addAttribute("fromDate", fromDate);
      model.addAttribute("toDate", toDate);
      
      Date createDate = em.getCreateDate();
      @SuppressWarnings("deprecation")
      int currentYear = createDate.getYear()+1900;
      @SuppressWarnings("deprecation")
      int currentMonth = createDate.getMonth()+1;
      
      YearMonth yearMonthObject = YearMonth.of(currentYear, currentMonth);
      int daysInMonth = yearMonthObject.lengthOfMonth();
      
      int sunday=0;
      Calendar cal = new GregorianCalendar(currentYear, currentMonth, 1);
      do {
          int day = cal.get(Calendar.DAY_OF_WEEK);
          if (day == Calendar.SUNDAY) {
              System.out.println(cal.get(Calendar.DAY_OF_MONTH));
              System.out.println("sunday");
              sunday++;
          }
          cal.add(Calendar.DAY_OF_YEAR, 1);
      }  while (cal.get(Calendar.MONTH) == currentMonth);
      
      double presentDaySize = (((presentDay.size())+(halfday.size()/2))+sunday)+2;
      double perDay=(allAmount-dedudctionAmmount)/daysInMonth;
      Double LeaveDeduction =perDay*Leave.size();
      int grossSalary= (int) (presentDaySize*perDay);

      model.addAttribute("GrossSalary", grossSalary);
    
      
      List<SalaryDetails> salarDetails = em.getSalaryDetails();
	  List<SalaryHead> salaryHeads = this.salaryHeadDao.listActiveSalaryHead();
	  for (SalaryHead salaryHead : salaryHeads) {
		  	if(salarDetails.stream().filter(x->x.getSalaryHeadId()==salaryHead.getId()).toArray().length==0) {
		  		SalaryDetails salary = new SalaryDetails();
		  		salary.setSalaryHeadId(salaryHead.getId());
		  		salary.setSalaryHead(salaryHead);
		  		salarDetails.add(salary);
		  	}
	  }
	 em.setSalaryDetails(salarDetails);
	  model.addAttribute("salaryDetail",em);
		return "details";
	  
  }
}
  
