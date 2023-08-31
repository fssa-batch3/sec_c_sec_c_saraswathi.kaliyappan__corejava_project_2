package com.fssa.skwater.servicelayer;

import java.net.MalformedURLException;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.skwater.exception.DAOException;
import com.fssa.skwater.exception.InvalidProductException;
import com.fssa.skwater.model.Product;

/*
 * Define the test class for ProductService
 */
class TestProductService {
	/*
	 * Method to create a valid product for testing
	 */
	public static Product validProduct() {

		Product product = new Product();
		product.setProductName("Nestley");
		product.setProductImageURL("https://iili.io/HyPiPr7.jpg");
		product.setProductDescription("This drinking water pump is specially designed for a healthy life.");
		product.setProductPrice(40);
		product.setProductCapacity(25);
		return product;
	}

	/*
	 * Test method for adding a valid product
	 */
	@Test
	void testAddProduct() throws InvalidProductException, MalformedURLException {

		Assertions.assertTrue(ProductService.addProduct(validProduct()));
		System.out.println("sucessfully Add Product");

	}

	/*
	 * Test method for reading products
	 */
	@Test
	void testReadProduct() throws SQLException, InvalidProductException, DAOException {
		Assertions.assertTrue(ProductService.readProduct());
	}

	/*
	 * Test method for updating a product
	 */
	@Test
	void testUpdateProduct() throws InvalidProductException, DAOException, MalformedURLException {

		Assertions.assertTrue(ProductService.updateProduct(validProduct(), 1));
	}

	/*
	 * Test method for deleting a product
	 */
	@Test
	void testDeleteProduct() throws DAOException, InvalidProductException {
		Assertions.assertTrue(ProductService.deleteProduct(3));
	}

	/*
	 * Test method for finding a product by its name
	 */
	@Test
	void testFindProductByName() throws InvalidProductException, DAOException {
		try {
			Assertions.assertTrue(ProductService.findProductByName("Nerdlane"));
		} catch (InvalidProductException | SQLException e) {
			Assertions.fail("Unexpected exception thrown: " + e.getMessage());
		}
	}
}
