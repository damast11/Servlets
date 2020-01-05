<%@ page import="java.util.List" %>
<%@ page import="JDBC.entity.Record" %><%--
  Created by IntelliJ IDEA.
  User: kulishd
  Date: 23.12.2019
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
        <div>
            <h1>Journal</h1>
        </div>
    <%
        List<Record> records = (List<Record>) request.getAttribute("records");

        if (records!=null && !records.isEmpty()){

            out.println("<ui>");
            for (Record r : records){
                out.println( "<li>"+ r+"</li>" );
            }
            out.println("</ui>");
        }else out.println("<p> Threre are no records yet!</p>");
    %>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
