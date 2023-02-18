package best.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
//		//try with resources:
//		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:H:\\Databases\\testjava.db");
//		     Statement statement = conn.createStatement()){ }
//		//this will close the resources in () automatically when the try/catch block is exited.
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:H:\\Databases\\testjava.db");
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS contacts "
							+ "(name TEXT, phone INTEGER, email TEXT)");
			
			statement.close();
			connection.close();
				
		} catch (SQLException e) {
			System.err.println("Something went wrong: " + e.getMessage());
		}
	}

}
