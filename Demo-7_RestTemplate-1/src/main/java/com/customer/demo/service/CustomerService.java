package com.customer.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.demo.model.Customer;
@Service
public class CustomerService {

	private final RestTemplate restTemplate;
	@Autowired
	public CustomerService(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	public List<?> getData() {
		HttpHeaders headers =new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Customer> entity=new HttpEntity<Customer>(headers);
		ResponseEntity<List> customer=restTemplate.exchange("http://localHost:8080/customers",  HttpMethod.GET, entity, List.class);
		return customer.getBody();
	}
	public Customer getData1(int id) {
		HttpHeaders headers =new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Customer> entity=new HttpEntity<Customer>(headers);
		ResponseEntity<Customer> customer=restTemplate.exchange("http://localHost:8080/customers/"+id,  HttpMethod.GET, entity, Customer.class);
		return customer.getBody();
	}
	public Customer createCustomer(Customer customer) {
		HttpHeaders headers =new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Customer> entity=new HttpEntity<Customer>(customer, headers);
		ResponseEntity<Customer> responseEntity=restTemplate.exchange("http://localHost:8080/customers",  HttpMethod.POST, entity, Customer.class);
		return responseEntity.getBody();
	}

	public Customer updateCustomer(Customer customer,int id) {
		HttpHeaders headers =new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Customer> entity=new HttpEntity<Customer>(customer, headers);
		ResponseEntity<Customer> responseEntity=restTemplate.exchange("http://localHost:8080/customers/"+id,  HttpMethod.PUT, entity, Customer.class);
		return responseEntity.getBody();
	}

	public Customer deleteCustomer(int id) {
		HttpHeaders headers =new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Customer> entity=new HttpEntity<Customer>( headers);
		ResponseEntity<Customer> responseEntity=restTemplate.exchange("http://localHost:8080/customers/"+id,  HttpMethod.DELETE, entity, Customer.class);
		return responseEntity.getBody();
	}

	
}
