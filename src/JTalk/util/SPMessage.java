package JTalk.util;

public class SPMessage extends ServerPackage {
	public int type;
	public int sender_id;
	public int message_id;
	public long time;
	public String content;

	SPMessage(int type, int sender_id, int message_id, long time, String content) {
		this.type = 0;
		this.sender_id = sender_id;
		this.message_id = message_id;
		this.time = time;
		this.content = content;
	}
}
