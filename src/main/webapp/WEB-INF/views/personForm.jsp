<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" modelAttribute="person">
<p>Login: <form:input path="login" /></p>
Password: <form:password path="password" />
Email <form:input path="email" />
		<input type="submit" value="ok">
	</form:form>


</body>
</html>