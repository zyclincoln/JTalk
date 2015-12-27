package JTalk.util;

public class CPMessageReceived extends ClientPackage {
	public int id;
	public int message_id;

	public CPMessageReceived(int id, int message_id) {
		super.type=3;
		this.id = id;
		this.message_id = message_id;
	};
}
