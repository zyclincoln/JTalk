package JTalk.server.model;

import JTalk.util.*;

class ClearMessageResult implements Message {
	int result_number;
	String message;

	ClearMessageResult(int result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "ClearMessage(): success";
			case 1:
				return "ClearMessage(): invalid ID";
			case 2:
				return "ClearMessage(): " + message;
			default:
				return null;
		}
	}
}
