package com.fssa.skwater.daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fssa.skwater.enumclass.orderStatus;
import com.fssa.skwater.exception.DaoException;
import com.fssa.skwater.exception.InvalidOrderException;
import com.fssa.skwater.logger.Logger;
import com.fssa.skwater.model.Order;
import com.fssa.skwater.model.OrderDetail;
import com.fssa.skwater.utils.ConnectionUtil;
import com.fssa.skwater.validator.OrderValidatorError;
import com.fssa.skwater.validator.ProductValidateConstants;

public class OrderDao {

	public static void addOrder(Order order) throws DaoException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			// SQL query to insert the order information into the 'orders' table
			String insertQuery = "INSERT INTO `order` (ordered_date, user_id, total_amount, status) VALUES (?, ?, ?, ?)";

			// Execute insert statement
			try (PreparedStatement pst = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

				pst.setString(4, order.getStatus().toString());
				pst.setInt(2, order.getUserID());
				pst.setDouble(3, order.getTotalAmount());
				pst.setString(1, order.getOrderedDate() + "");

				int affectedRows = pst.executeUpdate();
				int orderId;
				if (affectedRows == 0) {
					throw new SQLException("Adding order failed, no rows affected.");
				}

				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						orderId = generatedKeys.getInt(1);
						System.out.println("orderId : " + orderId);
					} else {
						throw new SQLException("Creating user failed, no ID obtained.");
					}
				}
				addOrderItems(order.getProductsList(), orderId);
				Logger.info("row/rows affected: " + affectedRows);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Order caption failed");
		}
	}

	public static void addOrderItems(List<OrderDetail> orderedProducts, int orderId) throws DaoException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			// SQL query to insert the order information into the 'orders' table
			String insertQuery = "INSERT INTO order_items (order_id, product_id, price, quantity,total_amount, status) VALUES (?, ?, ?, ?,?,?)";

			// Execute insert statement
			try (PreparedStatement pst = connection.prepareStatement(insertQuery)) {

				for (OrderDetail orderedProduct : orderedProducts) {

					pst.setInt(1, orderId);
					pst.setInt(2, orderedProduct.getProductId());
					pst.setDouble(3, orderedProduct.getProductPrice());
					pst.setInt(4, 1);
					pst.setDouble(5, orderedProduct.getTotalAmount());
					pst.setString(6, orderStatus.ORDERED + "");

					// Execute the insert statement and get the number of affected rows
					int rowsAffected = pst.executeUpdate();
				}
				Logger.info("Odered products addded to the ordered_products table successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Order caption failed");
		}
	}

	private static boolean checkOrderExists(int orderId) throws DaoException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT COUNT(*) FROM orders WHERE order_id = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setInt(1, orderId);
				try (ResultSet resultSet = pst.executeQuery()) {
					if (resultSet.next()) {
						int count = resultSet.getInt(1);
						return count > 0; // If count > 0, order with the ID exists
					}
				}
			}
		}
		return false;
	}

	public Order getOrderById(int orderId) throws DaoException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM order WHERE order_id = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setInt(1, orderId);

				try (ResultSet resultSet = pst.executeQuery()) {
					if (resultSet.next()) {
						Order order = new Order();
						order.setOrderId(resultSet.getInt("order_id"));
						order.setTotalAmount(resultSet.getDouble("total_amount"));
						order.setOrderedDate(resultSet.getDate("ordered_date").toLocalDate());
						order.setStatus(orderStatus.valueOf(resultSet.getString("status")));

						return order;
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Order fail");
		}
		return null;
	}

}