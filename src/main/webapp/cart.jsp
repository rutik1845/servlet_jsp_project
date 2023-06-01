<%@page import="java.util.List"%>
<%@page import="food_order.productDao"%>
<%@page import="food_order.cart"%>
<%@page import="food_order.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
Cookie ck[] = request.getCookies();
HttpSession sk = request.getSession(false);
String name = (String) sk.getAttribute("sname");

ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart_list");
List<cart> cartproduct = null;
if(cart_list != null){
	productDao pd = new productDao();
	cartproduct = pd.getcart(cart_list);
	int subtotal = pd.subtotalprice(cart_list);
	int total = pd.totalprice(cart_list);
	request.setAttribute("cart_list", cart_list);
	request.setAttribute("subtotal", subtotal);
	request.setAttribute("total", total);
}
	 
	 //ArrayList<cart> arl = new ArrayList<cart>();
	 //String a = request.getParameter("id");
	 //arl=pd.getcart();
	 //request.setAttribute("cart_list", cart_list);

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css/cart.css">
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="wrapper">
        <h1>Shopping Cart</h1>
        <div class="project">
        	<div class="shop">
               <% 
       if(cart_list != null){
    	   for(cart i: cartproduct){%>
    		    
                <div class="box">
                    <img src="img/<%=i.getImage() %>" alt="">
                    <div class="content">
                    	<a href="ordernowservlet?id=<%=i.getId()%>"><button style="float:right; margin:38px;; border-color:blue; color:black; width:100px; height:40px">Buy Now</button></a>
                        <h3><%=i.getTitle() %></h3>
                        <h4>Price: <%=i.getPrice() %></h4>
                      
                        <a href="quantity?action=dec&id=<%=i.getId()%>"><i class="fa fa-minus" aria-hidden="true"></i></a>
                        <a href="quantity?action=inc&id=<%=i.getId()%>"><i class="fa fa-plus" aria-hidden="true"></i></a>
                        <p class="unit">Quantity: <input type="text" value="<%=i.getQuantity() %>" readonly="readonly"></p>
                        
                     
                        <p class="btn-area">
                        <i class="fa fa-trash"></i>
                        <a style="text-decoration:none" style="color:white"  href="removefromservlet?id=<%=i.getId()%>"><span class="btn-2">Remove</span></a>
                        </p>
                    </div>
                </div>
           
    	  <%  }
       } %>
  			</div>
            <div class="right-bar">
                <p><span>Subtotal</span><span>${subtotal }<span> ₹</span></span></p>
                <hr>

                <p><span>Tax (5%)</span><span>10₹</span></p>
                <hr>

                <p><span>Shipping</span><span>25₹</span></p>
                <hr>

                <p><span>Total</span><span>${total }<span>₹</span></span></p>
                <hr>

                <a href="checkout.jsp"><i class="fa fa-shopping-cart"></i>Checkout</a>
                

            </div>
        </div>
    </div>

<%@include file="footer.jsp" %>
</body>
</html>