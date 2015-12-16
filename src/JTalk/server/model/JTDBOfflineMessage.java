package JTalk.server.model;

import JTalk.server.util.*;

import java.util.Formatter;
import java.util.Calendar;
import java.util.ArrayList;
import java.sql.*;

class OfflineMessage {
	int sender_id;
	int message_id;
	long time;
	String content;

	OfflineMessage(int sender_id, int message_id, long time, String content) {
		this.sender_id = sender_id;
		this.message_id = message_id;
		this.time = time;
		this.content = content;
	}

	public String toString() {
		return String.format("sender_id: %d    message_id: %d    time: %d    content: %s", sender_id, message_id, time, content);
	}
}

class GetMessageResult implements Message {
	int result_number;
	String message;
	ArrayList<OfflineMessage> offline_message;

	GetMessageResult(int result_number, String message, ArrayList<OfflineMessage> offline_message) {
		this.result_number = result_number;
		this.message = message;
		this.offline_message = offline_message;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "GetMessage(): success";
			case 1:
				return "GetMessage(): invalid ID";
			case 2:
				return "GetMessage(): " + message;
			default:
				return null;
		}
	}
}

class AddMessageResult implements Message {
	int result_number;
	String message;

	AddMessageResult(int result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "AddMessage(): success";
			case 1:
				return "AddMessage(): invalid ID";
			case 2:
				return "GetMessage(): " + message;
			default:
				return null;
		}
	}
}

class DeleteMessageResult implements Message {
	int result_number;
	String message;

	DeleteMessageResult(int result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "DeleteMessage(): success";
			case 1:
				return "DeleteMessage(): invalid ID";
			case 2:
				return "GetMessage(): " + message;
			default:
				return null;
		}
	}
}

class JTDBOfflineMessage {
	private Connection connection;
	private Statement statement;

	JTDBOfflineMessage(Connection connection) {
		this.connection = connection;
		try {
			this.statement = connection.createStatement();
		} catch(Exception exception) {}
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
				ArrayList<OfflineMessage> offline_message = new ArrayList<OfflineMessage>();
				while(result_set.next())
					offline_message.add(new OfflineMessage(result_set.getInt(1), result_set.getInt(2), result_set.getLong(3), result_set.getString(4)));
				return new GetMessageResult(0, null, offline_message);
			} else {
				return new GetMessageResult(1, null, null);
			}
		} catch(Exception exception) {
			return new GetMessageResult(2, exception + "", null);
		}
	}

	AddMessageResult AddMessage(int id, OfflineMessage offline_message) {
		try {
			ResultSet result_set = connection.getMetaData().getTables(null, null, "OfflineMessage" + id, null );
			if(result_set.next()) {
				statement.executeUpdate("insert into OfflineMessage" + id + " values(" + offline_message.sender_id + ", " +  offline_message.message_id + ", '" + offline_message.time + "', '" + offline_message.content + "')");
				return new AddMessageResult(0, null);
			} else {
				return new AddMessageResult(1, null);
			}
		} catch(Exception exception) {
			return new AddMessageResult(2, exception + "");
		}
	}

	DeleteMessageResult DeleteMessage(int id, int message_id) {
		try {
			ResultSet result_set = connection.getMetaData().getTables(null, null, "OfflineMessage" + id, null );
			if(result_set.next()) {
				statement.executeUpdate("delete from OfflineMessage" + id + " where message_id = " + message_id);
				return new DeleteMessageResult(0, null);
			} else {
				return new DeleteMessageResult(1, null);
			}
		} catch(Exception exception) {
			return new DeleteMessageResult(2, exception + "");
		}
	}

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/JTalk", "root", "");
			JTDBOfflineMessage db_offline_message = new JTDBOfflineMessage(connection);

			Calendar calendar = Calendar.getInstance();
			for(int i = 1; i < 10; i++) {
				AddMessageResult add_message_result = db_offline_message.AddMessage(0, new OfflineMessage(1, i, calendar.getTimeInMillis(), "hello"));
				System.out.println(add_message_result.toMessage());				
			}
			System.out.println();

			GetMessageResult get_message_result = db_offline_message.GetMessage(0);
			System.out.println(get_message_result.toMessage());
			if(get_message_result.result_number == 0) {
				for(int i = 0; i < get_message_result.offline_message.size(); i++) {
					System.out.println(get_message_result.offline_message.get(i));
				}
			}
			System.out.println();

			for(int i = 1; i < 10; i++) {
				DeleteMessageResult delete_message_result = db_offline_message.DeleteMessage(0, i);
				System.out.println(delete_message_result.toMessage());	
			}
 		} catch(SQLException exception) {
			System.out.println(exception);
		} catch(ClassNotFoundException exception) {
			System.out.println(exception);
		}
	}
}
