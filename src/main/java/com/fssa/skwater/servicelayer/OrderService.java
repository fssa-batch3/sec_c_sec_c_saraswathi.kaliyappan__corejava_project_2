package com.fssa.skwater.servicelayer;

import java.sql.SQLException;

import com.fssa.skwater.daolayer.OrderDao;
import com.fssa.skwater.exception.DaoException;
import com.fssa.skwater.exception.InvalidOrderException;
import com.fssa.skwater.model.Order;
import com.fssa.skwater.validator.OrderValidator;

public class OrderService {

	public static boolean addOrder(Order order) throws DaoException, InvalidOrderException, SQLException {

		if (OrderValidator.validateOrder(order)) {

			OrderDao.addOrder(order);
			return true;
		}
		return false;

	}

	public static Order getOrderById(int orderId) throws DaoException, InvalidOrderException, SQLException {

		OrderDao orderDao = new OrderDao();
		return orderDao.getOrderById(orderId);

	}
}
