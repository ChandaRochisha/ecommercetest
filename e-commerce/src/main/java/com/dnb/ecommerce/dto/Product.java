package com.dnb.ecommerce.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.UniqueElements;

import com.dnb.ecommerce.utils.CustomProductIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode



public class Product {
	@Id//Generating unique  Custom id 
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
	@GenericGenerator(name="product_seq",strategy="com.dnb.ecommerce.utils.CustomProductIdGenerator",
	parameters= {
		@Parameter(name=CustomProductIdGenerator.INCREMENT_PARAM, value = "1" ),
		@Parameter(name=CustomProductIdGenerator.VALUE_PREFIX_PARAMETER, value="Pro_"),
		@Parameter(name=CustomProductIdGenerator.NUMBER_FORMAT_PARAMETER,value="%04d")			
	}
					)
	
  //fields
	private String productId;

	@Column(unique=true)
	@NotBlank(message = "enter account holder name")
	private String productName;
	
	@Min(value = 0, message = "Value should not be negative")
	
	private float productPrice;
	
	private LocalDate productExpiryDate;
	
	private String productCategory;
	
	@NotBlank(message = " Description must be entered")
	private String productDescription;

}
