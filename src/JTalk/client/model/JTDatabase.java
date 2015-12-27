package JTalk.client.model;

import JTalk.util.*;

import java.sql.*;
import java.util.*;

public class JTDatabase {
	Connection connection;
	private Statement statement;

	void Init() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			connection = DriverManager.getConnection("jdbc:derby:CDB;create=true");
			statement = connection.createStatement();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	void AddAccount(int id, HashMap<Integer, String> friends) {
		try {
			statement.executeUpdate("CREATE TABLE Friend" + id + " (id int, name char(20))");
			Iterator it;
			if(friends != null) {
				it = friends.entrySet().iterator();
				while(it.hasNext()) {
					Map.Entry entry = (Map.Entry)it.next();
					AddFriend(id, (Integer)entry.getKey(), (String)entry.getValue());
				}
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	void AddFriend(int id, int friend_id, String friend_name) {
		try {
			statement.executeUpdate("insert into Friend" + id + " values(" + friend_id + ", " + friend_name + ")");
			statement.executeUpdate("create table Message" + id + "_" + friend_id + " (type int, time bigint, content varchar(255))");		
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	void AddMesasge(int id, OfflineMessage offline_message) {
		try {
			statement.executeUpdate("insert into Message" + id + "_" + offline_message.sender_id + " values(" + offline_message.type + ", " + offline_message.time + ", " + offline_message.content + ")");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	void Terminate() {

	}

	public static void main(String[] args) {
		JTDatabase db = new JTDatabase();
		db.Init();
		db.AddAccount(1, null);
		db.Terminate();
	}
}
