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
arl = pd.viewproduct();
%>

<table class="table table-sm table-dark" border="1">
  <thead>
    <tr>
      <th scope="col">ID</th>
      
      <th scope="col">Title</th>
      <th scope="col">Price</th>
      <th scope="col">Description</th>
      <th scope="col">Image</th>
    </tr>
  </thead>
  <tbody>
 <% for(product i:arl)
    {%> 
    <tr>
    <%int id= i.getId(); %>
      <td><%=i.getId() %></td>
      <td><%=i.getTitle() %></td>
      <td><%=i.getPrice()%></td>
      <td><%=i.getDescription() %></td>
      <td><%=i.getImage() %></td>
      
      <td><a href="deleteservlet?id=<%=id%>">Delete</a></td>
         <td><a href="update.jsp?id=<%=id%>">Update</a></td>
    </tr>
 <%  }%>
  </tbody>
</table>
<form action="addproductjsp.jsp" method="post">
<input type="submit" value="Add-products"/> </form>
</body>
</html>