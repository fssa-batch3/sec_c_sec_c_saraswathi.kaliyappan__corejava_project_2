package com.fssa.skwater.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// validation for Product object
public class ProductValidator {
	public static <Product> boolean validate(Product product) throws IllegalArgumentException {
		if (product == null) {
			throw new IllegalArgumentException(productValidatorErros.INVALID_PRODUCT_NULL);
		}
		return true;
	}
	// product name validation
	public static boolean productNameValidator(String productName) throws IllegalArgumentException {
		if (productName == null || "".equals(productName.trim())) {
			throw new IllegalArgumentException(productValidatorErros.INVALID_PRODUCTNAME_NULL);
		}
// regex pattern for product name
		String nameregex = "^[a-zA-Z]{2,15}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productName);
		Boolean isMatch = matcher.matches();
		if (!isMatch) {
			throw new IllegalArgumentException(productValidatorErros.INVALID_PRODUCTNAME);
		}
		return true;
	}
	// product description validation
	public static boolean productDescriptionValidator(String productDescription) throws IllegalArgumentException {
		if (productDescription == null || "".equals(productDescription.trim())) {
			throw new IllegalArgumentException(productValidatorErros.INVALID_PRODUCT_DESCRIPTION_NULL);
		}
		// regex pattern for product description
		String descregex = "^.{10,100}$";
		Pattern pattern = Pattern.compile(descregex);
		Matcher matcher = pattern.matcher(productDescription);
		boolean isMatch = matcher.matches();
		if (isMatch) {
			return true;
		} else {
			throw new IllegalArgumentException(productValidatorErros.INVALID_PRODUCT_DESCRIPTION);
		}
	}
	// product price validation
	public static boolean productPriceValidator(double productPrice) throws IllegalArgumentException {
		if (productPrice < 500) {
			throw new IllegalArgumentException(productValidatorErros.INVALID_PRODUCT_PRICE);
		}
		return true;
	}
	// product image url validation
	public static boolean productImageURLValidator(String productImageURL) throws IllegalArgumentException {
		if (productImageURL == null) {
			throw new IllegalArgumentException(productValidatorErros.INVALID_PRODUCT_IMAGE_URL_NULL);
		}
		// regex pattern to match url
		String imageurlregex = "(?i)\\b((https?|ftp)://)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?\\.(jpg|jpeg|gif|png|bmp)\\b";
		Pattern pattern = Pattern.compile(imageurlregex);
		Matcher matcher = pattern.matcher(productImageURL);
		boolean isMatch = matcher.matches();
		if (!isMatch) {
			throw new IllegalArgumentException(productValidatorErros.INVALID_PRODUCT_IMAGE_URL);
		}
		return true; // Return true if the URL is valid
	}

	//product capacity validation
	
	public static  boolean productCapacityValidator(int productCapacity) throws IllegalArgumentException{
		if(productCapacity >=1) {
			throw new IllegalArgumentException(productValidatorErros.INVALID_PRODUCT_CAPACITY);
		}
		return true;
	}
	

	
}