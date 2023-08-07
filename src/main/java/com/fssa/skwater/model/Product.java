package com.fssa.skwater.model;

import java.time.LocalDate;

/**
 * 
 * Modal object for representing in the product
 *
 */


class Product {
	private int productId;             //The unique ID of the product
	private String productName;        //The name of the product
	private String productDescription; //A brief description of the product
	private double productPrice;       //The price of the product
	private String productImage;       //The URL of the product image
	private int productCapacity;       //The capacity of the product
	
	
  //Constructor to create a new Product instance.
	public Product(int productId, String productName, String productDescription, double productPrice,
			String productImage, int productCapacity, LocalDate productManufactureDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productCapacity = productCapacity;
	}
	
	//Getter and setter methods for the attributes....
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getProductCapacity() {
		return productCapacity;
	}

	public void setProductCapacity(int productCapacity) {
		this.productCapacity = productCapacity;
	}

}