package com.fssa.skwater.model;

import java.time.LocalDate;

/**
 * 
 *A model object representing a product.
 *ZA	
 */


public class Product {
	    private int productId;                                //The unique ID of the product
	    private String productName;                          //The name of the product
	    private String productDescription;                  //A brief description of the product
	    private double productPrice;                       //The price of the product
	    private String productImageURL;                   //The URL of the product imageUrl
	    private int productCapacity;                     //The capacity of the product
	    private LocalDate productManufactureDate;       //The manufacture date for product past date
	    
	    
	
	    /**
	     * Constructor to create a new Product instance.
	     *
	     * @param productId            The unique ID of the product.
	     * @param productName          The name of the product.
	     * @param productDescription   A brief description of the product.
	     * @param productPrice         The price of the product.
	     * @param productImageURL      The URL of the product image.
	     * @param productCapacity      The capacity of the product.
	     * @param productManufactureDate The manufacture date of the product.
	     */
	    public Product(int productId, String productName, String productDescription, double productPrice,
			   String productImageURL, int productCapacity, LocalDate productManufactureDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImageURL = productImageURL;
		this.productCapacity = productCapacity;
		this.productManufactureDate = productManufactureDate;
	}
	
	//Getter and setter methods for the attributes....
	//Getter for the product Id
	   
	public int getProductId() {
		return productId;
	}

	//Setter for the product Id
	public void setProductId(int productId) {
		this.productId = productId;
	}
 
    // Getter for productName
	public String getProductName() {
		return productName;
	}

    // Setter for productName
	public void setProductName(String productName) {
		this.productName = productName;
	}

    // Getter for productDescription
	public String getProductDescription() {
		return productDescription;
	}

    // Setter for productDescription
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

    // Getter for productPrice
	public double getProductPrice() {
		return productPrice;
	}

    // Setter for productPrice
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

    // Getter for productImageURL
	public String getProductImageUrl() {
		return productImageURL;
	}

    // Setter for productImageURL
	public void setProductImage(String productImageURL) {
		this.productImageURL = productImageURL;
	}

    // Getter for productCapacity
	public int getProductCapacity() {
		return productCapacity;
	}
	
    // Setter for productCapacity
	public void setProductCapacity(int productCapacity) {
		this.productCapacity = productCapacity;
	}
	
    // Getter for productManufactureDate
	public LocalDate getProductManufactureDate() {
		return productManufactureDate;
	}
	
    // Setter for productManufactureDate
	public void setproductManufactureDate(LocalDate productManufactureDate) {
		this.productManufactureDate = productManufactureDate;
	}

}