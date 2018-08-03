<%-- 
    Document   : addEmployee
    Created on : Dec 16, 2016, 8:13:15 PM
    Author     : shawontafsir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
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
        <%--<h2><a href="managerHomePage.jsp">Home</a></h2>--%>
        <%
            String mail = (String) session.getAttribute("email");
            if(mail == null){
                RequestDispatcher rd = request.getRequestDispatcher("logIn.jsp");
                rd.forward(request, response);
            }
        %>
        
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
            <li><a class="active" href="addEmployee.jsp">Add Employee</a></li>
            <li><a href="updateEmployee.jsp">Update Employee</a></li>
            <li><a href="deleteEmployee.jsp">Delete Employee</a></li>
            <li><a href="previousEmployees.jsp">Previous Employees</a></li>
        </ul>
        
        <h1>Add Employee in the Restaurant </h1>
        <fieldset style="width: 300px">
            <legend><h3>Add Employee</h3></legend>
            <form method="post" action="AddEmployee.do">
                Employee Name : <input type="text" name="employeeName" /> <br/><br/>
                E-mail : <input type="email" name="email" /> <br/><br/>
                Mobile No. : <input type="text" name="mobileNo" /><br/><br/>
                Address : <input type="text" name="address" /><br/><br/>
                Salary : <input type="number" name="salary" min="0" /><br/><br/>
                Manager Id : <input type="number" name="managerId" min="1" /><br/><br/>
                <input type="submit" value="ADD" />
            </form>
        </fieldset>
        
        <jsp:include page="showEmployeeList.jsp" />
    </body>
</html>
