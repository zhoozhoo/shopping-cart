package ca.zhoozhoo.sc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ca.zhoozhoo.sc.model.Order;
import ca.zhoozhoo.sc.model.Product;
import ca.zhoozhoo.sc.repository.ProductRepository;

@Controller
public class ViewController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products() {
		return "products";
	}

	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public ModelAndView review(@ModelAttribute("order") Order order) {
		return new ModelAndView("review", "order", order);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("order") Order order) {
		return new ModelAndView("products", "order", order);
	}

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();

		return products;
	}
}
