package JTalk.server.model;

import JTalk.util.*;

class DeleteFriendResult implements Message {
	int result_number;
	String message;

	DeleteFriendResult(int result_number, String message) {
		this.result_number = result_number;
		this.message = message;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "DeleteFriend(): success";
			case 1:
				return "DeleteFriend(): invalid ID";
			case 2:
				return "DeleteFriend(): " + message;
			default:
				return null;
		}
	}
}
