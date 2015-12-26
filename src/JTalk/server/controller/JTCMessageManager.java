package JTalk.server.controller;

import JTalk.server.model.*;
import JTalk.util.*;

public class JTCMessageManager {
	int message_id;
	JTDatabase database;
	LoginTable login_table;

	JTCMessageManager(JTDatabase database, LoginTable login_table) {
		this.database = database;
		this.login_table = login_table;
	}

	MessageLog ProcessMessage(int receiver_id, OfflineMessage offline_message) {
		synchronized(message_id) {
			message_id++;
			offline_message.messageID = message_id;
		}
		AddMessageResult add_message_result = database.AddMessage(receiver_id, message);
		if(add_message_result.result_num == 0) {
			login_table.getSender(receiver_id);
			Deliver(OfflineMessage);
			return new MessageLog(0, null);
		} else if(add_message_result.result_num == 1) {
			return new MessageLog(1, add_message_result.toMessage());
		}
		return new MessageLog(2, add_message_result.toMessage());
	}
}
