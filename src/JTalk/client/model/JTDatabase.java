package JTalk.client.model;

import JTalk.util.*;

import java.sql.*;
import java.util.*;

public class JTDatabase {
	Connection connection;
	private Statement statement;

	public void Init() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			connection = DriverManager.getConnection("jdbc:derby:CDB;create=true");
			statement = connection.createStatement();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void AddAccount(int id, HashMap<Integer, String> friends) {
		try {
			statement.executeUpdate("CREATE TABLE Friend" + id + " (id int, name char(20), has_unread int, primary key(id))");
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

	public void AddFriend(int id, int friend_id, String friend_name) {
		try {
			statement.executeUpdate("insert into Friend" + id + " values(" + friend_id + ", '" + friend_name + "', 0)");
			statement.executeUpdate("create table Message" + id + "_" + friend_id + " (type int, time bigint, content varchar(255), unread int)");
			System.out.println(id + "'s friend " + friend_id + " added");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void AddMessage(int id, OfflineMessage offline_message) {
		try {
			statement.executeUpdate("insert into Message" + id + "_" + offline_message.sender_id + " values(" + offline_message.type + ", " + offline_message.time + ", '" + offline_message.content + "', 1)");
			statement.executeUpdate("update Friend" + id + " set has_unread = 1 where id = " + offline_message.sender_id);
			System.out.println(id + "'s message from " + offline_message.sender_id + " added");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public HashMap<Integer, Boolean> GetMessageState(int id) {
		try {
			HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
			ResultSet result = statement.executeQuery("select id, has_unread from Friend" + id);
			while(result.next()) {
				map.put(result.getInt("id"), result.getInt("has_unread") == 1);
			}
			System.out.println(id + "'s messages' state got");
			return map;
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<UnreadMessage> GetUnreadMessage(int id, int friend_id) {
		try {
			ArrayList<UnreadMessage> al = new ArrayList<UnreadMessage>();
			ResultSet result = statement.executeQuery("select * from Message" + id + "_" + friend_id + " where unread = 1");
			while(result.next()) {
				al.add(new UnreadMessage(result.getInt("type"), result.getLong("time"), result.getString("content")));
			}
			statement.executeUpdate("update Message" + id + "_" + friend_id + " set unread = 0 where unread = 1");
			System.out.println(id + "'s unread messages from " + friend_id + " got");
			Comparator<UnreadMessage> comparator = new Comparator<UnreadMessage>() {
				public int compare(UnreadMessage um1, UnreadMessage um2) {
					if(um1.time < um2.time)
						return -1;
					else if(um1.time == um2.time)
						return 0;
					else return 1;
				}
			};
			Collections.sort(al, comparator);
			return al;
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void DeleteFriend(int id, int friend_id) {
		try {
			statement.executeUpdate("drop table Message" + id + "_" + friend_id);
			statement.executeUpdate("delete from Friend" + id + " where id = " + friend_id);
			System.out.println(id + "'s friend " + friend_id + " removed");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void Terminate() {
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
		db.AddMessage(1, new OfflineMessage(0, 4, 4, 4, "4"));
		HashMap<Integer, Boolean> m = db.GetMessageState(1);
		Iterator it = m.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			System.out.println("MessageState: id: " + entry.getKey() + " has_unread: " + entry.getValue());
		}
		ArrayList<UnreadMessage> al = db.GetUnreadMessage(1, 4);
		Iterator<UnreadMessage> iterator = al.iterator();
		while(iterator.hasNext()){
			UnreadMessage um = iterator.next();
			System.out.println("Message: type: " + um.type + " time: " + um.time + " content: " + um.content);
		}
		db.AddMessage(1, new OfflineMessage(0, 4, 4, 44, "44"));
		db.AddMessage(1, new OfflineMessage(0, 4, 4, 444, "444"));
		db.AddMessage(1, new OfflineMessage(0, 4, 4, 4, "4"));
		al = db.GetUnreadMessage(1, 4);
		iterator = al.iterator();
		while(iterator.hasNext()){
			UnreadMessage um = iterator.next();
			System.out.println("Message: type: " + um.type + " time: " + um.time + " content: " + um.content);
		}
		db.DeleteFriend(1, 4);

		db.Terminate();
	}
}
