package JTalk.server.model;

import java.sql.*;

class JTDBFriend {
	private Connection connection;

	JTDBFriend(Connection connection) {
		this.connection = connection;
	}

	GetFriend(ID)

	void CreateDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/JTalk", "root", "");
			DatabaseMetaData databaseMetaData = connection.getMetaData();
		} catch(SQLException exception) {
			System.out.println(exception);
		} catch(ClassNotFoundException exception) {
			System.out.println(exception);
		}
	}
}

enum GetFriendResult

class GetFriendResult() {
	int result;
	String message;
	
}

Friend[ID] {
	ID
}

GetFriend(ID);
AddFriend(ID1, ID2);
DeleteFriend(ID1, ID2);