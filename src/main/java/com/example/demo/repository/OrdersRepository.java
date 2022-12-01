package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	
	
	public List<Orders> findByuserId(int userId);
	public List<Orders> findBytravelDate(Date date);
	public List<Orders> findBystatus(String status);

}
