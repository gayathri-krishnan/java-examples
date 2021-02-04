package com.gayathri.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

	public static void main(String[] args) {

		try {
			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:/Gayathri/learning/software/sqlite3-db/testjava.db");
//          conn.setAutoCommit(false);
			Statement statement = conn.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS contacts " + " (name TEXT, phone INTEGER, email TEXT)");
//          statement.execute("INSERT INTO contacts (name, phone, email) " +
//                            "VALUES('Joe', 45632, 'joe@anywhere.com')");
//
//          statement.execute("INSERT INTO contacts (name, phone, email) " +
//                  "VALUES('Jane', 4829484, 'jane@somewhere.com')");
//
//          statement.execute("INSERT INTO contacts (name, phone, email) " +
//                  "VALUES('Fido', 9038, 'dog@email.com')");
//
			statement.execute("SELECT * FROM contacts");
			ResultSet results = statement.getResultSet();
			while (results.next()) {
				System.out.println(
						results.getString("name") + " " + results.getInt("phone") + " " + results.getString("email"));
			}

			results.close();

			statement.close();
			conn.close();

//          Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\databases\\testjava.db");
//          Class.forName("org.sql.JDBC");

		} catch (SQLException e) {
			System.out.println("Something went wrong: " + e.getMessage());
		}
	}
}
