<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review Order</title>
<script type="text/javascript" src="<c:url value='/resources/jquery-2.1.1.js' /> "></script>
</head>
<body>
	<div>
		<h2>Review Order</h2>
		<table id="table">
			<thead>
				<tr>
					<th width="100">Name</th>
					<th width="100">Price</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cartItem" items="${cart.cartItems}">
					<tr>
						<td>${cartItem.product.name}</td>
						<td>${cartItem.product.price}</td>
						<td>${cartItem.quantity}</td>
					</tr>
				</c:forEach>
				<tr>
					<th>Total</th>
					<th>${cart.total}</th>
					<th></th>
				</tr>
			</tbody>
		</table>

		<form:form method="GET" action="${pageContext.request.contextPath}/confirm">
			<p>
				<input type="submit" name="edit" value="Back" /> <input type="submit" name="confirm" value="Confirm" />
			</p>
		</form:form>
	</div>
</body>
</html>
