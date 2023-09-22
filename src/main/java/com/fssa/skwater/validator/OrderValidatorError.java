package com.fssa.skwater.validator;

public class OrderValidatorError {

	public static final String INVALID_ORDER_NULL = "Invalid order:Order is null";
	public static final String INVALID_USERNAME_NULL = "Invalid name: Name cannot be null or empty";
	public static final String INVALID_USERNAME_PATTERN = "Invalid name: Name must be 3 to 20 charactors long and contain only letters";
	public static final String INVALID_PHONE_NUMBER_NULL = "Invalid phone number: Phone number cannot be null";
	public static final String INVALID_PHONE_NUMBER = "Invalid phone number: phone number must be a valid indian phone number";
	public static final String INVALID_ID = "Invalid id";
	public static final String INVALID_COMMENTSTATEMENT = "Comments must be at least t0 charactors long";
	public static final String INVALID_STATUS = "Invalid order status";
	public static final String INVALID_ORDERED_DATE = "Invalid order date.please provid valid date";
	public static final String ORDER_DATE_IN_FUTURE = "Order date cannot be in the feacture";
	public static final String CANNOT_ADD_ORDER = "Order cannot be add";

}
