<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/navbar.css">
    <title>Document</title>
</head>
<body>
    <div class="dropdown">
        <nav>
            
            <img class="logo" src="https://i.pinimg.com/originals/9d/df/61/9ddf619d61c5e4279c6bfeb66c0bae97.png">
            <ul>
                <li><a href="home.jsp">Home</a>
                <li><a href="menu.jsp">Menu</a>
                    <!--<ul>
                        <li><a href="#">Veg</a></li>
                        <li><a href="#">NON-Veg</a></li>
                    </ul>-->
                </li>
                <li><a href="about-us.jsp">About-Us</a></li>
                <li><a href="contact-us.jsp">Contact-Us</a></li>
                <li><a href="cart.jsp">Cart<i class="fa badge" style="font-size:24px">&#xf07a;</i><span>${cart_list.size()}</span></a></li>
                <li><a href="order.jsp">Orders</a></li>
                <li><a href="first.jsp">Logout</a></li>
            </ul>
        </nav>
    </div>
</body>
</html>