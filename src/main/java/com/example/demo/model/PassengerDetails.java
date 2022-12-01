package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
public class PassengerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dId;
	private int seatNo;
	private String passengerName;
	private int age;
	private String aadhaarNo;
	private String seatStatus;
	
//	@ManyToOne
//	@JoinColumn(name = "orders")
//	@JsonIgnoreProperties("passengerDetails")
//	private Orders orders;
}
