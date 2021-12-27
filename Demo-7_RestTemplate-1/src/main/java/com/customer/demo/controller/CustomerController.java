package com.customer.demo.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.customer.demo.model.Customer;
import com.customer.demo.service.CustomerService;


@RestController
public class CustomerController {

	
	private final CustomerService service;
	@Autowired
	public CustomerController(CustomerService service) {
		this.service=service;
	}
	
	
	@GetMapping("/customers")
	public ResponseEntity<?> getCustomers() {
		return new ResponseEntity<>(service.getData(),HttpStatus.OK);
	}
	
	@GetMapping("/customers/{id}")
	 public ResponseEntity<?> getData1(@PathVariable int id) {
		    
		   return new ResponseEntity<>(service.getData1(id),HttpStatus.OK);
	   }
   @PostMapping("/customers")
   public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
	   service.createCustomer(customer);
	   return ResponseEntity.status(HttpStatus.CREATED).body(customer);
   }
   @PutMapping("/customers/{id}")
   public ResponseEntity<?> updateCustomer(@PathVariable int id, @RequestBody Customer customer){
	   service.updateCustomer(customer,id);
	   return new ResponseEntity<>("Customer is updated successfully",HttpStatus.OK);
   }
   @DeleteMapping("/customers/{id}")
   public ResponseEntity<?> deleteCustomer(@PathVariable int id){
	   service.deleteCustomer(id);
	   return new ResponseEntity<>("Customer is deleted successfully",HttpStatus.OK);
   }
	
}
