package com.fssa.skwater.daolayer;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.skwater.exception.DaoException;
import com.fssa.skwater.exception.DaoException;
import com.fssa.skwater.exception.InvalidProductException;
import com.fssa.skwater.logger.Logger;
import com.fssa.skwater.model.Product;
import com.fssa.skwater.utils.ConnectionUtil;
import com.fssa.skwater.validator.ProductValidateConstants;
import com.fssa.skwater.validator.productValidatorErrors;

public class ProductDao {
	/*
	 * Define a method to add a product to the database
	 */
	public static boolean addProduct(Product product) throws InvalidProductException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "INSERT INTO products(productName,productDescription,productPrice,productImage,productCapacity) VALUES (?,?,?,?,?);";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, product.getProductName());
				preparedStatement.setDouble(3, product.getProductPrice());
				preparedStatement.setString(4, product.getProductImageURL());
				preparedStatement.setLong(5, product.getProductCapacity());

				int rows = preparedStatement.executeUpdate();

				Logger.info("Product Added");
				return (rows > 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidProductException(productValidatorErrors.CANNOT_ADD_PRODUCT);
		}

	}

	/*
	 * Define a method to get a product's ID by its name
	 */
	public static int getIdByProductName(String name) throws SQLException, InvalidProductException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			// Create update statement using task id
			String query = "SELECT productId FROM products WHERE productName = ? ";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, name);
				Logger.info(preparedStatement);
				ResultSet resultSet = preparedStatement.executeQuery();

				int id = 0;
				while (resultSet.next()) {
					id = resultSet.getInt("productId");
				}
				return id;
			}
		} catch (SQLException e) {
			throw new InvalidProductException("Error getting id by name", e);
		}

	}

	/*
	 * Define a method to delete a product from the database
	 */
	public static boolean deleteProduct(int productId) throws DaoException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "DELETE FROM products WHERE productId = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

				preparedStatement.setInt(1, productId);

				int rows = preparedStatement.executeUpdate();
				Logger.info("Product Deleted");

				return (rows > 0);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}

	}

	/*
	 * Define a method to retrieve and display all products from the database
	 */

	public static boolean readProduct() throws DaoException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM products";
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) { // this will run the query and return the
					// value
					while (resultSet.next()) { // printing columns until there is no values

						Logger.info(ProductValidateConstants.PRODUCT_ID_SYSOUT_MSG + resultSet.getInt(1));
						Logger.info(ProductValidateConstants.PRODUCT_NAME_SYSOUT_MSG + resultSet.getString(2));
						Logger.info(ProductValidateConstants.PRODUCT_DESCRIPTION_SYSOUT_MSG + resultSet.getString(3));
						Logger.info(ProductValidateConstants.PRODUCT_INVALID_PRICE + resultSet.getString(4));
						Logger.info(ProductValidateConstants.PRODUCT_IMAGEURL_SYSOUT_MSG + resultSet.getString(5));
						Logger.info(ProductValidateConstants.PRODUCT_CATEGORY_SYSOUT_MSG + resultSet.getString(6));

					}
					return true;
				}
			} catch (SQLException e) {

				e.printStackTrace();
				throw new DaoException(e);
			}

		}

	}

	/*
	 * Define a method to find a product by its name
	 */

	public static boolean findProductByName(String productName) throws DaoException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM products WHERE productName = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, productName);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					if (resultSet.next()) {

						Logger.info(ProductValidateConstants.PRODUCT_ID_SYSOUT_MSG + resultSet.getInt(1));
						Logger.info(ProductValidateConstants.PRODUCT_NAME_SYSOUT_MSG + resultSet.getString(2));
						Logger.info(ProductValidateConstants.PRODUCT_DESCRIPTION_SYSOUT_MSG + resultSet.getString(3));
						Logger.info(ProductValidateConstants.PRODUCT_INVALID_PRICE + resultSet.getString(4));
						Logger.info(ProductValidateConstants.PRODUCT_IMAGEURL_SYSOUT_MSG + resultSet.getString(5));
						Logger.info(ProductValidateConstants.PRODUCT_CATEGORY_SYSOUT_MSG + resultSet.getString(6));

					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DaoException(e);
			}
		}
		return true;
	}

	/*
	 * Define a method to update a product in the database
	 */
	public static boolean updateProduct(Product product, int id) throws DaoException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "UPDATE products SET productName=?, productDescription=?, productPrice=?, productImage=?, productCapacity=? WHERE productId=?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, product.getProductName());
				preparedStatement.setDouble(3, product.getProductPrice());
				preparedStatement.setString(4, product.getProductImageURL());
				preparedStatement.setLong(5, product.getProductCapacity());
				preparedStatement.setInt(6, id);

				int rows = preparedStatement.executeUpdate();

				Logger.info("Product Updated");
				return (rows > 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}

	public List<Product> getAllProductDetails() throws SQLException {

		List<Product> productList = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM products";
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(query)) {
					while (rs.next()) {
						Product product = new Product();
						product.setProductId(rs.getInt("productId"));
						product.setProductName(rs.getString("productName"));
						product.setProductImageURL(rs.getString("productImage"));
						product.setProductPrice(rs.getDouble("productPrice"));
						product.setProductCapacity(rs.getInt("productCapacity"));
						productList.add(product);
					}

				}
			}

		} catch (Exception ex) {
			Logger.info(ex.getMessage());
			throw new SQLException("Get All Product Details Method Is Failed");
		}
		System.out.println(productList);
		return productList;
	}

}
