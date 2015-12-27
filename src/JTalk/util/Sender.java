package JTalk.util;

import java.io.*;
import java.net.*;

public class Sender {
	private String ip;
	private int port;

	public Sender(String ip, int port){
		this.ip = ip;
		this.port = port;
	}

	public void setSocket(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public synchronized int Deliver(JTPackage message){
		try{
			Socket receiver = new Socket(ip, port);
			ObjectOutputStream toReceiver = new ObjectOutputStream(receiver.getOutputStream());
			toReceiver.writeObject(message);
			toReceiver.flush();
			toReceiver.close();
			receiver.close();
			return 0;
		}
		catch(Exception e){
			System.out.println(e);
			return -1;
		}
	}
}
