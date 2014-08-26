<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
<script type="text/javascript" src="<c:url value='/resources/jquery-2.1.1.js' /> "></script>
<script>
	$(document).ready(
			function() {
				$.ajax({
					url : "${pageContext.request.contextPath}/getAllProducts",
					success : function(products) {
						var table = $("#table tbody");
						$.each(products, function(index, product) {
							table.append('<tr><td><input type="checkbox" name="orderItems['+ index +'].productId" value="'+ product.id + '">'
									+ "</td><td>" + product.name
									+ "</td><td>" + product.price
									+ '</td><td><input type="text" size="2" maxlength="2" name="orderItems['+ index +'].productQuantity"></td></tr>');
						});
					}
				});
			});
</script>
</head>

<body>
	<div>
		<h2>Products</h2>
		<form:form method="POST" modelAttribute="order" action="${pageContext.request.contextPath}/review">
			<table id="table">
				<thead>
					<tr>
						<th width="30"></th>
						<th width="100">Name</th>
						<th width="100">Price</th>
						<th>Quantity</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<p>
				<button type="submit">Review</button>
			</p>
		</form:form>
	</div>
</body>
</html>
