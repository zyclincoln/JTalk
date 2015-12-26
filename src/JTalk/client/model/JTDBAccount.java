package JTalk.client.model;

import java.sql.*;

public class JTDBAccount {
	JTDBAccount() {

	}

	void AddAccount(int id) {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby:Account" + id + ";create=true");

		} catch(Exception e) {
			System.println(e);
		}
	}

	public void doIt() {
		Connection connection = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(protocol + dbName + ";create=true");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Connected to and created database " + dbName);

		try {
			s=connection.createStatement();
			s.executeUpdate("create table firsttable(id int)");
			s.executeUpdate("")
			rs=s.executeQuery("select * from firsttable");

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
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
