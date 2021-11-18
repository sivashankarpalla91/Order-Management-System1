package com.practice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.SaleChannel;

@Repository
public interface SaleChannelRepository extends JpaRepository<SaleChannel,Integer>{

}
