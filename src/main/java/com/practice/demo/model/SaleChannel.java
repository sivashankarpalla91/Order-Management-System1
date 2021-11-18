package com.practice.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="sale_channel")
public class SaleChannel implements  Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int saleId;
	
	
	private String saleName;
	
	  @OneToMany(cascade = CascadeType.ALL,mappedBy="saleChannel")
	  @JsonManagedReference
      private List<Order> orders;

	public SaleChannel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleChannel(int saleId, String saleName, List<Order> orders) {
		super();
		this.saleId = saleId;
		this.saleName = saleName;
		this.orders = orders;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}



	
	
	

}
