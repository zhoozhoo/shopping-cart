package ca.zhoozhoo.sc.model;

public class OrderItem {
	private Product product;
	private Integer productQuantity;

	public OrderItem() {
		super();
	}

	public OrderItem(Product product, Integer productQuantity) {
		super();
		this.product = product;
		this.productQuantity = productQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "OrderItem [product=" + product + ", productQuantity=" + productQuantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productQuantity == null) ? 0 : productQuantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productQuantity == null) {
			if (other.productQuantity != null)
				return false;
		} else if (!productQuantity.equals(other.productQuantity))
			return false;
		return true;
	}
}