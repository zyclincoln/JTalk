package JTalk.server.model;

import JTalk.server.util.*;

import java.util.ArrayList;
import java.sql.*;

class GetFriendResult implements Message {
	int result_number;
	String message;
	ArrayList<Integer> friend;

	GetFriendResult(int result_number, String message, ArrayList<Integer> friend) {
		this.result_number = result_number;
		this.message = message;
		this.friend = friend;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "GetFriend(): success";
			case 1:
				return "GetFriend(): invalid ID";
			case 2:
				return "GetFriend(): " + message;
			default:
				return null;
		}
	}
}

class AddFriendResult implements Message {
	int result_number;
	String message;

	AddFriendResult(int result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "AddFriend(): success";
			case 1:
				return "AddFriend(): invalid ID";
			case 2:
				return "AddFriend(): " + message;
			default:
				return null;
		}
	}
}

class DeleteFriendResult implements Message {
	int result_number;
	String message;

	DeleteFriendResult(int result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "DeleteFriend(): success";
			case 1:
				return "DeleteFriend(): invalid ID";
			case 2:
				return "DeleteFriend(): " + message;
			default:
				return null;
		}
	}
}

class JTDBFriend {
	private Connection connection;
	private PreparedStatement statement_get_friend;
	private PreparedStatement statement_add_friend;
	private PreparedStatement statement_delete_friend;

	JTDBFriend(Connection connection) {
		this.connection = connection;
		try {
			this.statement_get_friend = connection.prepareStatement("select id from Friend?");
			this.statement_add_friend = connection.prepareStatement("insert into Friend? values(?)");
			this.statement_delete_friend = connection.prepareStatement("delete from Friend? where id = ?");
		} catch(Exception exception) {
			System.out.println(exception);
		}
	}

	void Init() {

	}

	void Terminate() {

	}

	GetFriendResult GetFriend(int id) {
		try {
			ResultSet result_set = connection.getMetaData().getTables(null, null, "Friend" + id, null );
			if(result_set.next()) {
				statement_get_friend.setInt(1, id);
				result_set = statement_get_friend.executeQuery();
				ArrayList<Integer> friend = new ArrayList<Integer>();
				while(result_set.next())
					friend.add(result_set.getInt(1));
				return new GetFriendResult(0, null, friend);
			} else {
				return new GetFriendResult(1, null, null);
			}
		} catch(Exception exception) {
			return new GetFriendResult(2, exception + "", null);
		}
	}

	AddFriendResult AddFriend(int id_1, int id_2) {
		try {
			ResultSet result_set_1 = connection.getMetaData().getTables(null, null, "Friend" + id_1, null );
			ResultSet result_set_2 = connection.getMetaData().getTables(null, null, "Friend" + id_2, null );
			if(result_set_1.next() && result_set_2.next()) {
				statement_add_friend.setInt(1, id_1);
				statement_add_friend.setInt(2, id_2);
				statement_add_friend.executeUpdate();
				statement_add_friend.setInt(1, id_2);
				statement_add_friend.setInt(2, id_1);
				statement_add_friend.executeUpdate();
				return new AddFriendResult(0, null);
			} else {
				return new AddFriendResult(1, null);
			}
		} catch(Exception exception) {
			return new AddFriendResult(2, exception + "");
		}
	}

	DeleteFriendResult DeleteFriend(int id_1, int id_2) {
		try {
			ResultSet result_set_1 = connection.getMetaData().getTables(null, null, "Friend" + id_1, null );
			ResultSet result_set_2 = connection.getMetaData().getTables(null, null, "Friend" + id_2, null );
			if(result_set_1.next() && result_set_2.next()) {
				statement_delete_friend.setInt(1, id_1);
				statement_delete_friend.setInt(2, id_2);
				statement_delete_friend.executeUpdate();
				statement_delete_friend.setInt(1, id_2);
				statement_delete_friend.setInt(2, id_1);
				statement_delete_friend.executeUpdate();
				return new DeleteFriendResult(0, null);
			} else {
				return new DeleteFriendResult(1, null);
			}
		} catch(Exception exception) {
			return new DeleteFriendResult(2, exception + "");
		}
	}

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/JTalk", "root", "");

			JTDBFriend db_friend = new JTDBFriend(connection);

			for(int i = 1; i <= 2; i++) {
				AddFriendResult add_friend_result = db_friend.AddFriend(0, i);
				System.out.println(add_friend_result.toMessage());
			}
			System.out.println();

			GetFriendResult get_friend_result = db_friend.GetFriend(0);
			System.out.println(get_friend_result.toMessage());
			if(get_friend_result.result_number == 0)
				for(int i = 0; i < get_friend_result.friend.size(); i++)
					System.out.println("id: " + get_friend_result.friend.get(i));
			System.out.println();

			for(int i = 1; i <= 2; i++) {
				DeleteFriendResult delete_friend_result = db_friend.DeleteFriend(0, i);
				System.out.println(delete_friend_result.toMessage());
			}
			System.out.println();
		} catch(Exception exception) {
			System.out.println(exception);
		}
	}
}
