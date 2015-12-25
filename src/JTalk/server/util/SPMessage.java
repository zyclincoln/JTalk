package JTalk.server.util;

public class SPMessage extends ServerPackage{
	public int sender_id;
	public int message_id;
	public long time;
	public String contents;
	public SPMessage(int sender_id, int message_id, long time, String contents){
		this.sender_id=sender_id;
		this.message_id=message_id;
		this.time=time;
		this.contents=contents;
	};
}