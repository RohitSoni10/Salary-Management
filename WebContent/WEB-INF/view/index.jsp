<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  <title>Employee Detail</title>

  <!--  self csss  and js -->
  <link rel="stylesheet" href="assests/style1.css">


  <!--  script -->
  <!--  self csss  and js -->

</head>

<body>

  <div class="container-fluide"style="margin-left:10px; margin-top:5px;">
    <div class="row">
      <!-- BEGIN INBOX -->
      <div class="col-md-12">
        <div class="grid email">
          <div class="grid-body">
            <div class="row">
              <!-- BEGIN INBOX MENU -->
              <div class="col-md-3" style="
              padding: 5px;
              box-shadow: 5px 5px #ebebeb;">
                <h2 class="grid-title"><i class="fa fa-id-badge" style="font-size:36px"></i> &nbsp; Employee</h2>
                <hr>
                <div>
                  <ul class="nav nav-pills nav-stacked">
                    <li style=" font-size:20px;">
                      <form action="/saveEmployee">
                      <span class="badge"></span><i class="fa fa-male"></i> &nbsp; &nbsp; <a href="addEmployee" style="text-decoration:none;">New Employee</a>
                      </form>
                    </li>

                  </ul>
                  <br>

                  <ul class="nav nav-pills nav-stacked">
                    
                    <li style=" font-size:20px;">
                      <form action="/saveEmployee">
                        <span class="badge"></span><i class="fa fa-user-plus"></i> &nbsp; <a href="empList"style="text-decoration:none;">Employee List</a>
                      </form>
                    </li>

                  </ul>
                  <br>

                  <ul class="nav nav-pills nav-stacked">

                    <li style=" font-size:20px;">
                      <form action="/addSalaryHead">
                        <span class="badge"></span> <i class="fa fa-money" aria-hidden="true"></i> &nbsp;<a href="addSalaryHead"style="text-decoration:none;">Salary</a>
                        </form>
                    </li>


                  </ul>
                   <br>

                  <ul class="nav nav-pills nav-stacked">

                    <li style=" font-size:20px;">

                      <form action="/salaryHeadList">
                        <span class="badge"></span><i class="fa fa-money" aria-hidden="true"></i> &nbsp;  <a href="SalaryHeadList"style="text-decoration:none;">Salary Head List</a>
                        </form>
                    </li>

                  </ul>
                  <br>

                  <ul class="nav nav-pills nav-stacked">

                    <li style=" font-size:20px;">

                      <form action="/addSalary">
                        <span class="badge"></span><i class="fa fa-money" aria-hidden="true"></i> &nbsp;  <a href="addSalary"style="text-decoration:none;">Salary calculate</a>
                        </form>
                    </li>

                  </ul>
                  <br>
					
                  <ul class="nav nav-pills nav-stacked">

                    <li style=" font-size:20px;">
                      <form action="/addDes">
                        <span class="badge"></span><i class="fa fa-black-tie" aria-hidden="true"></i> &nbsp;<a href="addDesignation"style="text-decoration:none;">New Designation</a>
                        </form>
                    
                    </li>

                  </ul>
                  <br>
                  <ul class="nav nav-pills nav-stacked">

                    <li style=" font-size:20px;">
                      <form action="/saveDes">
                        <span class="badge"></span> <i class="fa fa-newspaper-o" aria-hidden="true"></i> &nbsp;<a href="designationList"style="text-decoration:none;">Designation List</a>
                        </form>
                    </li>

                  </ul>
                  <br>
                  <ul class="nav nav-pills nav-stacked">

                    <li style=" font-size:20px;">
                       <form action="/addDep">
                      <span class="badge"></span><i class="fa fa-street-view" aria-hidden="true"></i> &nbsp;<a href="addDepartment"style="text-decoration:none;">New Department</a>
                      </form></li>

                  </ul>
                  <br>

                  <ul class="nav nav-pills nav-stacked">

                    <li style=" font-size:20px;">
                      <form action="/addDepartment">
                        <span class="badge"></span> <i class="fa fa-group"></i> &nbsp;<a href="departmentList"style="text-decoration:none;">Department List</a>
                        </form>
                    </li>

                  </ul>
                  <br>        
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- END INBOX -->
    </div>
  </div>




  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous">
  </script>
</body>

</html>