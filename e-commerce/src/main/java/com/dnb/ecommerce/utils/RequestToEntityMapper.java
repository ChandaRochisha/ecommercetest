package com.dnb.ecommerce.utils;

import org.springframework.stereotype.Component;

import com.dnb.ecommerce.dto.Product;
import com.dnb.ecommerce.payload.request.ProductRequest;

@Component
public class RequestToEntityMapper {//converting product request object to an entity model
	public Product getProductEntityObject (ProductRequest productRequest) {
		Product product = new Product();
		product.setProductName(productRequest.getProductName());
		product.setProductPrice(productRequest.getProductPrice());
		product.setProductCategory(productRequest.getProductCategory());
		product.setProductDescription(productRequest.getProductDescription());
		product.setProductExpiryDate(productRequest.getProductExpiryDate());
		return product;
		
	}
	
	
	
}
