package JTalk.server.model;

import JTalk.server.util.*;

import java.util.ArrayList;

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
