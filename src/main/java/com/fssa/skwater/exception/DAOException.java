package com.fssa.skwater.exception;

import java.sql.SQLException;

public class DaoException extends Exception {

	public DaoException(String string, SQLException e) {
		super();
	}

	public DaoException(String msg) {
		super(msg);
	}

	public DaoException(SQLException e) {
		super("A database error occurred: " + e.getMessage(), e);
	}

}