package JTalk.server.util;
import JTalk.util.*;
import JTalk.server.model.*;

public class LogoutLog implements Message{
	public boolean isSuc;
	private String info;
	public String toMessage(){
		if(isSuc==true){
			return "Logout Operation Succeed. "+info ;
		}
		else{
			return "Logout Operation Failed. " + info ;
		}
	}
	public LogoutLog(boolean isSuc,String info){
		this.isSuc=isSuc;
		this.info=info;
	}
}