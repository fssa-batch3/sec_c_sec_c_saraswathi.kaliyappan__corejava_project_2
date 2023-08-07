package com.fssa.skwater.validator;

public interface productValidatorErros {

	String INVALID_PRODUCT_NULL = "Product cannot be null.";
	String INVALID_PRODUCTNAME_NULL = "Product name cannot be null.";
	String INVALID_PRODUCT_DESCRIPTION_NULL = "Product description cannot be null.";
	String INVALID_PRODUCT_IMAGE_URL_NULL = "product image url can't be null";	
	String INVALID_PRODUCTNAME = "Invalid product name";
	String INVALID_PRODUCT_PRICE = "Invalid product price.";
	String INVALID_PRODUCT_IMAGE_URL = "Invalid product image url.";
	String INVALID_PRODUCT_CAPACITY =  "Product capacity cannot be null.";
	String INVALID_PRODUCT_DESCRIPTION = "Invalid product description";	
	String PRODUCT_PRICE_FAIL_MSG = "Invalid productprice fail message";
	String PRODUCT_IMAGE_URL_FAIL_MSG = "Invalid product image url fail message";
	Object INVALID_PRODUCT_NAME = "Invalid product name";
}

