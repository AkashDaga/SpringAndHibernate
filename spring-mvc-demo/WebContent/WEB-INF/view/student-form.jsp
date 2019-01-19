<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
First Name : <form:input path="firstName" />
		<br>
		<br>
Second Name : <form:input path="lastName" />
		<br>
		<br>
		
		Select Country: <form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>

		<br>
		<br>
		
		Favourite Language: <form:radiobuttons path="favouriteLanguage"
			items="${student.favouriteLanguageOptions}" />

		<br>
		<br>
			Operating System: <form:checkboxes path="operatingSystems"
			items="${student.favouriteOperatingSystemOptions}" />

		<br>
		<br>

		<input type="submit" value="Submit">
	</form:form>
</body>
</html>
