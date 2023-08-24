package com.fssa.skwater.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for validating the methods in the productValidator class.
 */
public class TestProductValidator {
		
	private static final String Product = null;

    // Test validation for null product object
	@Test
	public void testProductValidator() {
		try {
			boolean validate = productValidator.validate(null);
			Assertions.fail(productValidatorErrors.INVALID_PRODUCT_NULL);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCT_NULL, e.getMessage());
		}
	}

	
    // Test valid product ID
	@Test

	void testValidProductId() {
		int productId = 55; // valid product id
		Assertions.assertTrue(productValidator.validateProductId(productId));
	}

	
    // Test invalid product ID (negative value)
	@Test

	void testInValidProductId() {
		try {
			int productId = -5; // Invalid product id
			productValidator.validateProductId(productId);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(productValidatorErrors.INVALID_PRODUT_ID, ex.getMessage());
		}
	}

	
    // Test valid product name
	@Test
	public void testProductName() {
		Assertions.assertTrue(productValidator.productNameValidator("Bisleri"));
	}

    // Test invalid product name (null)
	@Test
	public void testInvalidProductNameNull() {
		try {
			productValidator.productNameValidator(null);
			Assertions.fail(productValidatorErrors.INVALID_PRODUCTNAME_NULL);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCTNAME_NULL, e.getMessage());
		}
	}
	
	
    // Test invalid product name (length less than 2 and more than 15 characters)
	@Test
	public void testInvalidProductNameLength() {
		try {
			productValidator.productNameValidator("b");  
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCTNAME, e.getMessage());
		}
		
		
		try {
			productValidator.productNameValidator("ThisProductNameIsTooLong");
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCTNAME, e.getMessage());
		}
	}
	
	
    // Test valid product description
	@Test
	public void testValidProductDescription() {
		Assertions.assertTrue(productValidator.productDescriptionValidator("The product is very good product"));
	}
	
	
    // Test invalid product description (null)
	@Test
	public void testInvalidProductDescriptionNull() {
		try {
			productValidator.productDescriptionValidator(null);
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCT_DESCRIPTION_NULL, e.getMessage());
		}
	}
	
    // Test invalid product description (length less than 15 characters)
	@Test
	public void testInvalidProductDescriptionLength() {
		try {
			productValidator.productDescriptionValidator("yello"); 
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCT_DESCRIPTION, e.getMessage());
		}
	}
	
    // Test valid product image URL
		@Test
		void testValidIamge() {
			Assertions.assertTrue(productValidator.productImageValidator("https://iili.io/HhR0ku9.jpg"));
		}

		
	    // Test invalid product image URL
		@Test
		void testInvalidIamge() {
			try {
				productValidator.productImageValidator("https://iili.io/HZHkOzl.https");
				Assertions.fail("Validate image failed");
			} catch (IllegalArgumentException ex) {
				Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCTIMAGE, ex.getMessage());
			}
		}

		
	    // Test null product image URL
		@Test
		void testInvalidNullProductImage() {
			try {
				productValidator.productImageValidator(null);
			} catch (IllegalArgumentException ex) {
				Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCTIMAGE_NULL, ex.getMessage());
			}
		}
		
	    // Test valid product price
	    @Test
	    public void testValidProductPrice() {
		         Assertions.assertTrue(productValidator.productPriceValidator(1000));
	     }
	    
	    
	// Test invalid product price (zero)
	@Test
	public void testInvalidProductPriceZero() {
		try {
			productValidator.productPriceValidator(0);
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCT_PRICE, e.getMessage());
		}
	}
	
	
    // Test invalid product price (less than 500)
	@Test
	public void testInvalidProductPriceLessThan500() {
		try {
			productValidator.productPriceValidator(100);
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCT_PRICE, e.getMessage());
		}
	}
	
	
////test for valid product capacity 
//	@Test
//	public void testValidProductCapacity() {
//		Assertions.assertTrue(ProductValidator.productCapacityValidator(50));
//	}
	
    // Test invalid product capacity
	@Test
	public void testProductCapacityValidatorWithInvalidCapacity() {
		try {
			// Invalid capacity, should be greater than 0
			productValidator.validate(0); 
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(productValidatorErrors.INVALID_PRODUCT_CAPACITY, e.getMessage());
		}
	}
	
	//Test invalid manufactureDate
	 @Test
	    void testInvalidManufactureDate() {
	        try {
	        	productValidator.validateManufactureDate(null);
	            Assertions.fail("Expected an exception, but none was thrown.");
	        } catch (Exception e) {
            Assertions.assertEquals(productValidatorErrors.INVALID_MANUFACTUREDATE_PATTERN, e.getMessage());
	        }
	}


}
