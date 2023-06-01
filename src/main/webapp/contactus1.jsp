<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/contactus.css">
</head>
<body>
<%@include file="navbar.jsp" %>

    <div class="contactForm">
        <form action="queryservlet" method="post">
            <b><h2>Send Message</h2></b>
            <div class="inputBox">
                <input type="text" name="name" required="required">
                <span>Full Name</span>
            </div>
             <div class="inputBox">
                <input type="text" name="email" required="required">
                <span>Email</span>
            </div>
             <div class="inputBox">
                <textarea name="querys" required="required"></textarea>
                <span>Type Your Message...</span>
            </div>
             <div class="inputBox">
                <input type="Submit" name="" value="Send">
             </div>
        </form>
    </div> 


<%@include file="footer.jsp" %>
</body>
</html>