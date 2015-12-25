package JTalk.server.util;

public class SPFriendReq extends ServerPackage{
	public int sender_id;
	public int message_id;
	public long time;
	public String name;
	public SPFriendReq(int sender_id, int message_id, long time, String name){
		this.sender_id=sender_id;
		this.message_id=message_id;
		this.time=time;
		this.name=name;
	};
}