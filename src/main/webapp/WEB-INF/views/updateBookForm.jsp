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
	<form:form method="post" modelAttribute="bookToUpdate">
<form:errors path="*"/>
		<p>
			Title:
			<form:input path="title" />
		</p>
		<p>
			Description:
			<form:input path="description" />
		</p>
		<p>
			Rating:
			<form:input path="rating" />
		</p>
		<p>
			Publisher:
			<form:select path="publisher.id" items="${publisherList}"
				itemLabel="name" itemValue="id"></form:select>
		</p>
		<p>
			Author
			<form:select path="authors" items="${authors }" itemLabel="firstName"
				itemValue="id" />
		</p>

		<input type="submit" value="Save">
	</form:form>

</body>
</html>