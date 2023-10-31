package com.example.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.Product;
import com.example.product.repo.ProductRepo;

@RestController
@RequestMapping("/ravali")
public class ProductController {
	@Autowired
	ProductRepo productRepo;

	@PostMapping("/save")
	public Product addProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@GetMapping("/fetch/{proId}")
	
	public Optional<Product> getProduct(@PathVariable int proId) {
		return productRepo.findById(proId);
	}

	@GetMapping("/fetch")
	
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@PutMapping("/edit/{proId}")
	
	public Product updateProduct(@PathVariable Integer proId,@RequestBody Product product) {
		Product pro = productRepo.findById(proId).get();
		pro.setProName(product.getProName());
		
		productRepo.save(pro);
		return pro;

	}

	@DeleteMapping("/delete/{proId}")
	
	public String deleteProduct(@PathVariable int proId)
	{
		productRepo.deleteById(proId);
		return "deleted successfully";
	}
	
	
	

}
