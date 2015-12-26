package JTalk.util;

public class CPMessage extends ClientPackage {
	public int receiver_id;
	public OfflineMessage offline_message;

	CPMessage(int receiver_id, int type, int sender_id, int message_id, long time, String content) {
		this.receiver_id = receiver_id;
		this.offline_message = new OfflineMessage(int type, int sender_id, int message_id, long time, String content);
	};
}
