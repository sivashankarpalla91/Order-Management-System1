package com.practice.demo.service;

import java.util.List;

import com.practice.demo.model.Order;

public interface OrderService {
	public List<Order> getAllOrders();
	public Order saveOrder(Order order);
	public Order getOrderById(int orderId);
	public Order updateOrderAmount(int orderId,double orderAmount);
	public Order orderToSaleChannel(int orderId,int saleId);

}
