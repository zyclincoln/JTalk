package JTalk.server.model;
import JTalk.util.*;

public class AccountAddResult implements Message {
	public int result;
	public String causeinfo;
	public String toMessage(){
		if(result==0){
			return "Database: add succeeded.";
		}
		else{
			return "Database: add error: "+causeinfo;
		}
	}
	public int id;
}
