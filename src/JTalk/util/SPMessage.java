package JTalk.util;

public class SPMessage extends ServerPackage {
	public OfflineMessage offline_message;

	SPMessage(int type, int sender_id, int message_id, long time, String content) {
		super.type=2;
		this.offline_message = new OfflineMessage(type, sender_id, message_id, time, content);
	}
}
