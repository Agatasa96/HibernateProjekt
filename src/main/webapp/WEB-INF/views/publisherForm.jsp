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
	<form:form method="post" modelAttribute="publisher">
		<form:errors path="*"/>
		<p>
			Name
			<form:input path="name" />
		</p>
		<input type="submit" value="ok" />
	</form:form>
</body>
</html>