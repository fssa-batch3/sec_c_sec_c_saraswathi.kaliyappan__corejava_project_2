package com.fssa.skwater.daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.fssa.skwater.utils.ConnectionUtil;
import com.fssa.skwater.model.Product;
import com.fssa.skwater.validator.productValidatorErrors;
import com.fssa.skwater.utils.*;

public class productDAO {
	// Create product Query  
	public class ProductDao {

		public boolean addProduct(Product product) throws DAOException, SQLException {

			String query = "INSERT INTO product (id, name, url, price, category) VALUES (?, ?, ?, ?, ?)";

			try (Connection con = ConnectionUtil.getConnection()) {

				try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

					preparedStatement.setInt(1, (product.getProductId()));
					preparedStatement.setString(2, product.getProductName());
					preparedStatement.setString(3,product.getProductDescription());
					preparedStatement.setDouble(4, (product.getProductPrice()));
					preparedStatement.setString(5, product.getProductImageURL());
					preparedStatement.setInt(6, product.getProductCapacity());
					preparedStatement.executeUpdate();

				}
			} catch (SQLException ex) {
				throw new DAOException("Add Product Method is Failed");
			}

			return true;
		}
		
		// Update product Query
		public boolean updateProduct(Product product) throws DAOException, SQLException, InvalidCapacityException {

			if (product.getProductId() <= 0) {
				throw new InvalidCapacityException(productValidatorErrors.INVALID_PRODUCTID);
			}

			String query = "UPDATE product SET name = ? , url = ? , price = ? , category = ? WHERE id = ?";

			try (Connection con = ConnectionUtil.getConnection()) {

				try (PreparedStatement pst = con.prepareStatement(query)) {

					pst.setInt(6, (product.getProductId()));
					pst.setString(2, product.getProductName());
					pst.setString(3,product.getProductDescription());
					pst.setDouble(4, (product.getProductPrice()));
					pst.setString(1, product.getProductImageURL());
					pst.setInt(6, product.getProductCapacity());
					pst.executeUpdate();

				} catch (SQLException e) {
					throw new DAOException("Error Updating product: ", e);
				}
			}
			return true;

		}
		
		//Delete product Query	
		public boolean deleteProduct(int productId) throws DAOException, SQLException, InvalidCapacityException {

			if (productId <= 0) {
				throw new InvalidCapacityException(productValidatorErrors.INVALID_PRODUCTID);
			}

			String query = "DELETE FROM products WHERE id = ?";

			try (Connection con = ConnectionUtil.getConnection()) {

				try (PreparedStatement pt = con.prepareStatement(query)) {

					pt.setInt(1, productId);
					pt.executeUpdate();

				} catch (SQLException e) {
					throw new DAOException("Error Deleting product: ", e);
				}
			}
			return true;

		}
		
		// read product query

		public List<Product> getAllProductDetails() throws SQLException {

			List<Product> productList = new ArrayList<>();

			try (Connection con = ConnectionUtil.getConnection()) {
				final String query = "SELECT * FROM product";
				try (Statement st = con.createStatement()) {
					try (ResultSet rs = st.executeQuery(query)) {
						while (rs.next()) {
							Product product = new Product();
							product.setProductId(rs.getInt("productId"));
							product.setProductName(rs.getString("productName"));
							product.setProductDescription(rs.getString("productDescription"));
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
			return productList;
		}

	}
}
