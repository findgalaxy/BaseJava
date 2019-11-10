package com.lm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lm.utils.OrderStatusType;


public class Order implements Serializable{
	private int orderId;//订单ID
	private String createDate;//生成订单的实践
	private float sum;// 总金额
	private int userId;//属于那个用户
	private OrderStatusType status=OrderStatusType.UNPAID;//支付状态
	private List<OrderItem> orderItemList=new ArrayList<>();//订单明细
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public OrderStatusType getStatus() {
		return status;
	}
	public void setStatus(OrderStatusType status) {
		this.status = status;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
}
