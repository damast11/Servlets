<%@ page import="java.util.List" %>
<%@ page import="JDBC.entity.Record" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kulishd
  Date: 24.12.2019
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>JournalFilter</h1>
</div>


<form method="post">
    <label> Filter:
        <input type="text" name="Filter"> <button type="submit">Submit</button> <br/>
    </label>
</form>
<%
    List<Record> records = (List<Record>) request.getAttribute("filter");
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
