<%-- 
    Document   : foodList
    Created on : Dec 5, 2016, 11:26:55 PM
    Author     : shawontafsir
--%>

<%@page import="sukarna.db.DataAccess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sukarna.models.Food"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Food List</title>
        <style>
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
        body{
            background-color: #cccccc;
        }
        </style>
    </head>
    <body>
        <h1 align="center">FOOD LIST</h1>
        <% 
            DataAccess dao = new DataAccess();
            ArrayList<Food> foodList = dao.getFoodList();
            if(foodList==null)
            {
                out.println("Food List is null");
            }
            else if(foodList.size()==0)
            {
                out.println("Food List has no records.");
            }
            else 
            {
                out.println("<table>");
                out.println("<tr><th>Food Id</th>   <th>Name</th>   <th>Category</th>   <th>Price</th>   <th>Description</th></tr>");
                int count=0;
                for(Food food: foodList)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%d</td>   <td>%s</td>   <td>%s</td>    <td>%d</td>    <td>%s</td>", food.foodId, food.name, food.category,food.price,food.description));
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        %>
        
        
    </body>
</html>
