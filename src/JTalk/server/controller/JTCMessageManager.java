package JTalk.server.controller;

import JTalk.server.model.*;
import JTalk.server.util.*;
import JTalk.util.*;

public class JTCMessageManager {
	Integer message_id;
	JTDatabase database;
	LoginTable login_table;

	JTCMessageManager(JTDatabase database, LoginTable login_table) {
		this.database = database;
		this.login_table = login_table;
	}

	MessageLog ProcessMessage(int receiver_id, OfflineMessage message) {
		synchronized(message_id) {
			message_id++;
			message.message_id = message_id;
		}
		AddMessageResult add_message_result = database.AddMessage(receiver_id, message);
		if(add_message_result.result_number == 0) {
			Sender serder = login_table.getSender(receiver_id);
			serder.Deliver(new SPMessage(message));
			return new MessageLog(0, null);
		} else if(add_message_result.result_number == 1) {
			return new MessageLog(1, add_message_result.toMessage());
		}
		return new MessageLog(2, add_message_result.toMessage());
	}
}
