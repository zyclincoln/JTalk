package JTalk.util;

public class SPMessage extends ServerPackage {
	public OfflineMessage offline_message;

	SPMessage(int type, int sender_id, int message_id, long time, String content) {
		this.offline_message = new OfflineMessage(int type, int sender_id, int message_id, long time, String content)
	}
}
