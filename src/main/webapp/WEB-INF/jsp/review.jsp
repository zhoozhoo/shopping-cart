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
				<c:forEach var="movie" items="${order.orderItems}">
					<tr>
						<td>${productId}</td>
						<td>${productId}</td>
						<td>${productQyantity}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form method="POST" action="${pageContext.request.contextPath}/previewOrder">
			<p>
				<button type="submit">Back</button>
				<button type="submit">Confirm</button>
			</p>
		</form:form>
	</div>
</body>
</html>
