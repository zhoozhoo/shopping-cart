package ca.zhoozhoo.sc.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.zhoozhoo.sc.model.Order;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public Integer save(Order order) {
		return (Integer) sessionFactory.getCurrentSession().save(order);
	}

	@Transactional
	@Override
	public Order findById(Integer orderId) {
		return (Order) sessionFactory.getCurrentSession().byId(Order.class).load(orderId);
	}
}
