<%-- 
    Document   : customerUI
    Created on : Dec 17, 2016, 9:07:44 AM
    Author     : shawontafsir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer UI</title>
        <style>
            body  {
                background-color: #cccccc;
            }
        </style>
    </head>
    <body>
        <form method="post" action="CustomerInfo.do">
            Your Name : <input type="text" name="customerName" /> <br/><br/>
            Table No. : <input type="number" name="tableNo" /> <br/><br/>
            <input type="submit" value="AddInfo">
        </form>
        
        
    </body>
</html>
