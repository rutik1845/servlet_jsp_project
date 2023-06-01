<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="javax.servlet.http.*" %>
  
 <%@page import="food_order.loginverification"%>
 <%@page import="food_order.*" %>
 <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
<div>
<%@include file="navbar.jsp" %>
</div>
<%-- <%@include file="food_order" %> --%>
<%
Cookie ck[] = request.getCookies();
HttpSession sk = request.getSession(false);
String name = (String) sk.getAttribute("sname");


ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart_list");

if(cart_list != null){
	request.setAttribute("cart_list", cart_list);
}

%>

<center><marquee width="60%" direction="up" height="100px"><h1 color="red">Welcome to our reastuarant,  <%=name%>!!</h1></marquee></center>
<!--  <%= request.getParameter("fname") %>-->






<div class="main-div">
    <div class="head">
        <h1>Stay fit<br>Eat healthy</h1>
        <a href="menu.jsp"><button>Order Now</button></a>
    </div>
    <div class="img">
        <img src="https://media.istockphoto.com/id/1309230872/photo/grilled-chicken-fillet-with-salad-keto-ketogenic-paleo-diet-healthy-food-diet-lunch-concept.jpg?b=1&s=170667a&w=0&k=20&c=XZ8FfOEY2AD8qUJ0r_JQo-zZm6cE0_7_Sf1L4afnwLQ=" alt="sorry">
    </div>
    
</div>

<div class="headservice">
             <center> <h1 >Our special Dishes</h1></center>
       </div>
       <div class="row">
       <div class="service">
       <img src="img/classic-burger.jpg" style="width:100%">
       <div class="ptext"><p>(Herb Chilli Tikki, Tomato, Onion)
       </p>
       </div>
       </div>
       <div class="service">
       <img src="img/choco-lava-cake.jpg" alt="sorry" style="width:100%">
       <div class="ptext"><p>(Fresh Hot Chocolava With Lots Of Chocolate Lava) 
       </p>
       </div>
       </div>
       
       <div class="service">
       <img src="img/red-sauce-pasta.jpg" alt="sorry" style="width:100%">
       <div class="ptext"><p>(Black Olive, Sweet Corn, Capsicum, Mushroom) 
       </p>
       </div>
       </div>
       </div>




<div>
<%@include file="footer.jsp" %>
</div>



</body>
</html>