package JTalk.server.util;

public class SPSignupInfo extends ServerPackage{
	public int message_id;
	public long time;
	public int id;
	public SPSignupInfo(int message_id, long time, int id){
		this.message_id=message_id;
		this.time=time;
		this.id=id;
	};
}