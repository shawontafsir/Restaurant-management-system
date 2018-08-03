<%-- 
    Document   : updateEmployee
    Created on : Dec 16, 2016, 10:57:51 PM
    Author     : shawontafsir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employee</title>
        <style>
            body{
                background-color: gainsboro;
            }
            
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                border: 1px solid #e7e7e7;
                background-color: darkseagreen;
            }
            
            li {
                float: left;
            }

            li a {
                display: block;
                color: #666;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover:not(.active) {
                background-color: #ddd;
            }

            li a.active {
                color: white;
                background-color: green;
            }
        </style>
    </head>
    <body>
        <h1 style="font-family: cursive" align="center">Special Restaurant</h1>
        <ul>
            <li><a href="managerEmployeeUI.jsp">Home</a></li>
            <li><a href="managerHomePage.jsp">Manager Home</a></li>
            <li><a class="active" href="addEmployee.jsp">Manage</a></li>
            <li><a href="showFoodList.jsp">Food List</a></li>
            <li><a href="showOrderList.jsp">Order List</a></li>
            <li><a href="showEmployeeList.jsp">Employee List</a></li>
            <li><a href="">About Us</a></li>
            <li><a href="managerEmployeeUI.jsp">Log out</a></li>
        </ul>
        <ul>
            <li><a class="active" href="addEmployee.jsp">Manage Employee</a></li>
            <li><a href="addFood.jsp">Manage Food</a></li>
            <li><a href="assignOrder.jsp">Manage Order</a></li>
        </ul>
        <ul>
            <li><a href="addEmployee.jsp">Add Employee</a></li>
            <li><a class="active" href="updateEmployee.jsp">Update Employee</a></li>
            <li><a href="deleteEmployee.jsp">Delete Employee</a></li>
            <li><a href="previousEmployees.jsp">Previous Employees</a></li>
        </ul>
        
        <h3>Update Employee :</h3>
        <form method="post" action="UpdateEmployee.do">
            <h4>Enter Employee Id you want to update : <input type="number" name="employeeId" min="2" /> </h4>
            <h4>Complete following fields to update : </h4>
            Employee Name : <input type="text" name="employeeName" /><br>
            E-mail : <input type="email" name="email" /> <br/>
            Salary : <input type="number" name="salary" min="0"/> <br/>
            Mobile No. : <input type="text" name="mobileNo" /><br>
            Address : <input type="text" name="address" /><br>
            Manager Id : <input type="number" name="managerId" min="1"/> <br/><br/>
            <input type="submit" value="Update" />
        </form>
        
        <jsp:include page="showEmployeeList.jsp" />
        
    </body>
</html>
