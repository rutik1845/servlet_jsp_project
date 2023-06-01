<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/first.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
<div class="container">
        <div class="header">
            <h1>Admin login</h1>
        </div>
        <div class="main">
            <form action="adminverificationservlet" method="post">
                <span>
                    <i class="fa fa-user"></i>
                    <input type="text" placeholder="Name" name="name" required>
                </span><br>
                <span>
                    <i class="fa fa-lock"></i>
                    <input type="password" placeholder="password" name="pass" required>
                </span><br>
                <button>Login</button>               
            </div>
        </div>
    </div>
</body>
</html>
