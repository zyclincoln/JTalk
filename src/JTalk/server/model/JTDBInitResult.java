package JTalk.server.model;
import JTalk.server.util.*;

class JTDBInitResult implements Message{
	int result_number;
	String message;
	public String toMessage(){
		if(result_number==0){
			return "JTDB initial result: "+message;
		}
		else{
			return "JTDB initial result: "+message;
		}
	}
}
