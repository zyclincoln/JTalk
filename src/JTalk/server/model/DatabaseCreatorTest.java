package JTalk.server.model;

import java.sql.*;

class DatabaseCreatorTest {
	public static void main(String[] args) {
		DatabaseCreator database_creator = new DatabaseCreator();
		database_creator.CreateDatabase();
	}
}
