package com.practice.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.demo.exception.ResourceNotFoundException;
import com.practice.demo.model.SaleChannel;
import com.practice.demo.repository.SaleChannelRepository;
import com.practice.demo.service.SaleChannelService;

@Component
public class SaleChannelServiceImpl implements SaleChannelService {

	@Autowired
     SaleChannelRepository saleChannelRepository;
	
	@Override
	public List<SaleChannel> getAllSaleChannel() {
		
		return saleChannelRepository.findAll();
	}

	@Override
	public SaleChannel saveSaleChannel(SaleChannel customer) {

		return saleChannelRepository.save(customer);
	}

	@Override
	public SaleChannel findSaleChannelById(int saleId) {
		return saleChannelRepository.findById(saleId).orElseThrow(()->new ResourceNotFoundException("SaleChannel","id",saleId));
	}

	

}
