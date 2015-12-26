package JTalk.server.model;

import JTalk.server.util.*;

import java.util.ArrayList;

class GetFriendResult implements Message {
	int result_number;
	String message;
	ArrayList<Integer> friend;

	GetFriendResult(int result_number, String message, ArrayList<Integer> friend) {
		this.result_number = result_number;
		this.message = message;
		this.friend = friend;
	}

	public String toMessage() {
		switch(result_number) {
			case 0:
				return "GetFriend(): success";
			case 1:
				return "GetFriend(): invalid ID";
			case 2:
				return "GetFriend(): " + message;
			default:
				return null;
		}
	}
}
