<%-- 
    Document   : previousEmployees
    Created on : Dec 20, 2016, 10:03:09 PM
    Author     : shawontafsir
--%>

<%@page import="sukarna.db.DataAccess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sukarna.models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Previous Employees</title>
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
            
            table{
            width:80%;
            text-align:center;
            margin-left:150px;
            margin-top:50px;
            box-shadow: 10px 10px green;
            font-size:20px;
            font-style: italic;
            }
            th{
                background-color: cadetblue;
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
            String mail = (String) session.getAttribute("email");
            if(mail == null){
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
            <li><a class="active" href="addEmployee.jsp">Manage Employee</a></li>
            <li><a href="addFood.jsp">Manage Food</a></li>
            <li><a href="assignOrder.jsp">Manage Order</a></li>
        </ul>
        <ul>
            <li><a href="addEmployee.jsp">Add Employee</a></li>
            <li><a href="updateEmployee.jsp">Update Employee</a></li>
            <li><a href="deleteEmployee.jsp">Delete Employee</a></li>
            <li><a class="active" href="previousEmployees.jsp">Previous Employees</a></li>
        </ul>
        
        <h1>Previous Employees : </h1>
        
        <%
            DataAccess dao = new DataAccess();
            ArrayList<Employee> previousEmployeeList = dao.getPreviousEmployeeList();
            
            if(previousEmployeeList==null)
            {
                out.println("Employee List is null");
            }
            else if(previousEmployeeList.size()==0)
            {
                out.println("No employee has left the restaurant.");
            }
            else 
            {
                out.println("<table>");
                out.println("<tr><th>Employee Name</th> <th>Email</th> <th>Mobile No.</th> <th>Join Date</th> <th>Address</th> <th>salary</th></tr>");
                int count=0;
                for(Employee employee: previousEmployeeList)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%d</td>",employee.employeeName, employee.email,employee.mobileNo,employee.joinDate,employee.address,employee.salary));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        %>
    </body>
</html>
