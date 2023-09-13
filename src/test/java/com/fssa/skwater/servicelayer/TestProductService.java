package com.fssa.skwater.servicelayer;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

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
		product.setProductName("Aquafina");
		product.setProductImageURL("https://iili.io/HytWEfs.jpg");
		product.setProductDescription("Carbon Filter: Remove residual chlorine and odours.");
		product.setProductPrice(50);
		product.setProductCapacity(20);
		return product;
	}
	
	public ProductService getProductService() {
		ProductService productService = new ProductService();
		return productService;
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
	 * Test method for updating a product
	 */
	@Test
	void testUpdateProduct() throws InvalidProductException, DAOException, MalformedURLException {

		Assertions.assertTrue(ProductService.updateProduct(validProduct(),2));
		System.out.println("ProductUpdate Successfully");
	}

	/*
	 * Test method for deleting a product
	 */
	@Test
	void testDeleteProduct() throws DAOException, InvalidProductException {
		Assertions.assertTrue(ProductService.deleteProduct(6));
		System.out.println("Deleted Successfully");
	}
	
	@Test

	void testgetAllProductDetails() throws DAOException, SQLException {
		ProductService productService = getProductService();
		List<Product> productList = productService.getAllProductDetails();
		for (Product e : productList) {
			System.out.println(e);
		}

	}
	
	/*
	 * Test method for finding a product by its name
	 */
	@Test
	void testFindProductByName() throws InvalidProductException, DAOException {
		try {
			Assertions.assertTrue(ProductService.findProductByName("Bisleri"));
		} catch (InvalidProductException | SQLException e) {
			Assertions.fail("Unexpected exception thrown: " + e.getMessage());
		}

	}
	
	/*
	 * Test method for reading products
	 */
	@Test
	void testReadProduct() throws SQLException, InvalidProductException, DAOException {
		Assertions.assertTrue(ProductService.readProduct());
	}
}

