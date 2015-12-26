package JTalk.server.model;
import JTalk.server.util.*;

class JTDBTerminateResult implements Message{
	int result_number;
	String message;
	public String toMessage(){
		if(result_number==0){
			return "JTDB terminate result: "+message;
		}
		else{
			return "JTDB terminate result: "+message;
		}
	}
}
