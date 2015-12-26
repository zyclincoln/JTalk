package JTalk.server.util;
import JTalk.util.*;
import JTalk.server.model.*;

public class LoginLog implements Message{
	public boolean isSuc;
	private AccountCheckResult result;
	private String info;
	public String toMessage(){
		if(isSuc==true){
			return "Login Operation Succeed. "+info +" "+result.toMessage();
		}
		else{
			return "Login Operation Failed. " + info + " "+result.toMessage();
		}
	}
	public LoginLog(boolean isSuc,AccountCheckResult result,String info){
		this.isSuc=isSuc;
		this.result=result;
		this.info=info;
	}
}