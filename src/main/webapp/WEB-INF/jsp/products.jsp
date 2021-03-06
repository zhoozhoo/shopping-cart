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
					async : false,
					success : function(products) {
						var table = $("#productsTable tbody");
						$.each(products, function(index, product) {
							table.append('<tr><td><input type="checkbox" id="checkbox_'+ product.id + '" name="cartItems['+ index +'].product.id" value="'+ product.id + '">'
									+ "</td><td>" + product.name 
									+ "</td><td>" + product.price 
									+ '</td><td><input type="text" size="2" maxlength="2" id="quantity_'+ product.id + '" name="cartItems['+ index +'].quantity"></td></tr>');
						});
					}
				});
				$.ajax({
					url : "${pageContext.request.contextPath}/getCart",
					async : false,
					success : function(cart) {
						$.each(cart.cartItems, function(index, cartItem) {
							$("#checkbox_" + cartItem.product.id).prop('checked', true);
							$("#quantity_" + cartItem.product.id).prop('value', cartItem.quantity);
						});
					}
				});
			});
</script>
</head>

<body>
	<div>
		<h2>Products</h2>
		<form:form method="POST" modelAttribute="cart" action="${pageContext.request.contextPath}/review">
			<table id="productsTable">
				<thead>
					<tr>
						<th width="30"></th>
						<th width="200">Name</th>
						<th width="60">Price</th>
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
