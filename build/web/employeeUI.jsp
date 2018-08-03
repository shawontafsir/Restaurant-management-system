<%-- 
    Document   : employeeUI
    Created on : Dec 17, 2016, 2:50:32 AM
    Author     : shawontafsir
--%>

<%@page import="sukarna.db.DataAccess"%>
<%@page import="sukarna.models.OrderList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee UI</title>
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
            <li><a href="showFoodList.jsp">Food List</a></li>
            <li><a class="active" href="employeeUI.jsp">Employee UI</a></li>
            <li><a href="showEmployeeList.jsp">Employee List</a></li>
            <li><a href="">About Us</a></li>
        </ul>
        
        <fieldset style="width: 300px;float:left">
            <legend><h3>Employee ID</h3></legend>
            <h4>To see your assigned order, please enter your Employee Id first : </h4>
            <form method="post" action="EmployeeTasks.do">
                Employee Id : <input type="number" name="employeeId" min="1"/> <br/><br/>
                <input type="submit" value="Assigned orders" /> <br/>
            </form>
        </fieldset>
        <fieldset style="width: 300px;float: right">
            <legend><h3>Completed Order ID</h3></legend>
            <h4>If you have completed one of your assigned orders, please enter completed order Id : </h4>
            <form method="post" action="DeleteOrderByEmployee.do">
                Completed Order Id : <input type="number" name="orderId" min="1"/><br/><br/>
                <input type="submit" value="Delete order" /> <br/>
            </form>
        </fieldset>
      
        <h1 style="clear: left;margin-top: 250px">Your assigned orders : </h1>
        <%
            String employeeId = (String) session.getAttribute("employeeId");
            DataAccess db = new DataAccess();
            ArrayList<OrderList> orderInfo = db.employeeTasks(Integer.parseInt(employeeId));
            
            if(orderInfo==null)
            {
            }
            else if(orderInfo.size()==0)
            {
                out.println("Enter your employee Id to see your assigned orders.");
            }
            else 
            {
                out.println("<table>");
                out.println("<tr><th>Order Id</th> <th>Food Id</th> <th>User Id</th> <th>Customer Id</th> <th>Order Time</th></tr>");
                int count=0;
                for(OrderList orderList: orderInfo)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d</td> <td>%d</td> <td>%d</td> <td>%d</td> <td>%s</td>",orderList.orderId,orderList.foodId,orderList.userId,orderList.customerId,orderList.orderTime));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        %>
        
        <br/><br/>
        <jsp:include page="showOrderList.jsp" />
    </body>
</html>
