package ca.zhoozhoo.sc.web;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ca.zhoozhoo.sc.model.*;
import ca.zhoozhoo.sc.repository.OrderRepository;
import ca.zhoozhoo.sc.repository.ProductRepository;

@Controller
public class ViewController {

	private static final String CART = "cart";

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(HttpSession httpSession) {
		return "products";
	}

	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public ModelAndView review(@ModelAttribute("order") Cart cart, HttpSession httpSession) {
		List<CartItem> cartItems = new ArrayList<CartItem>();

		cart.getCartItems().stream().filter(cartItem -> (cartItem.getProduct() != null)
				&& (cartItem.getProduct().getId() != null) && (cartItem.getQuantity() != null)).forEach(cartItem -> {
					cartItem.setProduct(productRepository.findById(cartItem.getProduct().getId()));
					cartItems.add(cartItem);
				});

		cart.setCartItems(cartItems);
		httpSession.setAttribute(CART, cart);

		return new ModelAndView("review", "cart", cart);
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET, params = { "edit" })
	public ModelAndView edit(HttpSession httpSession) {
		Cart cart = (Cart) httpSession.getAttribute(CART);

		return new ModelAndView("products", "cart", cart);
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET, params = { "confirm" })
	public ModelAndView confirm(HttpSession httpSession) {
		Cart cart = (Cart) httpSession.getAttribute(CART);

		Order order = new Order();
		Set<OrderItem> orderItems = new HashSet<OrderItem>();
		for (CartItem cartItem : cart.getCartItems()) {
			orderItems.add(new OrderItem(order, cartItem.getProduct(), cartItem.getQuantity()));
		}
		order.setOrderItems(orderItems);

		Integer orderId = orderRepository.save(order);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("orderId", orderId);
		model.put("total", cart.getTotal());

		httpSession.setAttribute(CART, null);

		return new ModelAndView("confirm", model);
	}

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Product> getAllProducts(HttpSession httpSession) {
		List<Product> products = productRepository.findAll();

		return products;
	}

	@RequestMapping(value = "/getCart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Cart getCart(HttpSession httpSession) {
		Cart cart = (Cart) httpSession.getAttribute(CART);
		if (cart == null) {
			httpSession.setAttribute(CART, new Cart(new ArrayList<CartItem>()));
		}

		return cart;
	}
}
