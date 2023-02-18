package best.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static final String DB_NAME = "testjava.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:H:\\Databases\\" + DB_NAME;
	public static final String TABLE_CONTACTS = "contacts";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_PHONE = "phone";
	public static final String COLUMN_EMAIL = "email";

	public static void main(String[] args) {

		try {
			Connection connection = DriverManager.getConnection(CONNECTION_STRING);
			Statement statement = connection.createStatement();

			statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "(" + COLUMN_NAME + " TEXT, "
					+ COLUMN_PHONE + " INTEGER, " + COLUMN_EMAIL + " TEXT)");

			statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", "
					+ COLUMN_EMAIL + ") " + "VALUES ('Tim', 654321876, 'tim@email.com')");
			statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", "
					+ COLUMN_EMAIL + ") " + "VALUES ('Chris', 123456789, 'chris@email.com')");
			statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", "
					+ COLUMN_EMAIL + ") " + "VALUES ('Yvonne', 564738291, 'yc@email.com')");
			statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", "
					+ COLUMN_EMAIL + ") " + "VALUES ('Fido', 12334, 'dog@email.com')");

			statement.execute("UPDATE " + TABLE_CONTACTS + " SET " + COLUMN_PHONE + " = 11223344 WHERE " + COLUMN_NAME
					+ " = 'Chris'");

			statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + " = 'Fido'");

			ResultSet results = statement.executeQuery("SELECT * FROM contacts");
			while (results.next()) {
				System.out.println(results.getString(COLUMN_NAME) + " " + results.getInt(COLUMN_PHONE) + " "
						+ results.getString(COLUMN_EMAIL));
			}

			results.close();

			statement.close();
			connection.close();

		} catch (SQLException e) {
			System.err.println("Something went wrong: " + e.getMessage());
		}
	}

}
