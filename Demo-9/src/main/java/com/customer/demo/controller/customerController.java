package com.customer.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.demo.model.Customer;
import com.customer.demo.repository.customerRepository;

@RestController
public class customerController {
	@Autowired
	public customerRepository repository;
    
	@PostMapping("/addCustomer")
	public String saveCustomer(@RequestBody Customer customer) {
	       repository.save(customer);	
	       return "Added customer :" + customer.getId();
	}
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return repository.findAll();
	}
	@GetMapping("/customers/{id}")
	public Optional<Customer> getCustomer(@PathVariable int id){
		return repository.findById(id);
	}
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
	       repository.deleteById(id);
	       return "Customer deleted:"+id;
	}
	
}
