package com.example.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Customer;
import com.example.project.repo.CustomerRepo;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepo customerRepo;
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return customerRepo.save(customer);
		
	}
	@GetMapping("/fetch/{custId}")
	public Optional<Customer> getCustomer(@PathVariable int custId){
		return customerRepo.findById(custId);
	}
	@PutMapping("/edit")
	public Customer updateCustomer(@RequestBody Customer customer,@PathVariable Integer id)
	{
		Customer cus=customerRepo.findById(id).get();
		cus.setCustName(customer.getCustName());
		customerRepo.save(cus);
		return cus;
		
	}
	@DeleteMapping("/delete/{custId}")
	public String deleteCustomer(@PathVariable int custId){
	   customerRepo.deleteById(custId);
	   return "deleted successfully";
	}
	
	
}