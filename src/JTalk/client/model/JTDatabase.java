package JTalk.client.model;

import java.sql.*;

public class JTDatabase {
	private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String protocol = "jdbc:derby:";
	String dbName = "firstdb";

	static void loadDriver() {
		try {
			Class.forName(driver).newInstance();
			System.out.println("Loaded the appropriate driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doIt() {
		Connection conn = null;
		Statement s = null;
		ResultSet rs = null;

		System.out.println("starting");
		try {
			conn = DriverManager.getConnection(protocol + dbName
			+ ";create=true");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Connected to and created database " + dbName);

		try {
			s=conn.createStatement();
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
			conn.close();
			conn = null;
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
