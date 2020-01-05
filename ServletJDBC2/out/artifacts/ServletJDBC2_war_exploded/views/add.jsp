<%--
  Created by IntelliJ IDEA.
  User: kulishd
  Date: 23.12.2019
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Record</title>
</head>
<body>

<div>
    <h1>Add Record to Journal</h1>
</div>
<div>
    <%
        if (request.getAttribute("record") !=null){
            out.println("<p>Record '" + request.getAttribute("record") + "' added!</p>");
        }
    %>
    Example : 1 13/08/1995 1 fds sdf
<form method="post">
    <label> Record:
    <input type="text" name="Record"> <button type="submit">Submit</button> <br/>
    </label>
</form>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
