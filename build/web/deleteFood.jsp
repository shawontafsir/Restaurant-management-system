<%-- 
    Document   : deleteFood
    Created on : Dec 16, 2016, 11:20:24 AM
    Author     : shawontafsir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Food</title>
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
            <li><a class="active" href="addFood.jsp">Manage Food</a></li>
            <li><a href="assignOrder.jsp">Manage Order</a></li>
        </ul>
        <ul>
            <li><a href="addFood.jsp">Add Food</a></li>
            <li><a href="updateFood.jsp">Update Food</a></li>
            <li><a class="active" href="deleteFood.jsp">Delete Food</a></li>
        </ul>
        
        <h3>Delete Food Item:</h3>
        <form method="post" action="DeleteFood.do">
            <h4>Enter food Id you want to delete : <input type="number" name="foodId" min="1" /></h4>
            <input type="submit" value="Delete" />
        </form>
        
        <jsp:include page="showFoodList.jsp" />
        
    </body>
</html>
