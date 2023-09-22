package com.fssa.skwater.servicelayer;

import java.sql.SQLException;
import java.util.function.BooleanSupplier;

import com.fssa.skwater.daolayer.UserDao;
import com.fssa.skwater.exception.CustomException;
import com.fssa.skwater.exception.DaoException;
import com.fssa.skwater.exception.InvalidUserException;
import com.fssa.skwater.model.User;
import com.fssa.skwater.validator.UserValidator;
import com.google.protobuf.ServiceException;

public class UserService {

	UserDao userDao = new UserDao();

	public boolean userSignUp(User user) throws ServiceException, InvalidUserException {
		try {
			if (UserValidator.validate(user)) {
				return userDao.userSignIn(user);
			}
		} catch (DaoException e) {
			throw new ServiceException("Error during user sign-up: " + e.getMessage(), e);
		}
		return false;

	}

	public boolean deleteUser(String emailId) throws ServiceException {
		try {
			if (!UserValidator.emailValidator(emailId)) {
				throw new InvalidUserException("Invalid email format: " + emailId);
			}

			if (!userDao.emailExists(emailId)) {
				throw new ServiceException("Email Not Found: " + emailId);
			}

			return userDao.deleteUser(emailId);
		} catch (InvalidUserException e) {
			// Handle validation errors
			throw new ServiceException(e.getMessage());
		} catch (DaoException | SQLException e) {
			// Handle database access errors
			throw new ServiceException("Error while accessing the database: " + e.getMessage());
		}
	}

	
public Object userLogin1(String email)throws  ServiceException{
		
		UserDao userDao = new UserDao();
		User user = new User();
		try {
			user = userDao.loginUser(email); 
			return user;
		}
		catch(DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public User getUserByEmail(String emailId) throws ServiceException, SQLException, InvalidUserException {
		try {
			if (UserValidator.emailValidator(emailId)) {
				if (userDao.emailExists(emailId)) {
					return userDao.getUserByEmail(emailId);
				} else {
					throw new DaoException("User not found for email: " + emailId);
				}
			}
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return null; // Invalid email format
	}

	public User userLogin(String emailId,String password) throws ServiceException{
		try {
			if (UserValidator.emailValidator(emailId)) {
                if (UserValidator.passwordValidator(password)) {
                    if (userDao.emailExists(emailId)) {
                        User user = userDao.getUserByEmail(emailId);
                        if (user != null && user.getPassword().equals(password)) {
                            return user;
                        } 
                    } else {
                        throw new ServiceException("Invalid email or password" + emailId);
                    }
                } 
                else {
                    throw new ServiceException("User not found for email: " + emailId);
                }
            }
		} catch (DaoException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
		return null; // Invalid email format
	}


	public boolean userProfileUpdate(String email,User user)throws ServiceException{
		UserDao dao = new  UserDao();
		UserValidator userValidator = new UserValidator();
		try {
//			userValidator.validate(user);
			dao.updateuser(email,user);
			return true;
		}
		catch(DaoException | IllegalArgumentException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage()); 
		}
	}



}