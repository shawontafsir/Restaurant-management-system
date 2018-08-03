<%-- 
    Document   : userHomePage
    Created on : Dec 14, 2016, 2:20:34 PM
    Author     : shawontafsir
--%>

<%@page import="sukarna.models.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sukarna.db.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home Page</title>
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
                background-color: green;
            }
            
            p{
                font-size: 18px;
                font-weight: normal;
            }
            
            body  {
                background-color: #cccccc;
            }
            
        </style>
    </head>
    <body>
        <%--<h2 style="float: right"><a href="logIn.jsp">Log Out</a></h2>--%>
        <h1 style="font-family: cursive" align="center">Special Restaurant</h1>
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a class="active" href="userHomePage.jsp">Profile</a></li>
            <li><a href="showFoodList.jsp">Food List</a></li>
            <li><a href="makeOrder.jsp">Make Order</a></li>
            <li><a href="">About Us</a></li>
            <li><a href="logIn.jsp">Log out</a>
        </ul>
        <h2 style="clear:both">User Profile</h2>
        <% 
            String email = (String) session.getAttribute("email");
            if(email == null){
                RequestDispatcher rd = request.getRequestDispatcher("logIn.jsp");
                rd.forward(request, response);
            }
            DataAccess dao = new DataAccess();
            ArrayList<User> userInfo = dao.getUserInfo(email);
            if(userInfo==null)
            {
                out.println("User List is null");
            }
            else if(userInfo != null)
            {
                for(User user : userInfo){
                    out.println(String.format("<p><mark>User Name</mark> : %s<br/>",user.username));
                    out.println(String.format("<mark>E-mail</mark> : %s<br/>",user.email));
                    out.println(String.format("<mark>Mobile NO.</mark> : %s<br/>",user.mobileNo));
                    out.println(String.format("<mark>Address</mark> : %s<br/></p>",user.address));
                }
            }
            else
            {
                out.println("User has no records.");
            }
        %>
        
        <%--<br/><br/>
        <h2><a href="showFoodList.jsp">Food List</a></h2>
        <h2><a href="makeOrder.jsp">Give Order</a></h2>
        --%>
    </body>
</html>
