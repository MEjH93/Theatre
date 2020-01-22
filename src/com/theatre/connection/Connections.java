package com.theatre.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
	private static Connections instance;
	private Connection connection;
	private Connections() {
		loadDriver();
	}
	private void loadDriver() {
		// TODO Auto-generated method stub
		//ovo ne treba od jave 8 inace bi morali da load driver isto
		
	}
	public static Connections getInstance() {
		if(instance == null) {
			instance = new Connections();
		}
		return instance;
	}

	public void startTransaction() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre", "root","");
			connection.setAutoCommit(false);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void confirmTransaction() {
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void undoTransaction() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return connection;
	}
	
}
