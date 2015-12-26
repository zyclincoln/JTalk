package JTalk.server.util;
import java.util.*;

public class SPLogin extends ServerPackage{
	public boolean isSuc;
	public String name;
	public ArrayList<String> friends;
	public ArrayList<OfflineMessage> offlineMessage;
	public SPLogin(){
		this.isSuc=false;
	}
	public SPLogin(String name,ArrayList<String> friends,ArrayList<OfflineMessage> offlineMessage){
		this.isSuc=true;
		this.name=name;
		this.friends=friends;
		this.offlineMessage=offlineMessage;
	}
}