package com.mysmartshop.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mysmartshop.order.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{
	public Order findByOrderId(String orderString);
}
