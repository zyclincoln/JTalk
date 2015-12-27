package JTalk.client.controller;

import JTalk.util.*;

import java.net.*;
import java.util.*;
import java.io.*;

public class JTCJobManager implements Runnable {
	Socket server;
	JTController controller;
	ObjectInputStream fromClient;

	public JTCJobManager(Socket server, JTController controller){
		this.server = server;
		this.controller = controller;
		try{
			fromClient=new ObjectInputStream(server.getInputStream());
		}
		catch(IOException e){
			System.out.println("Fatal error: Cannot get inputstream from :" + server.getInetAddress().getHostAddress());
		}
	}

	public void run() {
		ServerPackage sp;
		try {
			sp = (ServerPackage)fromClient.readObject();
		} catch(IOException e) {
			System.out.println("Warning: Cannot read from inputstrea of :" + server.getInetAddress().getHostAddress());
			return;
		} catch(ClassNotFoundException e) {
			System.out.println("Are you kidding me? "+ server.getInetAddress().getHostAddress());
			return;
		}

		switch(sp.type) {
			case 0: {
				SPSignup signup = (SPSignup)sp;
				controller.Signup(signup);
				break;
			}
			case 1: {
				SPLogin login = (SPLogin)sp;
				controller.Login(login);
				break;
			}
			case 2: {
				SPMessage message = (SPMessage)sp;
				controller.ProcessMessage(message);
				break;
			}
			default: {
				System.out.println("Warning!!!: Received Unknown Package. From " + server.getInetAddress().getHostAddress());
				break;
			}
		}
		try{
			fromClient.close();
			server.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
