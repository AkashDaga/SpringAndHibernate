<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<title>Customer Confirmation</title>
</head>
<body>the customer is confirmed: ${customer.firstName}
	${customer.lastName} number of passes: ${ customer.freePasses } postal
	Code: ${ customer.postalCode } Course Code: ${ customer.courseCode }
</body>
</html>
