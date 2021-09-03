<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org" th:fragment="layout(content)">
<head>

<title>All Employee</title>
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
<body>
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
        <a class="nav-link dropdown-toggle" href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
     </div>
</nav>
			<h2> List Of Employee</h2>
		<form:form method="POST" action="saveEmployee" modelAttribute="userList" >
		<input type="hidden" value="${list.id}">
		<input type="hidden" value="${list.designation_id}">
		<input type="hidden" value="${list.department_id}">
		<input type="hidden" value="${list.employee_id}">
		
			<table class="table table-striped table-dark">
	 					 <tr>
	 					
	    					  	<th scope="col">ID</th>
	    					  	<th scope="col">Designation</th>
	    					  	<th scope="col">Department</th>
	   						    <th scope="col">First Name</th>
	   						    <th scope="col">Middle Name</th>
	    						<th scope="col">Last Name</th>
	      						<th scope="col">Email</th>
	      						<th scope="col">Married Status</th>
	      						<th scope="col">Gender</th>
	      						<th scope="col">Mobile No.</th>
	      						<th scope="col">Whatsapp No.</th>
	      						<th scope="col">Alter No.</th>
	   						    <th scope="col">Father Name</th>
	   						    <th scope="col">Mother Name</th>
	    						<th scope="col">Spouse Name</th>
	      						<th scope="col">Permanent Address</th>
	      						<th scope="col">Present Address</th>     					
	   						    <th scope="col">Bank Name</th>
	   						    <th scope="col">Account Number</th>
	      						<th scope="col">IFSC</th>
	   						    <th scope="col">Pan Card</th>
	   						    <th scope="col">Aadhar No.</th>
	    						<th scope="col">PassPort no.</th>
	      						<th scope="col">Highest Qualification</th>
	      						<th scope="col">DOB</th>
	      						<th scope="col">Remark</th>
	      						<th scope="col">Action</th>
	   					   </tr>
					<tbody>
					<c:forEach var="list" items="${userList}"> 
							<tr>
								<td>${list.id}</td>	
								<td>${list.designation.designation}</td>
								<td>${list.department.department}</td>
								<td>${list.firstName}</td>
								<td>${list.middleName}</td>
								<td>${list.lastName}</td>
								<td>${list.email}</td>
								<td>${list.maritalStatus}</td>
								<td>${list.gender}</td>
								<td>${list.mobile}</td>
								<td>${list.whatsappNumber}</td>
								<td>${list.alterNumber}</td>
								<td>${list.fatherName}</td>
								<td>${list.motherName}</td>
								<td>${list.spouseName}</td>
								<td>${list.addressPermanent}</td>
								<td>${list.addressPresent}</td>
								<td>${list.bankName}</td>
								<td>${list.accountNumber}</td>
								<td>${list.ifscCode}</td>
								<td>${list.panNo}</td>			
								<td>${list.aadharNumber}</td>				
								<td>${list.passportNumber}</td>
								<td>${list.highestQualification}</td>
								<td>${list.dob}</td>
								<td>${list.remark}</td>
								<td><a href="update/${list.id}">Update</a>  <a href="delete/${list.id}" onClick="if(!(confirm('Are you sure?')))  return false">Delete</a></td>  
							<tr>
					</c:forEach>	
				</tbody>			
			</table>
		<a onclick="window.location.href='addEmployee'" type="button" class="btn btn-primary btn-lg btn-block">Add Employee</a>
		</form:form>
	</body>
</html>







