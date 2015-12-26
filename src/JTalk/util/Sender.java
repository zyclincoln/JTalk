package JTalk.util;
import java.io.*;
import java.net.*;

public class Sender{
	private String ip;
	private int port;
	public Sender(String ip,int port){
		this.ip=ip;
		this.port=port;
	}

	public synchronized int Deliver(ServerPackage message){
		try{
			Socket client=new Socket(ip,port);
			ObjectOutputStream toClient=new ObjectOutputStream(client.getOutputStream());
			switch(message.type){
				case 0:	
					toClient.writeObject((SPSignup)message);break;
				case 1:
					toClient.writeObject((SPLogin)message);break;
				case 2:
					toClient.writeObject((SPMessage)message);break;
			}
			toClient.flush();
			toClient.close();
			client.close();
			return 0;
		}
		catch(Exception e){
			System.out.println(e);
			return -1;
		}
	}
}