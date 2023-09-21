package com.dnb.ecommerce.exceptions;
//custom exception
public class ProductNotFoundException extends Exception{
	public ProductNotFoundException(String msg)
	{
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}
}
