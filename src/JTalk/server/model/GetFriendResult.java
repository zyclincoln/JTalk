package JTalk.server.model;

import JTalk.util.*;

import java.util.ArrayList;

public class GetFriendResult implements Message {
	public int result_number;
	public String message;
	public ArrayList<Integer> friend;

	public GetFriendResult(int result_number, String message, ArrayList<Integer> friend) {
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
