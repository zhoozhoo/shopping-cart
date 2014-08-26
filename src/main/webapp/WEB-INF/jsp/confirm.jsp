<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Confirmation</title>
<body>
	<fmt:setLocale value="en_US" scope="session" />
	<div>
		<h2>Order Confirmation</h2>
		The total price for your order is
		<fmt:formatNumber value="${total}" type="currency" />
		and your confirmation number is ${orderId}. Thanks for your oder.
	</div>
</body>
</html>
