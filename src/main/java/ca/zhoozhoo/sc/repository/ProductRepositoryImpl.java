package ca.zhoozhoo.sc.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.zhoozhoo.sc.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Product> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Product")
				.list();
	}

	@Transactional
	@Override
	public Product findById(Integer id) {
		return null;
	}
}
