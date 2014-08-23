package ca.zhoozhoo.sc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

	@RequestMapping("/products")
	public String products(Model model) {

		return "products";
	}
}
