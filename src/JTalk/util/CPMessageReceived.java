package JTalk.util;

public class CPMessageReceived extends ClientPackage {
	public int id;
	public int global_message_id;

	public CPMessageReceived(int id, int global_message_id) {
		super.type=3;
		this.id = id;
		this.global_message_id = global_message_id;
	};
}
