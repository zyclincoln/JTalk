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
			statement.executeUpdate("CREATE TABLE Friend" + id + " (id int, name char(20), primary key(id))");
			System.out.println("Account " + id + " added");
		} catch(Exception e) {
			System.out.println(e);
		}
		try {
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
			statement.executeUpdate("insert into Friend" + id + " values(" + friend_id + ", '" + friend_name + "')");
			statement.executeUpdate("create table Message" + id + "_" + friend_id + " (type int, time bigint, content varchar(255))");
			System.out.println(id + "'s friend " + friend_id + " added");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	void AddMessage(int id, OfflineMessage offline_message) {
		try {
			statement.executeUpdate("insert into Message" + id + "_" + offline_message.sender_id + " values(" + offline_message.type + ", " + offline_message.time + ", '" + offline_message.content + "')");
			System.out.println(id + "'s message added");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	void DeleteFriend(int id, int friend_id) {
		try {
			statement.executeUpdate("drop table Message" + id + "_" + friend_id);
			statement.executeUpdate("delete from Friend" + id + " where id = " + friend_id);
			System.out.println(id + "'s friend " + friend_id + " removed");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	void Terminate() {
		try {
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		JTDatabase db = new JTDatabase();
		db.Init();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "2");
		map.put(3, "3");
		db.AddAccount(1, map);
		db.AddFriend(1, 4, "4");
		db.AddMessage(1, new OfflineMessage(0, 2, 2, 2, "2"));
		db.DeleteFriend(1, 4);
		db.DeleteFriend(1, 2);
		db.Terminate();
	}
}
