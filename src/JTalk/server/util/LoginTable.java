package JTalk.server.util;
import java.util.*;
import JTalk.util.*;
import java.net.*;

public class LoginTable{
	private Map<Integer,Sender>table;
	public LoginTable(){
		table=new HashMap<Integer,Sender>();
	}
	public synchronized int Login(int id, Socket client){
		Sender sender=new Sender(client);
		table.remove(id);
		table.put(id,sender);
		return 0;
	}
	public synchronized int Logout(int id){
		if(table.remove(id)!=null){
			return 0;
		}
		else{
			return -1;
		}
	}
	public Sender getSender(int id){
		return table.get(id);
	}
}