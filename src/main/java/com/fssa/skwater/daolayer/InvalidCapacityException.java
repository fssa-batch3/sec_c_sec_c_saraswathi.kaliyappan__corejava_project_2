package com.fssa.skwater.daolayer;


public class InvalidCapacityException extends Exception  {
	   
	private static final long serialVersionUID = -8105491977357554060L;

	public InvalidCapacityException(String msg) {
		super(msg);
	}	 
 
	public InvalidCapacityException(Throwable te) {
		super(te);
	} 

	public InvalidCapacityException(String msg, Throwable te) {
		super(msg, te);
	}
	
}