package JTalk.server.util;

public class SPLoginInfo extends ServerPackage{
	public int message_id;
	public long time;
	public boolean isSuc;
	public SPLoginInfo(int message_id, long time, boolean isSuc){
		this.message_id=message_id;
		this.time=time;
		this.isSuc=isSuc;
	};
}