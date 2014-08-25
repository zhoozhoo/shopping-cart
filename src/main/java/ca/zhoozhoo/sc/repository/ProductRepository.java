package ca.zhoozhoo.sc.repository;

import java.util.List;

import ca.zhoozhoo.sc.model.Product;

public interface ProductRepository {
	
	public List<Product> findAll();

	public Product findById(Integer id);
}
