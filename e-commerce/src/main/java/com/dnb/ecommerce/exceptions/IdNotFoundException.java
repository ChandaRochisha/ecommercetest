package com.dnb.ecommerce.exceptions;
//custom ID not  found exception
public class IdNotFoundException extends Exception{
	public IdNotFoundException(String msg)
	{
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}