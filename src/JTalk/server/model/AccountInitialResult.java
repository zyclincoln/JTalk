package JTalk.server.model;
import JTalk.util.*;

class AccountInitialResult implements Message {
	public int result;
	public String causeinfo;
	public String toMessage(){
		if(result==0){
			return "Database: Account Initial Succeeded!"+causeinfo;
		}
		else{
			return "Database: Account Initial Failed!"+causeinfo;
		}
	}
}
