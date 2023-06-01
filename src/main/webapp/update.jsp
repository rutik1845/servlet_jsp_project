<%@page import="food_order.product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="food_order.adminregisterDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% adminregisterDao pd = new adminregisterDao();
ArrayList<product> arl = new ArrayList<product>();
product obj = new product();
String a = request.getParameter("id");
arl = pd.view(Integer.parseInt(a));
%>
 <% for(product i:arl)
    {%> 
<form action="updateservlet" method="post">
Id:<input type="number" name="id" value="<%=i.getId()%>" readonly="readonly"/><br>
Title:<input type="text" name="title" value="<%=i.getTitle()%>"/><br>
price:<input type="number" name="price" value="<%=i.getPrice()%>"/><br>
Description:<input type="text" name="description" value="<%=i.getDescription()%>"/><br>
image:<input type="file" name="image" value="<%=i.getImage()%>"/><br>
<input type="submit" value="update"/>
</form>
<%} %>
</body>
</html>