package com.fssa.skwater;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.fssa.skwater.connection.connectionUtil;
import com.fssa.skwater.daolayer.DAOException;
import com.fssa.skwater.model.Product;

//Create product Query 
public class CreateProductDAO {

	public static boolean addProduct(Product product) throws DAOException, SQLException {

		String query = "INSERT INTO product (id, name, Description, price, url, capacity) VALUES (?, ?, ?, ?, ?,?)";

		try (Connection con = connectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
				preparedStatement.setInt(1, (product.getProductId()));
				preparedStatement.setString(2, product.getProductName());
				preparedStatement.setString(3,product.getProductDescription());
				preparedStatement.setDouble(4, (product.getProductPrice()));
				preparedStatement.setString(5, product.getProductImageUrl());
				preparedStatement.setInt(6, product.getProductCapacity());
				preparedStatement.executeUpdate();						
				logger.info("Product Added");
			}
		} catch (SQLException ex) {
			throw new DAOException("Add Product Method is Failed");
		}

		return true;
	}
	
	
	// Update product Query
	public static boolean updateProduct(Product product) throws DAOException, SQLException {

		if (product.getProductId() <= 0) {
			throw new InvalidCategoryException(ProductValidatorError.INVALID_PRODUCTID);
		}

		String query = "UPDATE product SET name = ? , url = ? , price = ? , category = ? WHERE id = ?";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(5, (product.getProductId()));
				pst.setString(1, (product.getProductName()));
				pst.setString(2, product.getProductImageURL());
				pst.setDouble(3, (product.getProductPrice()));
				pst.setString(4, product.getProductCatagory());
				pst.executeUpdate();
				Logger.info("Product Update");
			} catch (SQLException e) {
				throw new DAOException("Error Updating product: ", e);
			}
		}
		return true;

	}
}