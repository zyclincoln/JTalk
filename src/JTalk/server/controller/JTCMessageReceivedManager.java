package JTalk.server.controller;

import JTalk.server.model.*;
import JTalk.server.util.*;
import JTalk.util.*;

public class JTCMessageReceivedManager {
	JTDatabase database;

	JTCMessageReceivedManager(JTDatabase database) {
		this.database = database;
	}

	MessageReceivedLog DeleteMessage(int id, int message_id) {
		DeleteMessageResult delete_message_result = database.DeleteMessage(id, message_id);
		if(delete_message_result.result_number == 0) {
			return new MessageReceivedLog(0, delete_message_result.toMessage());
		} else if(delete_message_result.result_number == 1) {
			return new MessageReceivedLog(1, delete_message_result.toMessage());
		}
		return new MessageReceivedLog(2, delete_message_result.toMessage());
	}
}
