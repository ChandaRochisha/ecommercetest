package com.dnb.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnb.ecommerce.dto.Product;
import com.dnb.ecommerce.exceptions.IdNotFoundException;
import com.dnb.ecommerce.exceptions.ProductNotFoundException;
import com.dnb.ecommerce.exceptions.UniqueProductNameException;

@Service
public interface ProductService {

	public   Product createProduct(Product product) ;
	// TODO Auto-generated method stub

public Optional<Product> getProductById(String productId);
public List<Product> getAllProducts();

public boolean deleteProduct(String productId) throws ProductNotFoundException;

public boolean checkExistenceBy(String productId) ;

public Product updateProductDetails(Product product, String productId) throws ProductNotFoundException, UniqueProductNameException;


}
