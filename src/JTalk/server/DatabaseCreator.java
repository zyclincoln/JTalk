package JTalk.server;

import java.sql.*;

class DatabaseCreator {
	DatabaseCreator() {

	}
	void CreateDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/", "root", "");
			DatabaseMetaData databaseMetaData = connection.getMetaData();
		} catch(SQLException exception) {
			System.out.println(exception);
		} catch(ClassNotFoundException exception) {
			System.out.println(exception);
		}
	}
}
