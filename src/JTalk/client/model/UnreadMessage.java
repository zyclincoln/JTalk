package JTalk.client.model;

import JTalk.util.*;

import java.util.*;

public class UnreadMessage implements Comparable {
	public int type;
	public long time;
	public String content;

	public UnreadMessage(int type, long time, String content) {
		this.type = type;
		this.time = time;
		this.content = content;
	}

	public UnreadMessage(OfflineMessage offline_message) {
		this.type = offline_message.type;
		this.time = offline_message.time;
		this.content = offline_message.content;
	}

	public int compareTo(Object um) {
		long time = ((UnreadMessage)um).time;
		if(this.time < time)
			return -1;
		else if(this.time == time)
			return 0;
		else return 1;
	}
}
