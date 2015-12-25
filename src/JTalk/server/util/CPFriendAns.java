package JTalk.server.util;

public class CPFriendAns extends ClientPackage{
	public int reciver_id;
	public int message_id;
	public long time;
	public boolean isAccept;
	public CPFriendAns(int reciver_id, int message_id, long time, boolean isAccept){
		this.reciver_id=reciver_id;
		this.message_id=message_id;
		this.time=time;
		this.isAccept=isAccept;
	};
}