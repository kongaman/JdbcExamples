package best.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
//			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
			
//			statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Tim', 654321876, 'tim@email.com')");
//			statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Chris', 123456789, 'chris@email.com')");
//			statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Yvonne', 564738291, 'yc@email.com')");
//			statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Fido', 12334, 'dog@email.com')");
			
//			statement.execute("UPDATE contacts SET phone = 11223344 WHERE name = 'Chris'");
//			statement.execute("DELETE FROM contacts WHERE name = 'Yvonne'");
			
			statement.execute("SELECT * FROM contacts");
			ResultSet results = statement.getResultSet();
			while (results.next()) {
				System.out.println(results.getString("name") + " " + results.getInt("phone") + " " + results.getString("email"));
			}
			
			results.close();
			
			statement.close();
			connection.close();
				
		} catch (SQLException e) {
			System.err.println("Something went wrong: " + e.getMessage());
		}
	}

}
