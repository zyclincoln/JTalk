package JTalk.client;

import JTalk.util.*;

import java.net.*;
import java.io.*;

public class JTClient {
	public static void main(String[] argv) {
		try {
			Socket socket = new Socket("127.0.0.1", 8086);
			ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
			
			toServer.writeObject(new CPSignupReq("2", "2"));
			toServer.flush();
			System.out.println("!");
			ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
			SPSignup p1 = (SPSignup)fromServer.readObject();
			System.out.println(p1.id);
			//socket = new Socket("127.0.0.1", 8086);
			//System.out.println("!");
			//toServer = new ObjectOutputStream(socket.getOutputStream());
			//System.out.println("!");
			Thread.sleep(5000);
			
			System.out.println("!");
			toServer.writeObject(new CPLoginReq(1, "1"));
			toServer.flush();
			System.out.println("!");
			SPLogin p2 = (SPLogin)fromServer.readObject();
			System.out.println("!");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
