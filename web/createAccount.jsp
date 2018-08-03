<%-- 
    Document   : createUserAccount
    Created on : Dec 14, 2016, 10:27:45 AM
    Author     : shawontafsir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <style>
            body{
                background-color: #cccccc;
            }
            
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                border: 1px solid #e7e7e7;
                background-color : darkseagreen;
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
                background-color:green;
            }
        </style>
    </head>
    <body>
        <h1 style="font-family: cursive" align="center">Special Restaurant</h1>
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="showFoodList.jsp">Food List</a></li>
            <li><a href="makeOrder.jsp">Make Order</a></li>
            <li><a href="logIn.jsp">Log in</a></li>
            <li><a class="active" href="createAccount.jsp">Sign Up</a></li>
            <li><a href="">About Us</a></li>
        </ul>
        <div align="center">
        <h1>Create your account!</h1>
        <fieldset style="width:400px;margin-top:50px" align="center">
            <legend><h4>Create Account</h4></legend>
            <form method="post" action="CreateAccount.do">
                <table align="center">
                    <tr><td>User Name </td><td><input type="text" name="username" ></td> </tr>
                    <tr><td>E-mail</td><td> <input type="text" name="email" placeholder="@gmail.com" ></td></tr>
                <tr><td>Mobile No.</td><td> <input type="text" name="mobileno" /> </td> </tr>
                <tr><td>Password</td><td> <input type="password" name="password" /></td> </tr>
               <tr><td> Address</td><td> <input type="text" name="address"> </td> </tr>
               <tr><td colspan="2" align="center"><input type="submit" value="Create" /> </td> </tr>
                </table>
            </form>
        </fieldset>
        <p><a href="index.html">Back to Home Page</a></p>
        <p><a href="logIn.jsp">I have already an account</a></p>
        </div>
    </body>
</html>
