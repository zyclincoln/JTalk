package JTalk.server.util;

import JTalk.util.*;

public class MessageReceivedLog implements Message {
	public int result_number;
	public String message;

	public MessageReceivedLog(int result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "Success: " + message;
			case 1:
				return "Failed: " + message;
			case 2:
				return "Failed: " + message;
			default:
				return null;
		}
	}
}
