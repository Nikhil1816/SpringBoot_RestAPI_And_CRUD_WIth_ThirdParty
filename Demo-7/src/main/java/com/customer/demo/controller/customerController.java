package com.customer.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.demo.beans.customerWrapper;
import com.customer.demo.exception.RecordNotFoundException;
import com.customer.demo.model.Customer;
import com.customer.demo.repository.customerRepository;
import com.customer.demo.service.customerService;

@Controller
public class customerController {
	@Autowired
	public customerService ser;
    
	@PostMapping("/addCustomer")
	public ResponseEntity<customerWrapper> saveCustomer(@RequestBody customerWrapper customerwrapper){
	    customerwrapper = ser.saveCustomer(customerwrapper);  
		return ResponseEntity.ok(customerwrapper);
		
	}
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> findAllProducts(){
		return ResponseEntity.ok(ser.getAll());
	}
   
	@GetMapping("/customer/{id}")
	public ResponseEntity<customerWrapper> getCustomerById(@PathVariable int id) throws RecordNotFoundException{
		customerWrapper customerwrapper=ser.getCustomerById(id);
		return ResponseEntity.ok(customerwrapper);
	}
	@PutMapping("/updateCustomer")
	public ResponseEntity<customerWrapper> updateCustomer(@RequestBody customerWrapper customerwrapper) throws RecordNotFoundException{
		 customerwrapper=ser.updateCustomerDetails(customerwrapper);
		return ResponseEntity.ok(customerwrapper);
	}
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<customerWrapper> deleteCustomerById(@PathVariable int id) throws RecordNotFoundException{
		ser.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
