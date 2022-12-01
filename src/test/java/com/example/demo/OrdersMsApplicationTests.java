package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Orders;
import com.example.demo.model.PassengerDetails;
import com.example.demo.repository.OrdersRepository;

@SpringBootTest
class OrdersMsApplicationTests {

	@Autowired
	OrdersRepository orderrepo;
	
	
//	@Test
	public void testCreate() {
		Orders o=new Orders();
		o.setDestinationPlace("KanyaKumari");
		o.setNoOfSeats(2);
		o.setOrderDate(new Date());
		o.setSourcePlace("Chennai");
		o.setStatus("Pending");
		o.setTotalFare(1000);
		o.setTravelDate(new Date(2022-1900,11,23,17,30));
		o.setUserId(100);
		o.setVechileId(12876);
		o.setCategory("3AC");

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
		orderrepo.save(o);
		assertNotNull(orderrepo.findById(92345).get());
	}
//@Test
public void testReadAll() {
	List<Orders> list=orderrepo.findAll();
	assertThat(list).size().isGreaterThan(0);
}

}
