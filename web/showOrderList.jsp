<%-- 
    Document   : showOrderList
    Created on : Dec 17, 2016, 12:33:31 AM
    Author     : shawontafsir
--%>

<%@page import="sukarna.models.OrderList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sukarna.db.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order List</title>
        <style>
            body  {
                background-color: #cccccc;
            }
            table{
                width:80%;
                text-align:center;
                margin-left:200px;
                margin-top:50px;
                box-shadow: 10px 10px green;
                font-size:20px;
                font-style: italic;
            }
            table,td,th{
                border:1px solid black;
                border-size:1px;
                border-style:solid;
                border-color:black;
                padding:  5px 5px 5px 5px;
            }   
            th{
                background-color: cadetblue;
            }
        </style>
    </head>
    <body> 
        <h1>ORDER LIST</h1>
        
        <% 
            DataAccess dao = new DataAccess();
            ArrayList<OrderList> orderInfo = dao.getOrderList();
            if(orderInfo==null)
            {
                out.println("Order List is null");
            }
            else if(orderInfo.size()==0)
            {
                out.println("Order List has no records.");
            }
            else 
            {
                out.println("<table>");
                out.println("<tr><th>Order Id</th> <th>Food Id</th> <th>User Id</th> <th>Customer Id</th> <th>Order Time</th> <th>Employee Id</th></tr>");
                int count=0;
                for(OrderList orderList: orderInfo)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d</td> <td>%d</td> <td>%d</td> <td>%d</td> <td>%s</td> <td>%d</td>",orderList.orderId,orderList.foodId,orderList.userId,orderList.customerId,orderList.orderTime,orderList.employeeId));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        %>
        
    </body>
</html>
