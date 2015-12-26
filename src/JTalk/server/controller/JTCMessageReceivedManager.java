package JTalk.server.controller;

import JTalk.server.model.*;
import JTalk.util.*;

public class JTCMessageReceivedManager {
	JTDatabase database;

	JTCMessageManager(JTDatabase database) {
		this.database = database;
	}

	MessageReceivedLog DeleteMessage(int id, int message_id) {
		DeleteMessageResult delete_message_result = database.DeleteMessage(int id, int message_id);
		if(delete_message_result.result_num == 0) {
			return new MessageReceivedLog(0, null);
		} else if(add_message_result.result_num == 1) {
			return new MessageReceivedLog(1, add_message_result.toMessage());
		}
		return new MessageReceivedLog(2, add_message_result.toMessage());
	}
}
