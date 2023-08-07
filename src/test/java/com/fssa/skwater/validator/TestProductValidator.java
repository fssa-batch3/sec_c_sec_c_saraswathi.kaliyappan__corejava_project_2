package com.fssa.skwater.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestProductValidator {
	//test validation for product object
	@Test
	public void testProductValidator() {
		try {
			boolean validate = ProductValidator.validate(null);
			Assertions.fail(productValidatorErros.INVALID_PRODUCT_NULL);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCT_NULL, e.getMessage());
		}
	}

	//test for validation for the product name
	//valid product name
	@Test
	public void testProductName() {
		Assertions.assertTrue(ProductValidator.productNameValidator("Bisleri"));
	}

	//test for product name is null
	@Test
	public void testInvalidProductNameNull() {
		try {
			ProductValidator.productNameValidator(null);
			Assertions.fail(productValidatorErros.INVALID_PRODUCTNAME_NULL);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCTNAME_NULL, e.getMessage());
		}
	}
    //test for invalid product name.
	//the product name is Less than 2 characters
	@Test
	public void testInvalidProductNameLength() {
		try {
			ProductValidator.productNameValidator("b");  
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCTNAME, e.getMessage());
		}
		 // the product name is More than 15 characters
		try {
			ProductValidator.productNameValidator("ThisProductNameIsTooLong");
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCT_NAME, e.getMessage());
		}
	}
  // test for the valid product description
	@Test
	public void testValidProductDescription() {
		Assertions.assertTrue(ProductValidator.productDescriptionValidator("The product is very good product"));
	}
  //test for the invalid product description
	@Test
	public void testInvalidProductDescriptionNull() {
		try {
			ProductValidator.productDescriptionValidator(null);
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCT_DESCRIPTION_NULL, e.getMessage());
		}
	}
	// test for invalid product description  Less than 15 characters
//	@Test
//	public void testInvalidProductDescriptionLength() {
//		try {
//			ProductValidator.productDescriptionValidator("yello"); 
//			Assertions.fail("Expected IllegalArgumentException was not thrown");
//		} catch (IllegalArgumentException e) {
//			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCT_DESCRIPTION, e.getMessage());
//		}
//		// test for invalid product description More than 100 characters
//		try {
//			ProductValidator.productDescriptionValidator(
//					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis ipsum enim."); 
//			Assertions.fail("Expected IllegalArgumentException was not thrown");
//		} catch (IllegalArgumentException e) {
//			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCT_DESCRIPTION_NULL, e.getMessage());
//		}
//	}
  //test for valid product image url
	@Test
	public void testValidProductImageURL() {
		Assertions.assertTrue(ProductValidator.productImageURLValidator("https://iili.io/HhRcKZb.jpg"));
	}
 //test for  invalid product image url null
	@Test
	public void testInvalidProductImageURLNull() {
		try {
			ProductValidator.productImageURLValidator(null);
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCT_IMAGE_URL_NULL, e.getMessage());
		}
	}
// // test for Invalid URL pattern
//	@Test
//	public void testInvalidProductImageURLPattern() {
//		try {
//			ProductValidator.productImageURLValidator("ghjk"); 
//			Assertions.fail("Expected IllegalArgumentException was not thrown");
//		} catch (IllegalArgumentException e) {
//			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCT_IMAGE_URL_NULL, e.getMessage());
//		}
//	}
//test for valid product price
	@Test
	public void testValidProductPrice() {
		Assertions.assertTrue(ProductValidator.productPriceValidator(1000));
	}
//test for invalid product price
	@Test
	public void testInvalidProductPriceZero() {
		try {
			ProductValidator.productPriceValidator(0);
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCT_PRICE, e.getMessage());
		}
	}
//test for invalid product price less than 500
	@Test
	public void testInvalidProductPriceLessThan500() {
		try {
			ProductValidator.productPriceValidator(100);
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCT_PRICE, e.getMessage());
		}
	}
////test for valid product capacity 
//	@Test
//	public void testProductCapacityValidatorWithValidCapacity() {
//		Assertions.assertTrue(ProductValidator.productCapacityValidator(500));
//	}
	
//test for invalid product capacity
	@Test
	public void testProductCapacityValidatorWithInvalidCapacity() {
		try {
			// Invalid capacity, should be greater than 0
			ProductValidator.productCapacityValidator(0); 
			Assertions.fail("Expected IllegalArgumentException was thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErros.INVALID_PRODUCT_CAPACITY, e.getMessage());
		}
	}
}
