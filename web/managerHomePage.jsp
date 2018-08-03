<%-- 
    Document   : managerHomePage
    Created on : Dec 16, 2016, 12:03:33 AM
    Author     : shawontafsir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Home Page</title>
        <style>
            body  {
                background-color: #cccccc;
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
        <%
            String email = (String) session.getAttribute("email");
            if(email == null){
                RequestDispatcher rd = request.getRequestDispatcher("managerEmployeeUI.jsp");
                rd.forward(request, response);
            }
        %>
        
        <h1 style="font-family: cursive" align="center">Special Restaurant</h1>
        <ul>
            <li><a href="managerEmployeeUI.jsp">Home</a></li>
            <li><a class="active" href="managerHomePage.jsp">Manager Home</a></li>
            <li><a href="addEmployee.jsp">Manage</a></li>
            <li><a href="showFoodList.jsp">Food List</a></li>
            <li><a href="showOrderList.jsp">Order List</a></li>
            <li><a href="showEmployeeList.jsp">Employee List</a></li>
            <li><a href="">About Us</a></li>
            <li><a href="managerEmployeeUI.jsp">Log out</a></li>
        </ul>
        
        <h1>You can perform following things : </h1>
        <div style="margin-top: 50px;clear: right">
            <fieldset style="float: left;width: 415px">
            <legend><h2>Manage Employee</h2></legend>
            <h3>Add Employee</h3>
            <h3>Update Employee</h3>
            <h3>Delete Employee</h3>
            <h3>Employee List</h3>
        </fieldset>
        <fieldset style="float: left;width: 410px">
            <legend><h2>Manage Food</h2></legend>
            <h3>Food List</h3>
            <h3>Add Food</h3>
            <h3>Update Food</h3>
            <h3>Delete Food</h3>
        </fieldset>
        <fieldset style="float: left;width: 410px">
            <legend><h2>Manage Order</h2></legend>
            <h3>Order List</h3>
            <h3>Assign Order</h3>
            <h3>Delete Order</h3>
            <h3>Completed Order</h3>
        </fieldset>
        </div>
    </body>
</html>