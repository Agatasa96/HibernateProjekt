<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${books }" var="b">
		<p>Title: ${b.title }</p>
		<p>Description: ${b.description }</p>
		<p>Rating: ${b.rating }</p>
		<p><a href="update/${b.id }"> Edit book</a></p>
		<p><a href="sureToDelete/${b.id }"> Delete book</a></p>
	</c:forEach>
</body>
</html>