package com.fssa.skwater.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class connectionUtil {
	 public static Connection getConnection() {
	        Connection con = null;

	        String url, userName, passWord;

	  
	            url = System.getenv("DATABASE_HOST");
	            userName = System.getenv("DATABASE_USERNAME");
	            passWord = System.getenv("DATABASE_PASSWORD");
	            
	            
	            
	            
	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, userName, passWord);
	            System.out.println("connected");
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Unable to connect to the database");
	        }
	        return con;
	    }	
	 
	 public static void close(Connection conn, Statement stmt, ResultSet rs) {

			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					((Connection) stmt).close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.getMessage();
			}
		}

	 public static void main(String[] args) {
		 Connection con = getConnection();
	}
}
