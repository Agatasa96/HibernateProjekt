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
	<form:form method="post" modelAttribute="book">
	<form:errors path="*"/>
		<p>
			Title
			<form:input path="title" />
		</p>
		<p>
			Author
			<form:select path="authors" items="${authors }" itemLabel="firstName"
				itemValue="id" />
		</p>
		<p>
			Publisher
			<form:select path="publisher" items="${publishers }" itemLabel="name"
				itemValue="id" />
		</p>
		<p>
			Desc
			<form:input path="description" />
		</p>
		<p>
			Rating
			<form:input path="rating" />
		</p>
		
		<p>
			Rating
			<form:input path="yearOfBirth" />
		</p>
		<input type="submit" value="ok" />
	</form:form>
</body>
</html>