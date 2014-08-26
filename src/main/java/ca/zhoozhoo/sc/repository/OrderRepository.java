package ca.zhoozhoo.sc.repository;

import ca.zhoozhoo.sc.model.Order;

public interface OrderRepository {

	public Integer save(Order order);

	public Order findById(Integer orderId);

}
