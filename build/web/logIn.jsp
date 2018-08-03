<%-- 
    Document   : logIn
    Created on : Dec 5, 2016, 11:46:43 PM
    Author     : shawontafsir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign In</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
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
                background-color : green;
            }
            
            body  {
                background-color: #cccccc;
            }
        </style>
    </head>
    <body>
        <%
                session.setAttribute("email", null);
        %>
        <h1 style="font-family: cursive" align="center">Special Restaurant</h1>
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="showFoodList.jsp">Food List</a></li>
            <li><a href="makeOrder.jsp">Make Order</a></li>
            <li><a class="active" href="logIn.jsp">Log in</a></li>
            <li><a href="createAccount.jsp">Sign Up</a></li>
            <li><a href="">About Us</a></li>
        </ul>

        
        <div style="margin-top: 100px" align="center">
        <h1 align="center">User Log In</h1>
        <fieldset style="width:400px">
            <legend><h3>Log In</h3></legend>
            <form method="post" action="LogInProcess.do"> 
                Enter your E-mail: <input type="email" name="email" /> <br/><br/>
                Enter your password: <input type="password" name="password" /> <br/><br/>
                <input type="submit" value="Login" />
            </form>
        </fieldset>
        
        <p><a href="createAccount.jsp">I don't have any account</a></p>
        </div>
    </body>
</html>
