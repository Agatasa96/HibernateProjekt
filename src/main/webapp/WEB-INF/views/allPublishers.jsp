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
	<c:forEach items="${publishers}" var="p">
		<p>Name: ${p.name}</p>
		<p>
			<a href="update/${p.id }"> Edit author</a>
		</p>
		<p>
			<a href="delete/${p.id }"> Delete author</a>
		</p>
	</c:forEach>
</body>
</html>