package com.practice.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sale_order")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"orderedDate"},allowGetters=true)
public class Order  implements  Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderID;

	private String orderName;

	private double orderAmount;

	 @Column(nullable=false,updatable=false)
	 @Temporal(TemporalType.TIMESTAMP)
	 @CreatedDate
	private Date orderedDate;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "sale_id" , referencedColumnName="saleId")
	 @JsonBackReference
	private SaleChannel saleChannel;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderID, String orderName, double orderAmount, Date orderedDate, SaleChannel saleChannel) {
		super();
		this.orderID = orderID;
		this.orderName = orderName;
		this.orderAmount = orderAmount;
		this.orderedDate = orderedDate;
		this.saleChannel = saleChannel;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public SaleChannel getSaleChannel() {
		return saleChannel;
	}

	public void setSaleChannel(SaleChannel saleChannel) {
		this.saleChannel = saleChannel;
	}
	 
	 
	 

	

}
