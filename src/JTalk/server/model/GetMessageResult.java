package JTalk.server.model;

import JTalk.util.*;

import java.util.ArrayList;

public class GetMessageResult implements Message {
	public int result_number;
	public String message;
	public ArrayList<OfflineMessage> offline_message;

	public GetMessageResult(int result_number, String message, ArrayList<OfflineMessage> offline_message) {
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
