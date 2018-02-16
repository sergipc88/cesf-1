package com.pablomonteserin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Mantenimiento {
	
	
	
void insertarPersona(String nombre, String dni) {

		Connection  databaseConnection =   getConnection();
		Statement statement;
		try {
			statement = databaseConnection.createStatement();
			statement.executeUpdate("INSERT INTO nueva_tabla VALUES ('"+dni+"','"+nombre+"')");
			statement.close();
			
			databaseConnection.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

Connection getConnection() {
	Connection databaseConnection = null; 
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String sourceURL = "jdbc:mysql://localhost/personas";
		databaseConnection= DriverManager.getConnection(sourceURL, "root", "");

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return databaseConnection;
	
}
}
