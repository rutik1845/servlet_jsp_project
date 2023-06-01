<%@page import="food_order.order"%>
<%@page import="food_order.cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="food_order.orderDao"%>
<%@page import="java.util.List"%>
<%@page import="food_order.customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    customer obj = (customer) request.getSession().getAttribute("obj");
	List<order> orders = null;
	if (obj != null) {
	    request.setAttribute("person", obj);
	    orderDao orderDao  = new orderDao();
		orders = orderDao.userOrders(obj.getId());
	}else{
		response.sendRedirect("login.jsp");
	}
	ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("car_list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	} 
	%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
<%@include file="navbar.jsp"  %>

<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(orders != null){
				for(order o:orders){%>
					<tr>
						<td><%=o.getDate() %></td>
						<td><%=o.getTitle() %></td>
						<td><%=o.getDescription() %></td>
						<td><%=o.getQuantity() %></td>
						<td><%=o.getPrice()%></td>
						<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getOrder_id()%>">Cancel Order</a></td>
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>
			


<%@include file="footer.jsp" %>

</body>
</html>