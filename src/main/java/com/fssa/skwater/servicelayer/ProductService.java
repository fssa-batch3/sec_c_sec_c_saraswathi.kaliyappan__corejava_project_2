package com.fssa.skwater.servicelayer;

import java.net.MalformedURLException;

import java.sql.SQLException;
import java.util.List;
import java.util.function.BooleanSupplier;

import com.fssa.skwater.daolayer.ProductDao;
import com.fssa.skwater.exception.DaoException;
import com.fssa.skwater.exception.DaoException;
import com.fssa.skwater.exception.InvalidProductException;
import com.fssa.skwater.model.Product;
import com.fssa.skwater.validator.ProductValidator;

public class ProductService {

	public ProductService() {
		/*
		 * default constructor
		 */
	}

	/*
	 * Method to add a new product
	 */
	public static boolean addProduct(Product product) throws InvalidProductException, MalformedURLException {
		if (ProductValidator.validate(product)) {
			ProductDao.addProduct(product);
		}
		return true;
	}

	/*
	 * Method to read and display products
	 */
	public static boolean readProduct() throws SQLException, DaoException {
		ProductDao.readProduct();
		return true;

	}

	/*
	 * Method to update a product
	 */
	public static boolean updateProduct(Product product, int id)
			throws InvalidProductException, DaoException, MalformedURLException {
		if (ProductValidator.validate(product)) {
			ProductDao.updateProduct(product, id);
		}
		return true;

	}

	/*
	 * Method to delete a product
	 */
	public static boolean deleteProduct(int id) throws DaoException {

		ProductDao.deleteProduct(id);
		return true;

	}

	public List<Product> getAllProductDetails() throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.getAllProductDetails();

	}

	public static BooleanSupplier findProductByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
