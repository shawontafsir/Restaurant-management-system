<%-- 
    Document   : makeOrder
    Created on : Dec 15, 2016, 8:47:57 AM
    Author     : shawontafsir
--%>

<%@page import="sukarna.models.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sukarna.db.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
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
        <%
            String mail = (String) session.getAttribute("email");
            if(mail == null){
                RequestDispatcher rd = request.getRequestDispatcher("logIn.jsp");
                rd.forward(request, response);
            }
        %>
        <h1 style="font-family: cursive" align="center">Special Restaurant</h1>
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="userHomePage.jsp">Profile</a></li>
            <li><a href="showFoodList.jsp">Food List</a></li>
            <li><a class="active" href="makeOrder.jsp">Make Order</a></li>
            <li><a href="">About Us</a></li>
            <li><a href="logIn.jsp">Log out</a></li>
        </ul>
        <fieldset style="clear: right">
            <legend><h2>Give your order</h2></legend>
            <form method="post" action="OrderProcess.do">
                ***complete all fields<br/><br/>
                Food Id : <input type="number" name="foodId" min="1" /><br/><br/>
                Number of Order : <input type="number" name="noOfOrder" min="1" /><br/><br/>
                <input type="submit" value="add"><br/>
            </form>
        </fieldset>
        <br/><br/>
        <fieldset style="background-color: burlywood">
        <h2>Your Orders : </h2>
        <%
            String email= (String) session.getAttribute("email");
            DataAccess dao = new DataAccess();
            ArrayList<Order> orderInfo = dao.getOrderInfo(email);
            if(orderInfo==null)
            {
                out.println("Your order List is null.");
            }
            else if(orderInfo.size()==0)
            {
                out.println("You have not any pending order.");
            }
            else 
            {
                out.println("<table>");
                out.println("<tr><th>Food Id</th>   <th>Name</th>   <th>Category</th>   <th>Price</th>   <th>Number of Order</th> <th>Cost</th></tr>");
                int count=0;
                for(Order order: orderInfo)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d</td>   <td>%s</td>   <td>%s</td>    <td>%d</td>    <td>%d</td> <td>%d</td>", order.foodId, order.name, order.category,order.price,order.orderno,order.cost));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        %>
        </fieldset>
        <br/><br/>
        <fieldset style="background-color: burlywood">
            <jsp:include page="showFoodList.jsp" /> 
        </fieldset>
    </body>
</html>
