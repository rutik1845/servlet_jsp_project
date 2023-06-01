<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addproduct" method="post">
id:<input type="number" name="id"/><br>
title:<input type="text" name="title"/><br>
price:<input type="number" name="price"/><br>
description:<input type="text" name="description"/><br>
image:<input type="file" name="image"/><br>
<input type="submit" value="submit"/>
</form>
<form action="viewproduct.jsp" method="post">
Click To view products:<input type="submit" value="click"/>
</form>
</body>
</html>