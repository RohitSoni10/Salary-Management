<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org" th:fragment="layout(content)">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <script type="text/javascript">
  window.addEventListener('DOMContentLoaded', function(eventX){
	    console.log("DOMContentLoaded done!");
	      setTimeout(function(){
	           console.log("beforeunload registered");
	        window.onbeforeunload = function(){return backDisable()};
	        window.addEventListener("beforeunload", function(){return backDisable();});

	      },1000);

	    });
	function backDisable()
	{
	  return "show some warning here!";
	} 
    </script>
  <title>Employee Detials</title>
  <%@ include file="./base.jsp" %>
  <style type="text/css">
		.empTable  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.empTable td{font-family:Arial, sans-serif;font-size:16px;padding:10px 5px;border-
                              style:solid;border-width:2px;overflow:hidden;word-break:normal;border- 
                              color:#ccc;color:#00FF00;background-color:#FF0000;}
		.empTable th{font-family:Arial, sans-serif;font-size:16px;font-weight:normal;padding:10px 
                              5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;border-
                              color:#ccc;color:#000000;background-color:#FF4500;}
		.empTable .empTable-4eph{background-color:#C0C0C0}
	</style>
 </head>
 <body style="background: #e2e2e2e2;">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
 		 <a class="navbar-brand" href="">Employee</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
				      <li class="nav-item active">
				        <a class="nav-link" href="/Employees">Home <span class="sr-only">(current)</span></a>
				      </li>
				       <li class="nav-item dropdown">
				        <a class="nav-link dropdown-toggle" id="navbarDropdown"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				          Employee
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				          <a class="dropdown-item" href="/Employees/addEmployee">New Employee</a>
				           <div class="dropdown-divider"></div>
				          <a class="dropdown-item" href="/Employees/empList">List</a>
				        </div>
				        </li>
					<li class="nav-item dropdown">
				        <a class="nav-link dropdown-toggle" href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				          Salary
				        </a>
			        	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				          	<a class="dropdown-item" href="/Employees/addSalaryHead">Salary Head</a>
				           <div class="dropdown-divider"></div>
				          	<a class="dropdown-item" href="/Employees/SalaryHeadList">List</a>
			        	</div>
			    	</li>
			    
			       <li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Designation
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
			          <a class="dropdown-item" href="/Employees/addDesignation">New Designation</a>
			           <div class="dropdown-divider"></div>
			          <a class="dropdown-item" href="/Employees/designationList">List</a>
			        </div>
			      </li>
			      
			      <li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Department
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
			          <a class="dropdown-item" href="/Employees/addDepartment">New Department</a>
			           <div class="dropdown-divider"></div>
			          <a class="dropdown-item" href="/Employees/departmentList">List</a>
			        </div>
			      </li>
			      </ul>
    		 </div>
	</nav>
<div class="container">
<div class="row">
<div class="col-8 offset-2">
<div class="card mt-3">
<div class="card-body">
<div class="container text-center">
</div>
  	  <h2 >Employee Detail</h2>

					  <form:form method="POST" action="/Employees/saveEmployee" modelAttribute="userForm"  >
							  <form:hidden path="id"/> 
							    <div class="form-control">
							           <label style=font-weight:bold>First Name:</label>
							           		<form:input class="form-control" path="firstName"  placeholder="Enter First Name " required="required"/>
							           		 
							           <label style=font-weight:bold>Middle Name:</label>
							           		<form:input class="form-control" path="middleName" placeholder="Enter Middle Name(optional)"/>  
							           		
							           <label style=font-weight:bold>Last Name:</label>
							           		<form:input class="form-control" path="lastName" placeholder="Enter Last Name" required="required" />
							           		
							           <label style=font-weight:bold>email:</label>
							           		<form:input type="email" class="form-control" path="email" placeholder="Enter Email" required="required"/> 
							    
							   					 <div class="form-group">
							       		 				  <label style=font-weight:bold>Designation:</label>
							       							<form:select class="custom-select" path="designationid" required="required">
							       		  						<form:option value="">--Select--</form:option>
							               					<c:forEach items="${desList}" var="user">
							      								<form:option value="${user.id}">${user.designation}</form:option>
							     							</c:forEach>
							     							</form:select> 
							     				  </div>
							     				  
							     				   <div class="form-group">
							       		 				  <label style=font-weight:bold>Department:</label>
							       							<form:select class="custom-select" path="departmentId" required="required">
							       		  						<form:option value="">--Select--</form:option>
							               					<c:forEach items="${depList}" var="user1">
							      								<form:option value="${user1.id}">${user1.department}</form:option>
							     							</c:forEach>
							     							</form:select> 
							     					</div>
							     							
							     			<label style=font-weight:bold>Allocation:</label>
							  				<table class="table">
								  				<tbody>
									  				<c:forEach items="${userForm.salaryDetails}" var="salary">
										  				<c:if test="${salary.salaryHead.salaryType eq 'Allowance' }">
											  				<tr>			
												      			<td>
													      			<input type="hidden" value="${salary.salaryHeadId}" class="form-control" name="salaryHeadId"  />
													      			 	${salary.salaryHead.title}
													      			 <input type="hidden" name="salaryDetailid" value="${salary.id}"/>
												      			</td>
												      			<td>
													      			<c:if test="${salary.salaryHead.valueType eq 'Percent'}">
													      				<input type="text" value="${salary.value}" class="form-control" name="value" placeholder="%" required="required" />
													      			</c:if>
												      			
													      			<c:if test="${salary.salaryHead.valueType eq 'Amount'}">
													      				<input type="text" value="${salary.value}" class="form-control" name="value" placeholder="Amount" required="required"/>
													      			</c:if>
												      			</td>							 
											  				 </tr>
										  				</c:if>
										 			</c:forEach>  
								  				</tbody>
								  			</table>
								  				
							  				<label style=font-weight:bold>Deduction:</label>
									        	<table class="table">	 
									  				<tbody>
										  				<c:forEach items="${userForm.salaryDetails}" var="salary">
											  				<c:if test="${salary.salaryHead.salaryType eq 'Deduction'}">
												  				<tr>			
													      			<td>
														      			<input type="hidden" value="${salary.salaryHeadId}" class="form-control" name="salaryHeadId"  />
														      			 	${salary.salaryHead.title}
														      			<input type="hidden" name="salaryDetailid" value="${salary.id}"/>
													      			</td>
													      			<td>
														      			<c:if test="${salary.salaryHead.valueType eq 'Percent'}">
														      				<input type="text" value="${salary.value}" class="form-control" name="value" placeholder="%" required="required" />	
														      			</c:if>
													      			
														      			<c:if test="${salary.salaryHead.valueType eq 'Amount'}">
														      				<input type="text" value="${salary.value}" class="form-control" name="value" placeholder="Amount" required="required"/>
														      			</c:if>
												      				</td>							 
															 	</tr>
											  				</c:if>
											 			</c:forEach>
									  				</tbody>
									  			</table>
							             <label style=font-weight:bold>Marital Status:</label>
								            <div class="form-control" >
								      	    	<div class="form-check form-check-inline">
									 				<form:radiobutton path="maritalStatus" class="form-check-input" value="S" required="required"></form:radiobutton>
										  				<label class="form-check-label" >Single</label>
												</div>
												
												<div class="form-check form-check-inline">
										 			<form:radiobutton path="maritalStatus" class="form-check-input" value="M" required="required" ></form:radiobutton>
									  					<label class="form-check-label" >Married</label>
												</div>
											</div>
											 
										<label style=font-weight:bold>Gender: </label>	
											<div class="form-control" >	
								      	       	<div class="form-check form-check-inline">
									 				<form:radiobutton path="gender" class="form-check-input" value="M" required="required"></form:radiobutton>
									  					<label class="form-check-label" >Male</label>
												</div>
												
												<div class="form-check form-check-inline">
									 				<form:radiobutton path="gender" class="form-check-input"  value="F" required="required"></form:radiobutton>
									  					<label class="form-check-label" >Female</label>
												</div>
											</div>
											
										 <label style=font-weight:bold>Contact:</label>
										    <div class="form-control" >
										      	<label style=font-weight:bold>Mobile No.</label>
										           <div>
										           		<form:input type="number" class="form-control" path="mobile" placeholder="Enter Mobile No." required="required"/> 
										           </div>   
										            
										         <label style=font-weight:bold>Whatsapp No.</label>
										           <div>
										           		<form:input type="number" class="form-control" path="whatsappNumber" placeholder="Enter Whatsapp No." required="required"/>
										           </div>   
										           
										         <label style=font-weight:bold>Alter No.</label>
										 			<div>
										           		<form:input type="number" class="form-control"  path="alterNumber" placeholder="Enter Alter No." />
													</div>	
										    </div>
										    
									       <label style=font-weight:bold>Relative:</label>
										       <div class="form-control" >
											        <div class="form-group" >	 
											           <label style=font-weight:bold>Father Name:</label>
											           		<form:input class="form-control" path="fatherName" placeholder="Enter Father Name" required="required"/>
											           
											           <label style=font-weight:bold>Mother Name:</label>
											           		<form:input class="form-control" path="motherName" placeholder="Enter Mother Name" required="required"/>
											           
											           <label style=font-weight:bold>Spouse Name:</label>
											           		<form:input class="form-control" path="spouseName" placeholder="Enter Spouse Name" />   
											      	</div>
										       </div>
									       
									        <label style=font-weight:bold>Relative:</label>
									    	  <div class="form-control" >
										       		<div class="form-group" >
										               <label style=font-weight:bold>Address Permanent</label>
											           		<form:input  class="form-control"  path="addressPermanent" placeholder="Enter Permanent Address" required="required"/>
											           		
											           <label style=font-weight:bold>Present Address:</label>
											           		<form:input  class="form-control"  path="addressPresent" placeholder="Enter Present Address" required="required"/>
										   		   </div>
									   		  </div>
							   		  
									   		 <label style=font-weight:bold>Bank Detail:</label>
										    	  <div class="form-control" >
										       		<div class="form-group" >
											           <label style=font-weight:bold>Account Number</label>
											           		<form:input type="number" class="form-control"  path="accountNumber" placeholder="Enter Account Number" required="required"/>
											           		
											            <label style=font-weight:bold>IFSC</label>
											           		<form:input type="text" class="form-control"  path="ifscCode" placeholder="Enter IFSC Code" required="required"/>
											           		
											           <label style=font-weight:bold>Bank Name</label>
											           		<form:input type="text" class="form-control"  path="bankName" placeholder="Enter Bank Name" required="required"/>
										   		   </div>
										   		  </div>
							   		  
								   		   <label style=font-weight:bold>Document:</label>
									    	  <div class="form-control" >
										       		<div class="form-group" >
											           <label style=font-weight:bold>Pan Card</label>
											           		<form:input  class="form-control"  path="panNo" placeholder="Enter Pan No." required="required"/>
											           <label style=font-weight:bold>Aadhar Number</label>
											           		<form:input type="number" class="form-control"  path="aadharNumber" placeholder="Enter Aadhar no." required="required"/>
											           <label style=font-weight:bold>Passport Number</label>
											           		<form:input  class="form-control"  path="passportNumber" placeholder="Enter Passport No." />
											            <label style=font-weight:bold>Highest Qualification</label>
											           		<form:input  class="form-control"  path="highestQualification" placeholder="Enter Highest Qualification" required="required"/>
										   		   </div>
									   		  </div>
										
								   		   <label style=font-weight:bold>Other:</label>
									    	  <div class="form-control" >
										       		<div class="form-group" >
											           <label style=font-weight:bold>Date Of Birth</label>
											           		<form:input type="date"  class="form-control"  path="dob" placeholder="Enter DOB" required="required"/>
											  
											           <label style=font-weight:bold>Remark</label>
											           		<form:textarea type="text"  class="form-control"  path="remark" placeholder="Enter remark" />
											        </div>
											   </div>
									</div>
								<input  class="btn btn-secondary btn-lg btn-block" type="submit" value="Submit"/>  
					  		</form:form>
				  		</div>
  					</div>
  				</div>
  			</div>
		</div>
	</body>
</html>