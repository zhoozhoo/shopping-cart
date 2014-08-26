package ca.zhoozhoo.sc.model;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Cart {
	private List<CartItem> cartItems;

	public Cart() {
		super();
	}

	public Cart(List<CartItem> cartItems) {
		super();
		this.cartItems = cartItems;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Float getTotal() {
		Float total = 0F;
		for (CartItem cartItem : cartItems) {
			if ((cartItem != null) && (cartItem.getProduct() != null) && (cartItem.getProduct().getId() != null)
					&& (cartItem.getProduct().getPrice() != null) && (cartItem.getQuantity() != null)) {
				total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
			}
		}

		return total;
	}

	@Override
	public String toString() {
		return "Cart [cartItems=" + cartItems + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
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
		Cart other = (Cart) obj;
		if (cartItems == null) {
			if (other.cartItems != null)
				return false;
		} else if (!cartItems.equals(other.cartItems))
			return false;
		return true;
	}
}
