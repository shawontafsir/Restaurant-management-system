<%-- 
    Document   : assignOrder
    Created on : Dec 17, 2016, 2:14:25 AM
    Author     : shawontafsir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assign Order</title>
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
            <li><a href="addEmployee.jsp">Manage Employee</a></li>
            <li><a href="addFood.jsp">Manage Food</a></li>
            <li><a class="active" href="assignOrder.jsp">Manage Order</a></li>
        </ul>
        <ul>
            <li><a class="active" href="assignOrder.jsp">Assign Order</a></li>
            <li><a href="deleteOrder.jsp">Delete Order</a></li>
            <li><a href="showOrderHistory.jsp">Completed Order</a></li>
        </ul>
        
        <fieldset>
            <legend><h4>Assign Order</h4></legend>
            <form method="post" action="AssignOrder.do">
                <h3>Assign Order Id : <input type="number" name="orderId" min="0" /> <br/>
                to <br/>
                Employee Id : <input type="number" name="employeeId" min="1" /> <br/></h3>
                <input type="submit" value="Assign" />
            </form>
        </fieldset>
        
        <jsp:include page="showOrderList.jsp" />
        <jsp:include page="showEmployeeList.jsp" />
    </body>
</html>
