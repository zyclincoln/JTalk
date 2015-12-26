package JTalk.client.model;

import java.sql.*;

public class JTDBAccount {
	JTDBAccount() {

	}

	void AddAccount(int id) {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby:Account" + id + ";create=true");
			connection.close();

		} catch(Exception e) {
			System.println(e);
		}
	}
		try {
			connection.close();
			connection = null;
			s.close();
			s = null;
			rs.close();
			rs = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.loadDriver();
		t.doIt();
	}
}
