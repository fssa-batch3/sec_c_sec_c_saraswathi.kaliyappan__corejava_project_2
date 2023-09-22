package com.fssa.skwater.daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.skwater.exception.DaoException;
import com.fssa.skwater.logger.Logger;
import com.fssa.skwater.model.User;
import com.fssa.skwater.utils.ConnectionUtil;

public class UserDao {

	public boolean userSignIn(User user) throws DaoException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String insertQuery = "INSERT INTO users (first_name, last_name, email, password , phone_number, address) VALUES (?, ?, ?, ?,?,?)";
			try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {
				psmt.setString(1, user.getFirstName());
				psmt.setString(2, user.getLastName());
				psmt.setString(3, user.getEmail());
				psmt.setString(4, user.getPassword());
				psmt.setString(5, user.getPhonenumber());
				psmt.setString(6, user.getAddress());

				int rowsAffected = psmt.executeUpdate();
				return rowsAffected > 0;
			} catch (SQLException e) {
				// Handle any SQLException that may occur during PreparedStatement execution
				throw new DaoException("Error while executing the insert query: " + e.getMessage(), e);
			}
		} catch (SQLException e) {
			// Handle any SQLException that may occur during database connection
			throw new DaoException("Error while connecting to the database: " + e.getMessage(), e);
		}
	}

	public boolean deleteUser(String emailId) throws DaoException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String deleteQuery = "DELETE FROM users WHERE email = ?";

			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {

				psmt.setString(1, emailId);
				int rowAffected = psmt.executeUpdate();
				return rowAffected > 0;
			}
		}
	}

	public User loginUser(String emailId) throws DaoException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String selectQuery = "SELECT user_id, email,first_name, last_name, password, phone_number,address FROM users WHERE email = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);
				Logger.info(emailId);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("user_id"));
						user.setEmail(rs.getString("email"));
						user.setFirstName(rs.getString("first_name"));
						user.setLastName(rs.getString("last_name"));
						user.setPassword(rs.getString("password"));
						user.setPhonenumber(rs.getString("phone_number"));
						user.setAddress(rs.getString("address"));
						Logger.info(user);
						return user;
					} else {
						throw new DaoException("User not found");
					}
				}
			}
		} catch (SQLException e) {
			throw new DaoException("Database Connection Error: " + e.getMessage());
		}
	}

	public boolean emailExists(String emailId) throws DaoException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement psmt = connection.prepareStatement("SELECT user_id FROM users WHERE email = ?")) {

			psmt.setString(1, emailId);

			try (ResultSet rs = psmt.executeQuery()) {
				if (rs.next()) {
					// If a row with the given email exists, return true
					return true;
				}
			} 
		} catch (SQLException e) {
			// Handle any SQLException that may occur during database connection or
			// statement creation
			throw new DaoException("Error while checking email existence: " + e.getMessage(), e);
		}

		// If no matching email was found, return false
		return false;
	}

	public User getUserByEmail(String emailId) throws DaoException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String selectQuery = "SELECT user_id, first_name, last_name, password FROM users WHERE email = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("user_id"));
						user.setFirstName(rs.getString("firs_tname"));
						user.setLastName(rs.getString("last_name"));
						user.setPassword(rs.getString("password"));
						return user;
					}
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
		return null; // User not found
	}

	public boolean updateuser(String email, User user) throws DaoException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String getUserQuery = "UPDATE users SET first_name =?,last_name =?,, phone_number =? ,email =? ,password =? WHERE email = ? ";
			try (PreparedStatement psmt = connection.prepareStatement(getUserQuery)) {
				psmt.setString(1, user.getFirstName());
				psmt.setString(1, user.getLastName());
				psmt.setString(2, user.getPhonenumber());
				psmt.setString(3, user.getEmail());
				psmt.setString(4, user.getPassword());
				psmt.setString(5, user.getAddress());
				psmt.setString(6, email);

				int rowAffected = psmt.executeUpdate();
				Logger.info(user);

				if (rowAffected > 0) {
					Logger.info("Success updated");
					return true;
				} else {
					Logger.info("error while update the row");

				}
			}
		} catch (SQLException e) {
			throw new DaoException("Error while getting the connection" + e.getMessage());
		}
		return false;
	}
}