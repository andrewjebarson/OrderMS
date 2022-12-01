
package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.exception.UserDefinedException;
import com.example.demo.model.ErrorPage;
import com.example.demo.model.Orders;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.PassengerDetailsRepository;
import com.example.demo.service.EmailSenderService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","*"})
public class OrderDao {

	
	@Autowired
	OrdersRepository orderRepo;
	@Autowired
	
	PassengerDetailsRepository passengerRepo;
	
	@Autowired
	EmailSenderService email;
	
	
	
	@PostMapping("saveOrder")
	public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
		
		return new ResponseEntity<Orders>(orderRepo.save(order),HttpStatus.CREATED);
	}
	
	
	@GetMapping("getOrderById/{orderId}")
	public ResponseEntity<Orders> getOrderById(@PathVariable int orderId){
		
		try {
		return new ResponseEntity<Orders>(orderRepo.findById(orderId).get(),HttpStatus.OK);
		}catch(Exception e) {
			throw new UserDefinedException("Resource Not Found");	
		}
	}
	
	@GetMapping("getOrdersByUserId/{userId}")
	public ResponseEntity<List<Orders>> getOrdersByUserId(@PathVariable int userId){
		
		try {
		return new ResponseEntity<List<Orders>>(orderRepo.findByuserId(userId),HttpStatus.OK);
		}catch(Exception e) {
			throw new UserDefinedException("Resource Not Found");
		}
	}
	
	@GetMapping("getOrdersByStatus/{status}")
	public ResponseEntity<List<Orders>> getOrdersByStatus(@PathVariable String status){
		
		try {
		return new ResponseEntity<List<Orders>>(orderRepo.findBystatus(status),HttpStatus.OK);
		}catch(Exception e) {
			throw new UserDefinedException("Resource Not Found");	
		}
	}
	
	@GetMapping("getOrdersByTravelDate/{date}")
	public ResponseEntity<List<Orders>> getOrdersByTravelDate(@PathVariable Date date){
		
		try {
		return new ResponseEntity<List<Orders>>(orderRepo.findBytravelDate(date),HttpStatus.OK);
		}catch(Exception e) {
			throw new UserDefinedException("Resource Not Found");
		}
	}
	
	
	
	@GetMapping("sendOrder/{to}/{orderId}/{totalFare}")
	public ResponseEntity sendOrder(@PathVariable String to,@PathVariable int orderId,@PathVariable int totalFare) {
		try{
		email.sendTicket(to, orderId, totalFare);
			return new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);	}
	}
	
	@ExceptionHandler(UserDefinedException.class)
	public ResponseEntity existUser(Exception e) {
		ErrorPage er=new ErrorPage();
		er.setErCode(HttpStatus.NOT_FOUND.toString());
		er.setErMsg(e.getMessage());
		return new ResponseEntity(er,HttpStatus.NOT_FOUND);
	}

	
	
}
