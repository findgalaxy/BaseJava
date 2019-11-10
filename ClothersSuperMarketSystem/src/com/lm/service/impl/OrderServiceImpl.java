package com.lm.service.impl;

import java.util.List;

import com.lm.bean.Order;
import com.lm.service.OrderService;
import com.lm.utils.OrderFile;
import com.lm.utils.WorkException;

public class OrderServiceImpl implements OrderService{
	private OrderFile orderFile=new OrderFile();
	@Override
	public void buyProducts(Order o) throws WorkException {
		orderFile.add(o);
	}

	@Override
	public List<Order> list() throws WorkException {
		return orderFile.list();
	}

	@Override
	public Order findById(int orderId) throws WorkException {
		return orderFile.findByOrderId(orderId);
	}

}
