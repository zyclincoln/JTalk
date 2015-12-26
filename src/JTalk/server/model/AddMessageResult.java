package JTalk.server.model;

import JTalk.server.util.*;

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
