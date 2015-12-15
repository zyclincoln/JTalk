package JTalk.server.model;

import java.sql.*;

enum GetFriendResultNumber {
	SUCCESS, INVALID_ID, SYSTEM_ERROR
}

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
			case SUCCESS:
				return "GetFriend(): success";
				break;
			case INVALID_ID:
				return "GetFriend(): invalid ID";
				break;
			case SYSTEM_ERROR:
				return "GetFriend(): " + message;
				break;
		}
	}
}

enum AddFriendResultNumber {
	SUCCESS, INVALID_ID, SYSTEM_ERROR
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
			case SUCCESS:
				return "AddFriend(): success";
				break;
			case INVALID_ID:
				return "AddFriend(): invalid ID";
				break;
			case SYSTEM_ERROR:
				return "AddFriend(): " + message;
				break;
		}
	}
}

enum DeleteFriendResultNumber {
	SUCCESS, INVALID_ID, SYSTEM_ERROR
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
			case SUCCESS:
				return "DeleteFriend(): success";
				break;
			case INVALID_ID:
				return "DeleteFriend(): invalid ID";
				break;
			case SYSTEM_ERROR:
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
				return GetFriendResult(SUCCESS, null, friend_id);
			} else {
				return GetFriendResult(INVALID_ID, null, null);
			}
		} catch(Exception exception) {
			return GetFriendResult(SYSTEM_ERROR, exception + "", null);
		}
	}

	AddFriendResult AddFriend(int id_1, int id_2) {
		try {
			ResultSet result_set_1 = connection.getMetaData().getTables(null, null, "Friend" + id_1, null );
			ResultSet result_set_2 = connection.getMetaData().getTables(null, null, "Friend" + id_2, null );
			if(result_set_1.next() && result_set_2.next()) {
				statement.executeQuery("insert into Friend" + id_1 + " values(" + id_2 + ")");
				statement.executeQuery("insert into Friend" + id_2 + " values(" + id_1 + ")");
				return GetFriendResult(SUCCESS, null);
			} else {
				return GetFriendResult(INVALID_ID, null);
			}
		} catch(Exception exception) {
			return GetFriendResult(SYSTEM_ERROR, exception + "");
		}
	}

	DeleteFriendResult DeleteFriend(int id_1, int id_2) {
		try {
			ResultSet result_set_1 = connection.getMetaData().getTables(null, null, "Friend" + id_1, null );
			ResultSet result_set_2 = connection.getMetaData().getTables(null, null, "Friend" + id_2, null );
			if(result_set_1.next() && result_set_2.next()) {
				statement.executeQuery("delete from Friend" + id_1 + " where ID = " + id_2);
				statement.executeQuery("delete from Friend" + id_2 + " where ID = " + id_1);
				return GetFriendResult(SUCCESS, null);
			} else {
				return GetFriendResult(INVALID_ID, null);
			}
		} catch(Exception exception) {
			return GetFriendResult(SYSTEM_ERROR, exception + "");
		}
	}
}
