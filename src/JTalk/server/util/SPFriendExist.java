package JTalk.server.util;

public class SPFriendExist extends ServerPackage{
	public int sender_id;
	public int message_id;
	public long time;
	public boolean exist;
	public SPFriendExist(int sender_id, int message_id, long time, boolean exist){
		this.sender_id=sender_id;
		this.message_id=message_id;
		this.time=time;
		this.exist=exist;
	};
}