package com.dnb.ecommerce.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.ecommerce.dto.Product;
//Code which gets interacted with the database
@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
//implements CRUD repository

	public Optional<Product> findByProductName(String ProductName);
	public boolean existsByProductName(String productName);
	
	  
}
