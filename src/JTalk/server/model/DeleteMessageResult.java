package JTalk.server.model;

import JTalk.util.*;

public class DeleteMessageResult implements Message {
	public int result_number;
	public String message;

	public DeleteMessageResult(int result_number, String message) {
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
