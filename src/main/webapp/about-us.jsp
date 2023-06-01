<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/aboutus.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

<%@include file="navbar.jsp" %>

    <div class="section">
        <div class="container">
            <div class="title">
                <h1> about us</h1>
            </div>
            <div class="content">
                <div class="article">
                    <h3> Lorem ipsum dolor sit amet consectetur adipisicing elit. Porro voluptatum aliquam laudantium
                        tempore rem, debitis a quod aspernatur. Non molestias in voluptates impedit nemo amet tempora
                        libero ipsam sed recusandae? </h3>
                    <p> Lorem ipsum dolor sit amet consectetur adipisicing elit. Officiis repellendus inventore alias
                        corporis amet et! Sint quasi explicabo eligendi commodi consequuntur eum facere dolor rerum
                        aliquam repellat! Exercitationem, repellat similique?</p>
                    <div class="button">
                        <a href="#"> Read more</a>
                    </div>
                </div>
            </div>
            <div class="image">
                <img src="img/choco-lava-cake.jpg">

            </div>
            <div class="social">
                <a href=""><i class="fab fa-facebook-f"></i></a>
                <a href=""><i class="fab fa-twitter"></i></a>
                <a href=""><i class="fab fa-instagram"></i></a>
            </div>
        </div>
    </div>
    
<%@include file="footer.jsp" %>   

</body>
</html>