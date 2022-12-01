package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PassengerDetails;

public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Integer>{

}
