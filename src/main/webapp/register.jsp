<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
    <title>Document</title>
</head>
<body>
    <div class="main">
        <div class="register">
            <h2>Register here</h2>
            <form action="registerservlet" class="id" method="post">
                <label>First Name: </label><br>
                
                <input type="text" name="fname" id="name" placeholder="Enter your first name" required><br><br>
                <label>Last Name: </label><br>
                <input type="text" name="lname" id="name" placeholder="Enter your last name" required><br><br>
                <label>Email address: </label><br>
                <input type="email" name="email" id="name" placeholder="Enter your Email id" required><br><br>
                <label>Password: </label><br>
                <input type="password" name="pass" id="name" placeholder="Enter your Password" required><br><br>
                <label>Phone Number: </label><br>
                <input type="number" name="phn_no" id="name" placeholder="Enter your Phone number" required><br><br>
                <label>Address: </label><br>
                <textarea name="address" id="name" placeholder="Enter your address" required></textarea><br><br>
                <input type="submit" id="submit" value="Register"/>
            </form>
        </div>
    </div>
</body>
</html>