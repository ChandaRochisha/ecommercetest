package com.dnb.ecommerce.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.ecommerce.dto.Product;
import com.dnb.ecommerce.exceptions.IdNotFoundException;
import com.dnb.ecommerce.exceptions.ProductNotFoundException;
import com.dnb.ecommerce.exceptions.UniqueProductNameException;
import com.dnb.ecommerce.payload.request.ProductRequest;
import com.dnb.ecommerce.service.ProductService;
import com.dnb.ecommerce.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
//CRUD operations on Product table
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	RequestToEntityMapper mapper;
	
	@DeleteMapping("/{productId}")//delete row by productId
	public ResponseEntity<?> deleteProductById
	(@PathVariable("productId")String productId)throws ProductNotFoundException{
		
		boolean b = productService.checkExistenceBy(productId);
		if(b)
		{
			productService.deleteProduct(productId);
			return ResponseEntity.noContent().build();
		}else
		{
			throw new ProductNotFoundException("provide correct account id to delete it");
		}
	}
	
	
	
	
	
	@PostMapping("/create")//creating the table by using the product request object
	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest product ) throws ProductNotFoundException 
	{ 
	   Product product1 = mapper.getProductEntityObject(product);
	   Product product2 = productService.createProduct(product1);
return new ResponseEntity(product2,HttpStatus.CREATED);
	}
	
	
	
	
	
	@GetMapping("/{productId}")//It should help us to get the specific account details	
	public ResponseEntity<?> getProductById
	(@PathVariable("productId") String productId)throws IdNotFoundException{
		Optional<Product> optional = productService.getProductById(productId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			
			throw new IdNotFoundException("enter correct product id");
		}
	}
			
	@GetMapping("/allProducts")//helps us to get all product details

	public ResponseEntity<?> getAllProducts() throws IdNotFoundException, ProductNotFoundException {

 

		List<Product> list = (List<Product>) productService.getAllProducts();

		if (list.size() > 0)

			return ResponseEntity.ok(list);

		else

			throw new ProductNotFoundException("No details");

	}		

	
	
  @PutMapping("/update/{productId}")// helps us to update specific product detail by using its id
  public ResponseEntity<?>  productUpdate (@Valid @RequestBody ProductRequest product ,
		  @PathVariable("productId") String productId)throws IdNotFoundException, 
  ProductNotFoundException, UniqueProductNameException{
	  Optional<Product> productOptional = productService.getProductById(productId);

	 if (productOptional.isPresent()) {
	  Product product1 = mapper.getProductEntityObject(product);
	  Product product2= productService.updateProductDetails(product1, productId);
	 }
	return null;
	  
		
		
	
		
  }

	
	
	
}	


