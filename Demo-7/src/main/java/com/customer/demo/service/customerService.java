package com.customer.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.demo.beans.customerWrapper;
import com.customer.demo.exception.RecordNotFoundException;
import com.customer.demo.model.Customer;
import com.customer.demo.repository.customerRepository;

@Service
public class customerService {

	@Autowired
	private customerRepository repository;
	
	public customerWrapper saveCustomer(customerWrapper inputCustomer) {
		Customer customer=new Customer();
		customer.setId(inputCustomer.getId());
		customer.setEmail(inputCustomer.getEmail());
		customer.setAge(inputCustomer.getAge());
		
		customer= repository.save(customer);
		inputCustomer.setId(customer.getId());
		inputCustomer.setEmail(customer.getEmail());
		inputCustomer.setAge(customer.getAge());
		return inputCustomer;
	}
	public customerWrapper getCustomerById(int id) throws RecordNotFoundException{
		customerWrapper customerwrapper = null;
		Optional<Customer> customerData=repository.findById(id);
		if(customerData.isPresent()) {
			customerwrapper =new customerWrapper();
			Customer customer=customerData.get();
			customerwrapper.setId(customer.getId());
			customerwrapper.setEmail(customer.getEmail());
			customerwrapper.setAge(customer.getAge());
			
		}else {
			throw new RecordNotFoundException("Customer record not found");
		}
		return customerwrapper;
	}
	public customerWrapper updateCustomerDetails(customerWrapper inputCustomer) throws RecordNotFoundException{
		Optional<Customer> customerData=repository.findById(inputCustomer.getId());
		if(customerData.isPresent()) {
			customerWrapper customerwrapper=new customerWrapper();
			Customer customer=customerData.get();
			customer.setEmail(inputCustomer.getEmail());
			customer.setAge(inputCustomer.getAge());	
			repository.save(customer);
			customerwrapper.setId(customer.getId());
			customerwrapper.setEmail(customer.getEmail());
			customerwrapper.setAge(customer.getAge());
			return customerwrapper;
		}else {
			throw new RecordNotFoundException("Customer record not found");
		}
	
	}
	public String deleteById(int id) throws RecordNotFoundException{
		Optional<Customer> customerData=repository.findById(id);
		if(customerData.isPresent()) {
			Customer customer=customerData.get();
			repository.delete(customer);
			return "Deleted";
		}else {
			throw new RecordNotFoundException("Customer record not found");
		}
	}
	public List<Customer> getAll(){
		return  repository.findAll();
     	
	}
	
}
