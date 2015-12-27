package JTalk.client.model;

import java.sql.*;
import java.util.*;

public class JTDBAccount {
	Connection connection;
	private PreparedStatement statement_get_friend;
	private PreparedStatement statement_add_friend;
	private PreparedStatement statement_delete_friend;

	JTDBAccount(Connection connection) {
		this.connection = connection;
	}

	void UpdateAccount(int id, HashMap<Integer,String> friends) {
		

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby:CDB;create=true");
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		JTDBAccount account = new JTDBAccount();
		account.AddAccount(1);
	}
}
