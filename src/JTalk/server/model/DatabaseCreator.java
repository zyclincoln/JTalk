package JTalk.server.model;

import java.sql.*;

class DatabaseCreator {
	DatabaseCreator() {

	}
	void CreateDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/JTalk", "root", "");
			DatabaseMetaData databaseMetaData = connection.getMetaData();
		} catch(SQLException exception) {
			System.out.println(exception);
		} catch(Exception exception) {
			System.out.println(exception);
		}
	}
}
