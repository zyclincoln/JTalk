package JTalk.server.model;

import JTalk.util.*;

class AddFriendResult implements Message {
	int result_number;
	String message;

	AddFriendResult(int result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "AddFriend(): success";
			case 1:
				return "AddFriend(): invalid ID";
			case 2:
				return "AddFriend(): " + message;
			default:
				return null;
		}
	}
}
