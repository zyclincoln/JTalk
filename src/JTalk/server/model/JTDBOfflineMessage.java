package JTalk.server.model;

import java.sql.*;

class OfflineMessage {
	int sender_id;
	int message_id;
	java.util.Date time;
	String content;

	OfflineMessage(int sender_id, int message_id, java.util.Data time, String content) {
		this.sender_id = sender_id;
		this.message_id = message_id;
		this.time = time;
		this.content = content;
	}
}

enum GetMessageResultNumber {
	SUCCESS, INVALID_ID, SYSTEM_ERROR
}

class GetMessageResult implements Message {
	GetMessageResultNumber result_number;
	String message;
	ArrayList<OfflineMessage> offline_message;

	GetMessageResult();

	GetMessageResult(GetMessageResultNumber result_number, String message, ArrayList<OfflineMessage> offline_message) {
		this.result_number = result_number;
		this.message = message;
		this.offline_message = offline_message;
	}

	String toString() {
		switch(result_number) {
			case SUCCESS:
				return "GetMessage(): success";
				break;
			case INVALID_ID:
				return "GetMessage(): invalid ID";
				break;
			case SYSTEM_ERROR:
				return "GetMessage(): " + message;
				break;
		}
	}
}

enum AddMessageResultNumber {
	SUCCESS, INVALID_ID, SYSTEM_ERROR
}

class AddMessageResult implements Message {
	AddMessageResultNumber result_number;
	String message;

	AddMessageResult();

	AddMessageResult(AddMessageResultNumber result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	String toString() {
		switch(result_number) {
			case SUCCESS:
				return "AddMessage(): success";
				break;
			case INVALID_ID:
				return "AddMessage(): invalid ID";
				break;
			case SYSTEM_ERROR:
				return "AddMessage(): " + message;
				break;
		}
	}
}

enum DeleteMessageResultNumber {
	SUCCESS, INVALID_ID, SYSTEM_ERROR
}

class DeleteMessageResult implements Message {
	DeleteMessageResultNumber result_number;
	String message;

	DeleteMessageResult();

	DeleteMessageResult(DeleteMessageResultNumber result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	String toString() {
		switch(result_number) {
			case SUCCESS:
				return "DeleteMessage(): success";
				break;
			case INVALID_ID:
				return "DeleteMessage(): invalid ID";
				break;
			case SYSTEM_ERROR:
				return "DeleteMessage(): " + message;
				break;
		}
	}
}

class JTDBOfflineMessage {
	private Connection connection;
	private Statement statement;

	JTDBOfflineMessage(Connection connection) {
		this.connection = connection;
		this.statement = connection.createStatement();
	}

	void Init() {

	}

	void Terminate() {
		
	}

	GetMessageResult GetMessage(int id) {
		try {
			ResultSet result_set = connection.getMetaData().getTables(null, null, "OfflineMessage" + id, null );
			if(result_set.next()) {
				result_set = statement.executeQuery("select * from OfflineMessage" + id);
				ArrayList<OfflineMessage> offline_message;
				while(result_set.next())
					offline_message.add(OfflineMessage(result_set.getString(1), result_set.getString(2), result_set.getString(3), result_set.getString(4)));
				return GetFriendResult(SUCCESS, null, offline_message);
			} else {
				return GetFriendResult(INVALID_ID, null, null);
			}
		} catch(Exception exception) {
			return GetFriendResult(SYSTEM_ERROR, exception + "", null);
		}
	}

	AddMessageResult AddMessage(int id, OfflineMessage offline_message) {
		try {
			ResultSet result_set = connection.getMetaData().getTables(null, null, "OfflineMessage" + id, null );
			if(result_set.next()) {
				statement.executeQuery("insert into OfflineMessage" + id + " values(" + offline_message.sender_id + ", " +  offline_message.message_id + ", " + offline_message.time + ", " + offline_message.content + ")");
				return GetFriendResult(SUCCESS, null);
			} else {
				return GetFriendResult(INVALID_ID, null);
			}
		} catch(Exception exception) {
			return GetFriendResult(SYSTEM_ERROR, exception + "");
		}
	}

	DeleteMessageResult DeleteMessage(int id, int message_id) {
		try {
			ResultSet result_set = connection.getMetaData().getTables(null, null, "OfflineMessage" + id, null );
			if(result_set.next()) {
				statement.executeQuery("delete from OfflineMessage" + id + " where MessageID = " + offline_message.message_id);
				return DeleteFriendResult(SUCCESS, null);
			} else {
				return DeleteFriendResult(INVALID_ID, null);
			}
		} catch(Exception exception) {
			return DeleteFriendResult(SYSTEM_ERROR, exception + "");
		}
	}
}
