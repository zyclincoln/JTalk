package JTalk.server.util;

public class SPSignupInfo extends ServerPackage{
	public int message_id;
	public long time;
	public int id;
	public boolean isSuc;
	public SPSignupInfo(int message_id, long time, int id, boolean isSuc){
		this.message_id=message_id;
		this.time=time;
		this.id=id;
		this.isSuc=isSuc;
	};
}