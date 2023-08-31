package com.fssa.skwater.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Validates the provided Product object for null
public class ProductValidator {
	

    /**
     * Validates whether the provided Product object is not null.
     *
     * @param product The Product object to validate.
     * @param <Product> The type of the Product.
     * @return True if validation passes.
     * @throws IllegalArgumentException If the provided Product is null.
     */
	public static <Product> boolean validate(Product product) throws IllegalArgumentException {
		if (product == null) {
			throw new IllegalArgumentException(productValidatorErrors.INVALID_PRODUCT_NULL);
		}
		
		
		return true;
	}
	
	
    /**
     * Validates the product ID to ensure it's greater than 0.
     *
     * @param id The product ID to validate.
     * @return True if validation passes.
     * @throws IllegalArgumentException If the product ID is less than or equal to 0.
     */
	public static boolean  validateProductId(int id)throws IllegalArgumentException{
				
		if(id <= 0) {
			throw new IllegalArgumentException(productValidatorErrors.INVALID_PRODUT_ID);
		}
		return true;
	}
	

    /**
     * Validates the product name to ensure it's not null, empty, and matches a specific pattern.
     *
     * @param productName The product name to validate.
     * @return True if validation passes.
     * @throws IllegalArgumentException If the product name is null, empty, or doesn't match the pattern.
     */	
	public static boolean productNameValidator(String productName) throws IllegalArgumentException {
		if (productName == null || "".equals(productName.trim())) {
			throw new IllegalArgumentException(productValidatorErrors.INVALID_PRODUCTNAME_NULL);
		}
		
// regex pattern for product name
		String nameregex = "^[a-zA-Z]{2,15}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productName);
		Boolean isMatch = matcher.matches();
		if (!isMatch) {
			throw new IllegalArgumentException(productValidatorErrors.INVALID_PRODUCTNAME);
		}
		return true;
	}
	
	
    /**
     * Validates the product description to ensure it's not null, empty, and within a specific length range.
     *
     * @param productDescription The product description to validate.
     * @return True if validation passes.
     * @throws IllegalArgumentException If the product description is null, empty, or doesn't match the length criteria.
     */
	public static boolean productDescriptionValidator(String productDescription) throws IllegalArgumentException {
		if (productDescription == null || "".equals(productDescription.trim())) {
			throw new IllegalArgumentException(productValidatorErrors.INVALID_PRODUCT_DESCRIPTION_NULL);
		}
		// regex pattern for product description
		String descregex = "^.{10,100}$";
		Pattern pattern = Pattern.compile(descregex);
		Matcher matcher = pattern.matcher(productDescription);
		boolean isMatch = matcher.matches();
		if (isMatch) {
			return true;
		} else {
			throw new IllegalArgumentException(productValidatorErrors.INVALID_PRODUCT_DESCRIPTION);
		}
	}
	
	
    /**
     * Validates the product price to ensure it's greater than or equal to 500.
     *
     * @param productPrice The product price to validate.
     * @return True if validation passes.
     * @throws IllegalArgumentException If the product price is less than 500.
     */
	public static boolean productPriceValidator(double productPrice) throws IllegalArgumentException {
		if (productPrice < 500) {
			throw new IllegalArgumentException(productValidatorErrors.INVALID_PRODUCT_PRICE);
		}
		return true;
	}
	
	
	   /**
     * Validates the product image URL to ensure it's not null and matches a specific pattern.
     *
     * @param string The product image URL to validate.
     * @return True if validation passes.
     * @throws IllegalArgumentException If the product image URL is null or doesn't match the pattern.
     * 
     *  Regular expression pattern for validating a URL that points to an image.
     *  // Regular expression pattern for validating a URL that points to an image.
     *  Explanation of the pattern components:
     *  (?i)           : Enable case-insensitive matching.
     *  \\b            : Match a word boundary.
     *  ((https?|ftp)://)? : Optional scheme prefix "http://", "https://", or "ftp://".
     *   [a-z0-9-]+     : Match lowercase letters, digits, and hyphens in the domain name.
     *    (\\.[a-z0-9-]+)+ : Match one or more subdomains separated by dots. 
     *     ([/?].*)?      : Optional path and query parameters.
     *      \\.(jpg|jpeg|gif|png|bmp) : Match supported image file extensions.
     *      \\b            : Match another word boundary.
     */	
	
	public static boolean productImageValidator(String string) throws IllegalArgumentException {

		if (string == null) {
			throw new IllegalArgumentException(productValidatorErrors.INVALID_PRODUCTIMAGE_NULL);
		}

		String intregex = "(?i)\\b((https?|ftp)://)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?\\.(jpg|jpeg|gif|png|bmp)\\b";
		Pattern pattern = Pattern.compile(intregex);
		Matcher matcher = pattern.matcher(string);
		Boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new IllegalArgumentException(productValidatorErrors.INVALID_PRODUCTIMAGE);

		}

		return true;

	}

	
	
    /**
     * Validates the product capacity to ensure it's greater than or equal to 1.
     *
     * @param productCapacity The product capacity to validate.
     * @return True if validation passes.
     * @throws IllegalArgumentException If the product capacity is less than 1.
     */	
	public static  boolean productCapacityValidator(int productCapacity) throws IllegalArgumentException{
		if(productCapacity >=1) {
			throw new IllegalArgumentException(productValidatorErrors.INVALID_PRODUCT_CAPACITY);
		}
		return true;
	}
	
	
	
	  /**
     * Validates the product's manufacture date to ensure it's not null and not before the current date.
     *
     * @param manufactureDate The product's manufacture date to validate.
     * @return True if validation passes.
     * @throws Exception If the manufacture date is null or before the current date.
     */	
	public static boolean validateManufactureDate(LocalDate manufactureDate) throws Exception {
		LocalDate today = LocalDate.now();
		if (manufactureDate == null) {
			throw new Exception(productValidatorErrors.INVALID_MANUFACTUREDATE_NULL);
		} else if (manufactureDate.isBefore(today)) {
			throw new Exception(productValidatorErrors.INVALID_MANUFACTUREDATE_PATTERN);
		} else {
			return true;
		}
	}

	    
	
}
