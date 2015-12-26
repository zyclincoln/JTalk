package JTalk.util;

public class CPFriendReq extends ClientPackage{
	public int reciver_id;
	public int message_id;
	public long time;
	public CPFriendReq(int reciver_id, int message_id, long time){
		this.reciver_id=reciver_id;
		this.message_id=message_id;
		this.time=time;
	};
}