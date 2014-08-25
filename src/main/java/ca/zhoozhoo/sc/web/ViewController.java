package ca.zhoozhoo.sc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.zhoozhoo.sc.model.Product;
import ca.zhoozhoo.sc.repository.ProductRepository;

@Controller
public class ViewController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/products")
	public String products(Model model) {

		return "products";
	}

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();

		return products;
	}
}
