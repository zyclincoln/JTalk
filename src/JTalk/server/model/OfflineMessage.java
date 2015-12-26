package JTalk.server.model;

class OfflineMessage {
	int type;
	int sender_id;
	int message_id;
	long time;
	String content;

	OfflineMessage(int type, int sender_id, int message_id, long time, String content) {
		this.type = 0;
		this.sender_id = sender_id;
		this.message_id = message_id;
		this.time = time;
		this.content = content;
	}

	public String toString() {
		return String.format("type: %d    sender_id: %d    message_id: %d    time: %d    content: %s", type, sender_id, message_id, time, content);
	}
}
