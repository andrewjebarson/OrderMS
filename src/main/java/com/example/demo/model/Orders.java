package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data

public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="orderId_gen")
	@SequenceGenerator(name="orderId_gen",sequenceName="order_seq_gen",initialValue=92345)
	private int orderId;
	private int vechileId;
	private String vechileName;
	private int userId;
	private int noOfSeats;
	@OneToMany(cascade = CascadeType.ALL)
	private List<PassengerDetails> passengerDetails;
	private String sourcePlace;
	private String destinationPlace;
	private int totalFare;
	private String status;
	private Date orderDate;
	private Date travelDate;
	private String category;

	
	

}
