package com.dnb.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.ecommerce.dto.Product;
import com.dnb.ecommerce.exceptions.IdNotFoundException;
import com.dnb.ecommerce.exceptions.ProductNotFoundException;
import com.dnb.ecommerce.exceptions.UniqueProductNameException;
import com.dnb.ecommerce.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override

	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> getProductById(String productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public boolean deleteProduct(String productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		if (productRepository.existsById(productId) == true) {
			productRepository.deleteById(productId);
			return true;

		} else {
			throw new ProductNotFoundException(" Product not found");

		}
	}

	@Override
	public Product updateProductDetails(Product product, String productId)
			throws ProductNotFoundException, UniqueProductNameException {
		// TODO Auto-generated method stub
		if (productRepository.existsById(productId)) {
			if (productRepository.existsByProductName(product.getProductName())) {
				Optional<Product> product1 = productRepository.findById(productId);
				String name = product1.get().getProductName();
				if (name.equals(product.getProductName())) {
					throw new UniqueProductNameException("Name must be unique");

				} else {
					throw new UniqueProductNameException("name is not unique");
				}
			} else {
				product.setProductId(productId);
				return productRepository.save(product);
			}
		} else {

			throw new ProductNotFoundException("prouct is not found to update it");

		}
	}

	@Override
	public boolean checkExistenceBy(String productId) {
		if (productRepository.existsById(productId) == true) {
			return true;

		} else {
			return false;
		}
	}

}
