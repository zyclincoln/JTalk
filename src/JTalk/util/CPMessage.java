package JTalk.util;

public class CPMessage extends ClientPackage {
	public int type;
	public int sender_id;
	public int receiver_id;
	public int message_id;
	public long time;
	public String content;

	public CPMessage(int type, int sender_id, int revicer_id, int message_id, long time, String content) {
		this.type = type;
		this.sender_id = sender_id;
		this.reciver_id = reciver_id;
		this.message_id = message_id;
		this.time = time;
		this.content = content;
	};
}
