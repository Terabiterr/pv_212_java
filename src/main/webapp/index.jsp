<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.List, com.example.models.Employee" %>
<%@ page import="java.util.ArrayList" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employees</title>
</head>
<body>
<table>
    <h1>Main Page</h1>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Position</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("listEmployees");
        if(employees!=null)
            for (Employee employee : employees) {
    %>
    <tr>
        <td><%= employee.getId()%></td>
        <td><%= employee.getName()%></td>
        <td><%= employee.getEmail()%></td>
        <td><%= employee.getPosition()%></td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
