package com.example.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>
{

}
