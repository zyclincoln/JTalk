package JTalk.client.model;

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

	public int compareTo(Object um) {
		long time = ((UnreadMessage)um).time;
		if(this.time < time)
			return -1;
		else if(this.time == time)
			return 0;
		else return 1;
	}
}
