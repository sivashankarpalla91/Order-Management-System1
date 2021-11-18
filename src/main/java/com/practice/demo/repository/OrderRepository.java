package com.practice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
