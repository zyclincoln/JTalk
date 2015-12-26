package JTalk.server.model;

import JTalk.server.util.*;

import java.util.Formatter;
import java.util.Calendar;
import java.util.ArrayList;
import java.sql.*;

class JTDBOfflineMessage {
	private Connection connection;
	private PreparedStatement statement_get_message;
	private PreparedStatement statement_add_message;
	private PreparedStatement statement_delete_message;

	JTDBOfflineMessage(Connection connection) {
		this.connection = connection;
		try {
			this.statement_get_message = connection.prepareStatement("select * from OfflineMessage?");
			this.statement_add_message = connection.prepareStatement("insert into OfflineMessage? values(?, ?, ?, ?)");
			this.statement_delete_message = connection.prepareStatement("delete from OfflineMessage? where message_id = ?");
		} catch(Exception exception) {
			System.out.println(exception);
		}
	}

	void Init() {

	}

	void Terminate() {
		
	}

	GetMessageResult GetMessage(int id) {
		try {
			ResultSet result_set = connection.getMetaData().getTables(null, null, "OfflineMessage" + id, null );
			if(result_set.next()) {
				statement_get_message.setInt(1, id);
				result_set = statement_get_message.executeQuery();
				ArrayList<OfflineMessage> offline_message = new ArrayList<OfflineMessage>();
				while(result_set.next())
					offline_message.add(new OfflineMessage(result_set.getInt(1), result_set.getInt(2), result_set.getInt(3), result_set.getLong(4), result_set.getString(5)));
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
				statement_add_message.setInt(1, id);
				statement_add_message.setInt(2, offline_message.sender_id);
				statement_add_message.setInt(3, offline_message.message_id);
				statement_add_message.setLong(4, offline_message.time);
				statement_add_message.setString(5, offline_message.content);
				statement_add_message.executeUpdate();
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
				statement_delete_message.setInt(1, id);
				statement_delete_message.setInt(2, message_id);
				statement_delete_message.executeUpdate();
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
				AddMessageResult add_message_result = db_offline_message.AddMessage(0, new OfflineMessage(0, 1, i, calendar.getTimeInMillis(), "hello"));
				System.out.println(add_message_result.toMessage());				
			}
			System.out.println();

			GetMessageResult get_message_result = db_offline_message.GetMessage(0);
			System.out.println(get_message_result.toMessage());
			if(get_message_result.result_number == 0)
				for(int i = 0; i < get_message_result.offline_message.size(); i++)
					System.out.println(get_message_result.offline_message.get(i));
			System.out.println();

			for(int i = 1; i < 10; i++) {
				DeleteMessageResult delete_message_result = db_offline_message.DeleteMessage(0, i);
				System.out.println(delete_message_result.toMessage());	
			}
			System.out.println();
 		} catch(Exception exception) {
			System.out.println(exception);
		}
	}
}
