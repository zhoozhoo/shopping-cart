package ca.zhoozhoo.sc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.zhoozhoo.sc.repository.ProductRepository;

@Controller
public class ViewController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/products")
	public String products(Model model) {

		return "products";
	}
}
