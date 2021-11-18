package com.practice.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.model.Order;
import com.practice.demo.service.OrderService;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/orders")
    public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/orders/{id}")
    public Order getOrderByID(@PathVariable("id") Integer orderId,  @RequestBody Order order){
		return orderService.getOrderById(orderId);
	}

	@PostMapping("/orders")
    public Order addOrder( @RequestBody Order order){
		return orderService.saveOrder(order);
	}
	
	@PutMapping("/orders/{id}/{amount}")
	public Order updateOrder(@PathVariable (value="id") int orderId , @PathVariable (value="amount") Double orderAmount,@RequestBody Order order) {
	
		return orderService.updateOrderAmount(orderId, orderAmount);
	}
	
	
	@PutMapping("orders/{orderId}/sales/{saleId}")
	public Order assignOrderToSaleChannel(
			@PathVariable int orderId,
			@PathVariable int saleId
			) {
	
		return orderService.orderToSaleChannel(orderId, saleId);
		
	}
	
	
	

}
