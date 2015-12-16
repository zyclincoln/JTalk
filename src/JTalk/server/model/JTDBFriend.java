package JTalk.server.model;

import java.sql.*;

class GetFriendResult implements Message {
	GetFriendResultNumber result_number;
	String message;
	ArrayList<int> friend_id;

	GetFriendResult();

	GetFriendResult(GetFriendResultNumber result_number, String message, ArrayList<int> friend_id) {
		this.result_number = result_number;
		this.message = message;
		this.friend_id = friend_id;
	}

	String toString() {
		switch(result_number) {
			case 0:
				return "GetFriend(): success";
				break;
			case 1:
				return "GetFriend(): invalid ID";
				break;
			case 2:
				return "GetFriend(): " + message;
				break;
		}
	}
}

class AddFriendResult implements Message {
	ADDFriendResultNumber result_number;
	String message;

	AddFriendResult();

	AddFriendResult(AddFriendResultNumber result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	String toString() {
		switch(result_number) {
			case 0:
				return "AddFriend(): success";
				break;
			case 1:
				return "AddFriend(): invalid ID";
				break;
			case 2:
				return "AddFriend(): " + message;
				break;
		}
	}
}

class DeleteFriendResult implements Message {
	DeleteFriendResultNumber result_number;
	String message;

	DeleteFriendResult();

	DeleteFriendResult(DeleteFriendResultNumber result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	String toString() {
		switch(result_number) {
			case 0:
				return "DeleteFriend(): success";
				break;
			case 1:
				return "DeleteFriend(): invalid ID";
				break;
			case 2:
				return "DeleteFriend(): " + message;
				break;
		}
	}
}

class JTDBFriend {
	private Connection connection;
	private Statement statement;

	JTDBFriend(Connection connection) {
		this.connection = connection;
		this.statement = connection.createStatement();
	}

	void Init() {

	}

	void Terminate() {

	}

	GetFriendResult GetFriend(int id) {
		try {
			ResultSet result_set = connection.getMetaData().getTables(null, null, "Friend" + id, null );
			if(result_set.next()) {
				result_set = statement.executeQuery("select ID from Friend" + id);
				ArrayList<int> friend_id;
				while(result_set.next()) {
					String id = result_set.getString(1);
					if(IsIDInLoginTable(id))
						friend_id.add(Integer.parseInt());
				}
				return new GetFriendResult(0, null, friend_id);
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
				statement.executeQuery("insert into Friend" + id_1 + " values(" + id_2 + ")");
				statement.executeQuery("insert into Friend" + id_2 + " values(" + id_1 + ")");
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
				statement.executeQuery("delete from Friend" + id_1 + " where ID = " + id_2);
				statement.executeQuery("delete from Friend" + id_2 + " where ID = " + id_1);
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

			JTDBFriend dbf = new JTDBFriend();
 		} catch(SQLException exception) {
			System.out.println(exception);
		} catch(ClassNotFoundException exception) {
			System.out.println(exception);
		}
	}
}
