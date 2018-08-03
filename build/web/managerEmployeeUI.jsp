<%-- 
    Document   : managerEmployeeUI
    Created on : Dec 15, 2016, 11:47:43 PM
    Author     : shawontafsir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager-Employee UI</title>
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
            <li><a class="active" href="managerEmployeeUI.jsp">Home</a></li>
            <li><a href="showFoodList.jsp">Food List</a></li>
            <li><a href="employeeUI.jsp">Employee UI</a></li>
            <li><a href="showEmployeeList.jsp">Employee List</a></li>
            <li><a href="">About Us</a></li>
        </ul>
        <div style="margin-top : 100px" align="center">
        <fieldset style="width:400px" align="center">
            <legend><h4>Manager Log In</h4></legend>
            <h4>To go manager Home page, please log in first</h4>
            <form method="post" action="ManagerLogInProcess.do">
                Enter your E-mail: <input type="email" name="email" /> <br/><br/>
                Enter your password: <input type="password" name="password" /> <br/><br/>
                <input type="submit" value="Login" /> <br/>
            </form>
        </fieldset>
        </div>
        <%
            session.setAttribute("employeeId", "-1");
            session.setAttribute("email", null);
        %>
     
    </body>
</html>
