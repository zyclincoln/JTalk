package JTalk.util;
import java.io.*;
import java.net.*;

public class Sender{
	private String ip;
	private Socket client;
	private ObjectOutputStream toClient;
	public Sender(Socket client){
		try{
			this.client=client;
			toClient=new ObjectOutputStream(client.getOutputStream());
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public synchronized int Deliver(ServerPackage message){
		try{
			switch(message.type){
				case 0:	
					toClient.writeObject((SPSignup)message);break;
				case 1:
					toClient.writeObject((SPLogin)message);break;
				case 2:
					toClient.writeObject((SPMessage)message);break;
			}
			toClient.flush();
			return 0;
		}
		catch(Exception e){
			System.out.println(e);
			return -1;
		}
	}
}