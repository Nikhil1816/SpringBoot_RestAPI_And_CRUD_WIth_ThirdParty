package com.customer.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customer.demo.model.Customer;

public interface customerRepository extends MongoRepository<Customer,Integer>{

}
