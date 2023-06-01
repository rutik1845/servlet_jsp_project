<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/contactus.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<%@include file="navbar.jsp" %>


<section class="contact">
        <div class="content">
           <b><h2>Contact Us</h2></b>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Veritatis maiores, atque quo, numquam nihil
                reiciendis consequatur amet ratione vero quod ad laborum rem, animi totam quaerat nemo minus ex quia.
            </p>
        </div>
        <div class="container">
            <div class="contactInfo">
                <div class="box">
                    <div class="icon"><i class="fa fa-map-marker" aria-hidden="true"></i>
                    </div>
                    <div class="text">
                        <h3>Address</h3>
                        <p>302 saiganga karanjade</p>
                    </div>
                </div>
                <div class="box">
                    <div class="icon"><i class="fa fa-phone"></i></div>
                    <div class="text">
                        <h3>Phone</h3>
                        <p>8424049068</p>
                    </div>
                </div>
                <div class="box">
                    <div class="icon"><i class="fa fa-envelope" aria-hidden="true"></i></div>
                    <div class="text">
                        <h3>Email</h3>
                        <p>rutikchakane712@gmail.com</p>
                    </div>
                </div>
            </div>
        </div>        
                <a style="color: white;" href="contactus1.jsp">click here to send query</a>
    </section>


<%@include file="footer.jsp" %>
</body>
</html>