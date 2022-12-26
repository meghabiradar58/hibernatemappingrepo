<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id=request.getParameter("id");
String name=request.getParameter("name");
String mobile=request.getParameter("mobile");
String email=request.getParameter("email");
String username=request.getParameter("username");
String password=request.getParameter("password");

%>
<table>
<tr><td> <label>Id:</label></td>
<td><%=id %></td>
</tr>
<tr><td> <label>name:</label></td>
<td><%=name %></td>
</tr>
<tr><td> <label>mobile:</label></td>
<td><%=mobile %></td>
</tr>
<tr><td> <label>email:</label></td>
<td><%=email %></td>
</tr>
<tr><td> <label>username:</label></td>
<td><%=username %></td>
</tr>
<tr><td> <label>password:</label></td>
<td><%=password %></td>
</tr>



</table>
</body>
</html>