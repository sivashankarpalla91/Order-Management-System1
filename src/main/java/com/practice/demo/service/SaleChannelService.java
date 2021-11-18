package com.practice.demo.service;

import java.util.List;

import com.practice.demo.model.SaleChannel;


public interface SaleChannelService {
	public List<SaleChannel>getAllSaleChannel();
	public SaleChannel saveSaleChannel(SaleChannel SaleChannel);
	public SaleChannel findSaleChannelById(int id);

}
