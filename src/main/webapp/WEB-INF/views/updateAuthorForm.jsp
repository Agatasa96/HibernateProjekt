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
<form:form method="post" modelAttribute="authorToUpdate">

		<p>
			First name
			<form:input path="firstName" />
		</p>
		
		<p>
			Last name
			<form:input path="lastName" />
		</p>
		
		<input type="submit" value="ok" />
	</form:form>


</body>
</html>