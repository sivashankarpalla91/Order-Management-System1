package com.practice.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.demo.exception.ResourceNotFoundException;
import com.practice.demo.model.Order;
import com.practice.demo.model.SaleChannel;
import com.practice.demo.repository.OrderRepository;
import com.practice.demo.repository.SaleChannelRepository;
import com.practice.demo.service.OrderService;

@Component
public class OrderServiceImpl  implements OrderService{

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	SaleChannelRepository saleChannelRepository;
	
	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order getOrderById(int orderId) {
		return orderRepo.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order","id",orderId));
	}

	@Override
	public Order orderToSaleChannel(int orderId, int saleId) {
		Order order= orderRepo.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order","id",orderId));
		SaleChannel sale = saleChannelRepository.findById(saleId).orElseThrow(()->new ResourceNotFoundException("SaleChannel","id",saleId));
		order.setSaleChannel(sale);
		return orderRepo.save(order);
	}

	@Override
	public Order updateOrderAmount(int orderId, double orderAmount) {
	Order order = orderRepo.findById(orderId).orElseThrow(() -> new com.practice.demo.exception.ResourceNotFoundException("Order", "id", orderId));
		
		order.setOrderAmount(orderAmount);
		
		
		Order updatedOrder = orderRepo.save(order);
		return updatedOrder;
		
	}

}
