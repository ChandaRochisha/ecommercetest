package com.dnb.ecommerce.exceptions;
//custom exception
public class UniqueProductNameException extends Exception{
	public UniqueProductNameException(String msg)
	{
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}
}
