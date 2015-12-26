package JTalk.util;

public class CPMessage extends ClientPackage{
	public int reciver_id;
	public int message_id;
	public long time;
	public String contents;
	public CPMessage(int revicer_id, int message_id, long time, String contents){
		this.reciver_id=reciver_id;
		this.message_id=message_id;
		this.time=time;
		this.contents=contents;
	};
}