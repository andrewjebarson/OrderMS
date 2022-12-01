package com.example.demo;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Orders;
import com.example.demo.model.PassengerDetails;
import com.example.demo.repository.OrdersRepository;

@SpringBootApplication

@EnableEurekaClient
public class OrdersMsApplication implements CommandLineRunner {

	
	@Autowired
	OrdersRepository orderRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(OrdersMsApplication.class, args);
	}
	
	
	@Bean
	public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) { 
	EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils); 
	String ip = null; 
	try { 
	ip = InetAddress.getLocalHost().getHostAddress(); 
	} catch (Exception e) { 
	System.out.println("Exception"); 
	} 
	config.setNonSecurePort(8084); 
	config.setIpAddress(ip); 
	config.setPreferIpAddress(true); 
	return config; 
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Orders o=new Orders();
		o.setDestinationPlace("kerala");
		o.setNoOfSeats(2);
		o.setOrderDate(new Date());
		o.setSourcePlace("Chennai");
		o.setStatus("Pending");
		o.setTotalFare(1000);
		o.setTravelDate(new Date(2022-1900,11,3,17,30));
		o.setUserId(100);
		o.setVechileId(123455);
		o.setCategory("3AC");
		o.setVechileName("cheran express");

		PassengerDetails p=new PassengerDetails();
		p.setAadhaarNo("987654321");
		p.setAge(18);
		p.setPassengerName("Andrew");
		p.setSeatNo(20);
		//p.setOrders(o);
		p.setSeatStatus("CNF");
		
		PassengerDetails p1=new PassengerDetails();
		p1.setAadhaarNo("123456789");
		p1.setAge(29);
		p1.setPassengerName("ABCD");
		p1.setSeatNo(67);
		//p1.setOrders(o);
		p1.setSeatStatus("WL");
		
		o.setPassengerDetails(Arrays.asList(p,p1));
		
	//orderRepo.save(o);
	
	
	
	Orders o1=new Orders();
	o1.setDestinationPlace("madurai");
	o1.setNoOfSeats(2);
	o1.setOrderDate(new Date());
	o1.setSourcePlace("Kerala");
	o1.setStatus("Booked");
	o1.setTotalFare(1000);
	o1.setTravelDate(new Date(2022-1900,11,3,17,30));
	o1.setUserId(100);
	o1.setVechileId(123455);
	o1.setCategory("2AC");
	o1.setVechileName("cheran express");

	PassengerDetails pp=new PassengerDetails();
	pp.setAadhaarNo("9976543210");
	pp.setAge(18);
	pp.setPassengerName("Indhu");
	pp.setSeatNo(20);
	//p.setOrders(o);
	pp.setSeatStatus("CNF");
	
	PassengerDetails p2=new PassengerDetails();
	p2.setAadhaarNo("123456789");
	p2.setAge(29);
	p2.setPassengerName("ABCD");
	p2.setSeatNo(67);
	//p1.setOrders(o);
	p2.setSeatStatus("WL");
	
	o.setPassengerDetails(Arrays.asList(pp,p2));
	
//orderRepo.save(o1);
	
	
//		
		
		
		
		
	}
	
	
	

}
