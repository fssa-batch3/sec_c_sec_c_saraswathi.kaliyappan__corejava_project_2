package com.fssa.skwater.validator;

/**
 * A utility class containing error messages for product validation.
 */
public class productValidatorErrors {

    // Error messages for various validation checks
	
    // Error message for null object
    public static final String INVALID_PRODUCT_NULL = "Object cannot be null."; 
    
    // Error message for null product ID
    public static final String INVALID_PRODUT_ID = "ID cannot be null.";
    
    // Error message for invalid product name length
    public static final String INVALID_PRODUCTNAME = "The name should be between 10 and 100 characters."; 
    
    // Error message for null product name   
    public static final String INVALID_PRODUCTNAME_NULL = "Product name cannot be null."; 
    
    // Error message for null product image URL 
    public static final String INVALID_PRODUCTIMAGE_NULL = "Product image cannot be null."; 
    
    // Error message for invalid product image URL
    public static final String INVALID_PRODUCTIMAGE = "Invalid product image URL."; 
    
    // Error message for invalid product price
    public static final String INVALID_PRODUCT_PRICE = "The product price should be between 10 and 500 rupees.";
    
    // Error message for null product description
    public static final String INVALID_PRODUCT_DESCRIPTION_NULL = "Product description cannot be null.";
    
     // Error message for invalid product description
    public static final String INVALID_PRODUCT_DESCRIPTION = "Invalid product description."; 
    
    // Error message for invalid product capacity
    public static final String INVALID_PRODUCT_CAPACITY = "Invalid product capacity.";
    
    // Error message for null manufacture date
    public static final String INVALID_MANUFACTUREDATE_NULL = "ManufactureDate can't be null";
    
    // Error message for invalid manufacture date pattern    
	public static final String INVALID_MANUFACTUREDATE_PATTERN = "ManufactureDate can't be null";
    
    // Additional fail messages (possibly not used)
    
    // Fail message for invalid product price
    public static final String PRODUCT_PRICE_FAIL_MSG = "Invalid product price fail message."; 
    
    // Fail message for invalid product image URL
    public static final String PRODUCT_IMAGE_URL_FAIL_MSG = "Invalid product image URL fail message."; 
    
    // Fail message for invalid product name
    public static final Object INVALID_PRODUCT_NAME = "Invalid product name.";
    
    // Fail message for invalid product image URL
    public static final String INVALID_PRODUCT_IMAGE_URL = "Invalid product image URL.";

	

	public static final String INVALID_PRODUCTID = "product id is invalid";

	public static final String CANNOT_ADD_PRODUCT = "you can't add product"; 
}
