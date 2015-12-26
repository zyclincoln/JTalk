package JTalk.server.util;
import java.util.*;

public class SPLogin extends ServerPackage{
	public boolean isSuc;
	public String name;
	public HashMap<Integer,String> friends;
	public ArrayList<OfflineMessage> offlineMessage;
	public SPLogin(){
		this.isSuc=false;
	}
	public SPLogin(String name,HashMap<Integer,String> friends,ArrayList<OfflineMessage> offlineMessage){
		this.isSuc=true;
		this.name=name;
		this.friends=friends;
		this.offlineMessage=offlineMessage;
	}
}