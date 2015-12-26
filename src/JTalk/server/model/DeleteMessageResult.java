package JTalk.server.model;

import JTalk.server.util.*;

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
