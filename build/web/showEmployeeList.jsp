<%-- 
    Document   : showEmployeeList
    Created on : Dec 16, 2016, 9:56:27 PM
    Author     : shawontafsir
--%>

<%@page import="sukarna.models.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sukarna.db.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee List</title>
        <style>
            body{
                background-color: #cccccc;;
            }
            table{
                width:80%;
                text-align:center;
                margin-left:200px;
                margin-top:100px;
                box-shadow: 10px 10px green;
                font-size:20px;
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
        <h1>EMPLOYEE LIST</h1>
        <%
            DataAccess dao = new DataAccess();
            ArrayList<Employee> employeeList = dao.getEmployeeList();
            
            if(employeeList==null)
            {
                out.println("Employee List is null");
            }
            else if(employeeList.size()==0)
            {
                out.println("Employee List has no records.");
            }
            else 
            {
                out.println("<table>");
                out.println("<tr><th>Employee Id</th> <th>Employee Name</th> <th>Email</th> <th>Mobile No.</th> <th>Join Date</th> <th>Address</th> <th>salary</th> <th>Manager Id</th></tr>");
                int count=0;
                for(Employee employee: employeeList)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%d</td> <td>%d</td>", employee.employeeId, employee.employeeName, employee.email,employee.mobileNo,employee.joinDate,employee.address,employee.salary,employee.managerId));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        %>
    </body>
</html>
