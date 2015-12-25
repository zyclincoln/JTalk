package JTalk.client;
import JTalk.server.util.*;
import java.net.*;
import java.io.*;

public class client_demo{
	public static void main(String[] args){
		try{
			Socket socket=new Socket("127.0.0.1",8000);
			ObjectOutputStream toServer=new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(new CPSignupReq("test_account1","123456"));
			ObjectInputStream fromServer=new ObjectInputStream(socket.getInputStream());
			SPSignupInfo info=(SPSignupInfo)fromServer.readObject();
			System.out.println(info.message_id);
			System.out.println(info.time);
			System.out.println(info.id);
			System.out.println(info.isSuc);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}