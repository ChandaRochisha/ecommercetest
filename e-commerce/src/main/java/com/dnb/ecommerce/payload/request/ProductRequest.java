package com.dnb.ecommerce.payload.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data

public class ProductRequest {
//Other than auto generated fields	
	private String productName;

	private float productPrice;
	private LocalDate productExpiryDate;
    private String productCategory;
    private String productDescription;

	
}
