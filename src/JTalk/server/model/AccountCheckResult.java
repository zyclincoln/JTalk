package JTalk.server.model;
import JTalk.server.util.*;

class AccountCheckResult implements Message {
	public int result;
	public String causeinfo;
	public String toMessage(){
		if(result==0){
			return "Database: check succeeded.";
		}
		else{
			return "Database: check error: "+causeinfo;
		}
	}
	public String name;
	public String loginIP;
	public String loginTime;
}
