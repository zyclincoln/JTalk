package JTalk.server.util;

public class SPFriendAns extends ServerPackage{
	public int sender_id;
	public int message_id;
	public long time;
	public boolean ans;
	public SPFriendAns(int sender_id, int message_id, long time, boolean ans){
		this.sender_id=sender_id;
		this.message_id=message_id;
		this.time=time;
		this.ans=ans;
	};
}