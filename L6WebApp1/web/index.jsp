<%-- 
    Document   : index
    Created on : 14.10.2011, 14:09:46
    Author     : 1_Утро-День
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%= new  java.util.Date() %>
        <jsp:useBean id="bean" class="ex2.Customers" />
        <%  java.util.List list=bean.getCustomers(3);
            for(Object i : list)
                out.println("<BR>"+i); %>
    </body>
</html>
