package com.lm.service;

import java.util.List;

import com.lm.bean.Order;
import com.lm.utils.WorkException;

public interface OrderService {
	public void buyProducts(Order o)throws WorkException;
	public List<Order> list()throws WorkException;
	public Order findById(int orderId)throws WorkException;
}
