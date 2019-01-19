package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "Mummapapa@7";
		try {
			
			System.out.println("Connecting to Data base :"+jdbcUrl);
			
			// establish the connection with Driver Manager class
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connectin successfuly established");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
