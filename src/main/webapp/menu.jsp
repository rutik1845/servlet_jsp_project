<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="food_order.*" %>
    <%@page import="java.util.ArrayList" %>
<%
Cookie ck[] = request.getCookies();
HttpSession sk = request.getSession(false);
String name = (String) sk.getAttribute("sname");

%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/menu.css">
<title>Insert title here</title>
</head>
<body>
<div>
<%@include file="navbar.jsp" %>
</div>

<% productDao pd = new productDao();
ArrayList<product> arl = new ArrayList<product>();
arl=pd.viewproduct();
%>

<div class="main">
        <div class="section-title">
            <h2>Our menu</h2>
            <p>Each item on your menu should have an attractive name and either a list of ingredients or a persuasive description.

The name of the dish, however, should be self-explanatory. Clients need to understand what each item means at a glance and read the entire menu item description only if they are curious.</p>

        </div>
        <div class="menus">
        <%
        if(!arl.isEmpty()){
        	for(product i:arl){%>
        		 <div class="menus-column">
                
                 <div class="single-menu">
                     <img src="img/<%=i.getImage() %>" alt="">
                     <div class="menu-content">
                         <h5><%=i.getTitle() %><span><%=i.getPrice() %><span>₹</span></span></h5>
                         <p><%=i.getDescription() %></p>
                         <a href="addtocartservlet?id=<%= i.getId() %>"><button>Add to cart</button></a>
                     </div>
                 </div>
                </div>
        	<% }
        }
        %>
       </div>
 </div>
           
        
        
           <!--   <div class="menus-column">
                <h4>lunch</h4>
                <div class="single-menu">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1l8RtUoV4lrpI8vBdOiHUqJ1-5mUgt9fZoA&usqp=CAU" alt="">
                    <div class="menu-content">
                        <h5>food tile<span>130<span>₹</span></span></h5>
                        <p>Lorem, ipsum dolor sit amet</p>
                        <button>Add to cart</button>
                    </div>
                </div>
            
            
                
                <div class="single-menu">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1l8RtUoV4lrpI8vBdOiHUqJ1-5mUgt9fZoA&usqp=CAU" alt="">
                    <div class="menu-content">
                        <h5>food tile<span>130<span>₹</span></span></h5>
                        <p>Lorem, ipsum dolor sit amet</p>
                        <button>Add to cart</button>
                    </div> 
                </div>
            
            
                
                <div class="single-menu">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1l8RtUoV4lrpI8vBdOiHUqJ1-5mUgt9fZoA&usqp=CAU" alt="">
                    <div class="menu-content">
                        <h5>food tile<span>130<span>₹</span></span></h5>
                        <p>Lorem, ipsum dolor sit amet</p>
                        <button>Add to cart</button>
                    </div> 
                </div>
            
            </div>
            <div class="menus-column">
                <h4>Dinner</h4>
                <div class="single-menu">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1l8RtUoV4lrpI8vBdOiHUqJ1-5mUgt9fZoA&usqp=CAU" alt="">
                    <div class="menu-content">
                        <h5>food tile<span>130<span>₹</span></span></h5>
                        <p>Lorem, ipsum dolor sit amet</p>
                        <button>Add to cart</button>
                    </div>
                </div>
            
            
                
                <div class="single-menu">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1l8RtUoV4lrpI8vBdOiHUqJ1-5mUgt9fZoA&usqp=CAU" alt="">
                    <div class="menu-content">
                        <h5>food tile<span>130<span>₹</span></span></h5>
                        <p>Lorem, ipsum dolor sit amet</p>
                        <button>Add to cart</button>
                    </div> 
                </div>
           
            
                
                <div class="single-menu">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1l8RtUoV4lrpI8vBdOiHUqJ1-5mUgt9fZoA&usqp=CAU" alt="">
                    <div class="menu-content">
                        <h5>food tile<span>130<span>₹</span></span></h5>
                        <p>Lorem, ipsum dolor sit amet</p>
                        <button>Add to cart</button>
                    </div> 
                </div>
            </div>
       </div> 
    </div>-->

<div class="foot">
<%@include file="footer.jsp" %>
</div>
</body>
</html>