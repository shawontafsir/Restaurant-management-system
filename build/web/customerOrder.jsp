<%-- 
    Document   : customerOrder
    Created on : Dec 17, 2016, 9:27:44 AM
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
        <title>JSP Page</title>
        <style>
            body  {
                background-color: #cccccc;
            }
        </style>
    </head>
    <body>
        <h2><a href="customerUI.jsp">Home</a></h2>
        <fieldset>
            <legend><h2>Give your order</h2></legend>
            <form method="post" action="CustomerOrderProcess.do">
                ***complete all fields<br/><br/>
                Food Id : <input type="number" name="foodId" min="1" /><br/><br/>
                Number of Order : <input type="number" name="noOfOrder" min="1" /><br/><br/>
                <input type="submit" value="add"><br/>
            </form>
        </fieldset>
        
        <h2>Your Orders : </h2>
        <%
            int customerId = (Integer) session.getAttribute("customerId");
            DataAccess dao = new DataAccess();
            ArrayList<Order> orderInfo = dao.getOrderInfo(customerId);
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
                out.println("<hr><td>Food Id</td>   <td>Name</td>   <td>Category</td>   <td>Price</td>   <td>Number of Order</td> <td>Cost</td></tr>");
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
        
        <jsp:include page="showFoodList.jsp" /> 
    </body>
</html>
