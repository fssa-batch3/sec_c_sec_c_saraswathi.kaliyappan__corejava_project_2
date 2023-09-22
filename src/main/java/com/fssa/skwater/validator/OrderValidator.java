package com.fssa.skwater.validator;

import java.time.LocalDate;
import java.util.List;

import com.fssa.skwater.enumclass.orderStatus;
import com.fssa.skwater.exception.InvalidOrderException;
import com.fssa.skwater.model.Order;
import com.fssa.skwater.model.OrderDetail;

public class OrderValidator {

	Order order = new Order();

	// Set the properties of the order
	public static boolean validateOrder(Order order) throws InvalidOrderException {
		if (order == null) {
			throw new InvalidOrderException("Order is null");
		}

		validateTotalAmount(order.getTotalAmount());
		validateProductsList(order.getProductsList());
		validateOrderedDate(order.getOrderedDate());
		validateStatus(order.getStatus());
		return true;
	}

	public static boolean validateTotalAmount(double totalAmount) throws InvalidOrderException {
		// Check if the price is non-positive
		if (totalAmount <= 0) {
			throw new InvalidOrderException("Invalid Total Ammount");
		}
		return true;
	}

	public static boolean validateProductsList(List<OrderDetail> list) throws InvalidOrderException {
		if (list == null || list.isEmpty()) {
			throw new InvalidOrderException("Invalid productlist");
		}
		return true;
	}

	public static boolean validateOrderedDate(LocalDate orderedDate) throws InvalidOrderException {
		if (orderedDate == null) {
			throw new InvalidOrderException("Invalid order Date");
		}

		LocalDate currentDate = LocalDate.now();

		if (orderedDate.isAfter(currentDate)) {
			throw new InvalidOrderException("Invalid order Date in future");
		}
		return true;
	}

	public static boolean validateStatus(orderStatus status) throws InvalidOrderException {

		if (status == null) {
			throw new InvalidOrderException("Invalid order Status");
		}
		return false;
	}

	public static boolean validateAddress(String address) throws InvalidOrderException {

		if (address != null && !address.isEmpty() && address.length() > 5) {
			throw new InvalidOrderException("Invalid order Address");
		}

		return true;

	}

}