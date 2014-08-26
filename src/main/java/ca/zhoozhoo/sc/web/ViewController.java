package ca.zhoozhoo.sc.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ca.zhoozhoo.sc.model.Cart;
import ca.zhoozhoo.sc.model.CartItem;
import ca.zhoozhoo.sc.model.Product;
import ca.zhoozhoo.sc.repository.ProductRepository;

@Controller
@Scope("session")
@SessionAttributes({ "cart" })
public class ViewController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(HttpSession session) {
		return "products";
	}

	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public ModelAndView review(@ModelAttribute("order") Cart cart, HttpSession session) {
		List<CartItem> cartItems = new ArrayList<CartItem>();
		for (CartItem cartItem : cart.getCartItems()) {
			if ((cartItem.getProduct().getId() != null) && (cartItem.getQuantity() != null)) {
				cartItems.add(cartItem);
			}
		}
		cart.setCartItems(cartItems);

		return new ModelAndView("review", "cart", cart);
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET, params = { "edit" })
	public ModelAndView edit(@ModelAttribute("order") Cart cart, HttpSession session) {
		return new ModelAndView("products", "cart", cart);
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET, params = { "confirm" })
	public ModelAndView confirm(@ModelAttribute("order") Cart cart, HttpSession session) {
		return new ModelAndView("confirm", "cart", cart);
	}

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();

		return products;
	}
}
