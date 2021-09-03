<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org" th:fragment="layout(content)">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Salary Detials</title>
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
  	  <h2 >Employee Salary Detail</h2>

					  <form:form method="POST" action="saveSalary" modelAttribute="salaryDetail"  >
							  
							    <div class="form-control">
							           				
							     			<label style=font-weight:bold>Allowance:</label>
							  				<table class="table">
								  				<tbody>
									  				<c:forEach items="${salaryDetail.salaryDetails}" var="salary">
										  				<c:if test="${salary.salaryHead.salaryType eq 'Allowance' }">
											  				<tr>			
												      			<td>
													      			<input type="hidden" value="${salary.salaryHeadId}" class="form-control" name="salaryHeadId"  />
													      			 	${salary.salaryHead.title}
													      			 <input type="hidden" name="salaryDetailid" value="${salary.id}"/>
												      			</td>
												      			<td>
													      			<c:if test="${salary.salaryHead.valueType eq 'Percent'}">
													      				<input readonly value="${salary.value}" class="form-control" name="value" placeholder="%" required="required" />
													      			</c:if>
												      			
													      			<c:if test="${salary.salaryHead.valueType eq 'Amount'}">
													      				<input readonly value="${salary.value}" class="form-control" name="value" placeholder="Amount" required="required"/>
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
										  				<c:forEach items="${salaryDetail.salaryDetails}" var="salary">
											  				<c:if test="${salary.salaryHead.salaryType eq 'Deduction'}">
												  				<tr>			
													      			<td>
														      			<input type="hidden" value="${salary.salaryHeadId}" class="form-control" name="salaryHeadId"  />
														      			 	${salary.salaryHead.title}
														      			<input type="hidden" name="salaryDetailid" value="${salary.id}"/>
													      			</td>
													      			<td>
														      			<c:if test="${salary.salaryHead.valueType eq 'Percent'}">
														      				<input readonly value="${salary.value}" class="form-control" name="value" placeholder="%" required="required" />	
														      			</c:if>
													      			
														      			<c:if test="${salary.salaryHead.valueType eq 'Amount'}">
														      				<input readonly value="${salary.value}" class="form-control" name="value" placeholder="Amount" required="required"/>
														      			</c:if>
												      				</td>							 
															 	</tr>
											  				</c:if>
											 			</c:forEach>
									  				</tbody>
									  			</table>
									  			<label style=font-weight:bold>Month From:</label>
							           		<input readonly class="form-control" value="${fromDate} " />
							           		<label style=font-weight:bold>Month To:</label>
							           		<input readonly class="form-control" value="${toDate} " />
									  		<label style=font-weight:bold>Gross Salary:</label>
							           		<input readonly class="form-control" value="${GrossSalary}"  />
							           		
							    </div> 		
						</form:form>
				  		</div>
  					</div>
  				</div>
  			</div>
		</div>
	</body>
</html>
