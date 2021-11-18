package com.practice.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.model.SaleChannel;
import com.practice.demo.service.SaleChannelService;

@RestController
@RequestMapping("/api/v1")
public class SaleChannelController {
	
	@Autowired
	SaleChannelService saleChannelService;
	
	@GetMapping("/sales")
    public List<SaleChannel> getAllCustomers(){
		return saleChannelService.getAllSaleChannel();
	}

	@PostMapping("/sales")
    public SaleChannel addCustomer( @RequestBody SaleChannel saleChannel){
		return saleChannelService.saveSaleChannel(saleChannel);
	}
	
	@GetMapping("/sales/{id}")
    public SaleChannel getCustomerById(@PathVariable(value="id")  int saleId){
		return saleChannelService.findSaleChannelById(saleId);
	}
//	
//	
//	@DeleteMapping("/customers/{id}")
//	public String deleteCustomerById(@PathVariable(value="id") int custId){
//		
//		Customer cust = custRepo.findById(custId).orElseThrow(()->new ResourceNotFoundException("Customer","id",custId));
//		
//		custRepo.delete(cust);
//		
//		return "Customer with "+custId+" is deleted successfully";
//	}
	
	
//	@PutMapping("/customers/{id}")
//	public Customer updateCustomer(@PathVariable (value="id") int custId , @RequestBody Customer customer) {
//		Customer cust = custRepo.findById(custId).orElseThrow(() -> new com.practice.demo.exception.ResourceNotFoundException("Customer", "id", custId));
//		
//		cust.setCustName(customer.getCustName());
//		cust.setCustAge(customer.getCustAge());
//		cust.setOrders(customer.getOrders());
//		
//		Customer updatedCust = custRepo.save(cust);
//		return updatedCust;
//	}
	
	
}
