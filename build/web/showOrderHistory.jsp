<%-- 
    Document   : showOrderHistory
    Created on : Dec 19, 2016, 2:30:25 PM
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
        <title>Order History</title>\
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
            
            table{
            width:80%;
            text-align:center;
            margin-left:200px;
            margin-top:50px;
            box-shadow: 10px 10px gray;
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
            <li><a href="assignOrder.jsp">Assign Order</a></li>
            <li><a href="deleteOrder.jsp">Delete Order</a></li>
            <li><a class="active" href="showOrderHistory.jsp">Completed Order</a></li>
        </ul>
        
        
        <fieldset>
            <h3>Enter dates to see completed orders between two dates : </h3>
            <form method="post" action="TasksBetweenTimes.do">
                From : <input type="text" name="from" /><br/><br/>
                To : <input type="text" name="to"/><br/><br/>
                <input type="submit" value="search"/>
            </form>
        </fieldset>
        
        <%
            ArrayList<OrderList> completedOrder = new ArrayList<OrderList>();
            completedOrder = (ArrayList<OrderList>) session.getAttribute("orderHistoryInfo");
            out.println("<h1>Your Searched Result : </h1>");
            if(completedOrder==null)
            {
                out.println("You have not searched yet.");
            }
            else if(completedOrder.size()==0)
            {
                out.println("No order has been completed between your given times.");
            }
            else 
            {
                out.println("<table>");
                out.println("<hr><td>Order Id</td> <td>Food Id</td> <td>User Id</td> <td>Order Time</td> <td>Cost</td> <td>Employee Id</td></tr>");
                int count=0;
                for(OrderList orderList: completedOrder)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d</td> <td>%d</td> <td>%d</td> <td>%s</td> <td>%d</td> <td>%d</td>",orderList.orderId,orderList.foodId,orderList.userId,orderList.orderTime,orderList.customerId,orderList.employeeId));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        %>
        
        <h1>Completed Order</h1>
        <% 
            DataAccess dao = new DataAccess();
            ArrayList<OrderList> orderInfo = dao.getOrderHistoryList();
            if(orderInfo==null)
            {
                out.println("Order History List is null");
            }
            else if(orderInfo.size()==0)
            {
                out.println("No order has been completed.");
            }
            else 
            {
                out.println("<table>");
                out.println("<hr><td>Order Id</td> <td>Food Id</td> <td>User Id</td> <td>Order Time</td> <td>Cost</td> <td>Employee Id</td></tr>");
                int count=0;
                for(OrderList orderList: orderInfo)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d</td> <td>%d</td> <td>%d</td> <td>%s</td> <td>%d</td> <td>%d</td>",orderList.orderId,orderList.foodId,orderList.userId,orderList.orderTime,orderList.customerId,orderList.employeeId));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        %>
        
    </body>
</html>
