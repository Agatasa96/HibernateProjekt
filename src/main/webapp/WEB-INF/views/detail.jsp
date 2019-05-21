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

	<form:form method="post" modelAttribute="personDto">
Login: <form:input path="login" />
Password: <form:password path="password" />
Email: <form:input path="email" />
First: <form:input path="firstName" />
Last: <form:input path="lastName" />
Gender: <p>
			F:
			<form:radiobutton path="gender" value="female" />
		</p>
		<p>
			M:
			<form:radiobutton path="gender" value="male" />
		</p>
Country: <form:select path="country" items="${country }"
			multiple="false" />
Notes <form:textarea path="notes" />
MailingList: <form:checkboxes path="mailingList" items="${mailing }"
			multiple="true" />
Programming skills: <form:select path="programmingSkills"
			items="${programmingSkills }" multiple="true" />
Hobbies: <form:checkboxes path="hobbies" items="${hobbies }"
			multiple="true" />
		<input type="submit" value="send">
	</form:form>
</body>
</html>