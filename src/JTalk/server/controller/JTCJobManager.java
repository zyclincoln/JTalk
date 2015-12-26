package JTalk.server.controller;
import JTalk.server.util.*;
import JTalk.util.*;
import java.net.*;
import java.io.*;

public class JTCJobManager implements Runnable{
	Socket client;
	JTCSignupManager signupManager;
	JTCLoginoutManager loginoutManager;
	JTCMessageManager messageManager;
	JTCMessageReceivedManager messageReceiveManager;
	ObjectInputStream fromClient;
	public JTCJobManager(Socket client, JTCSignupManager signupManager, JTCLoginoutManager loginoutManager,
	 JTCMessageManager messageManager, JTCMessageReceivedManager messageReceiveManager){
		this.client=client;
		try{
			fromClient=new ObjectInputStream(client.getInputStream());
		}
		catch(IOException e){
			System.out.println("Fatal error: Cannot get inputstream from :" + client.getInetAddress().getHostAddress());
		}
		this.signupManager=signupManager;
		this.loginoutManager=loginoutManager;
		this.messageReceiveManager=messageReceiveManager;
		this.messageManager=messageManager;
	}

	public void run(){
		ClientPackage cp;
		try{
			cp=(ClientPackage)(fromClient.readObject());
		}
		catch(IOException e){
			System.out.println("Warning: Cannot read from inputstrea of :" +client.getInetAddress().getHostAddress());
			return;
		}
		catch(ClassNotFoundException e){
			System.out.println("Are you kidding me? "+ client.getInetAddress().getHostAddress());
			return;
		}
		switch(cp.type){
			case 0:{
				CPSignupReq signupReq=(CPSignupReq)cp;
				SignupLog log=signupManager.Signup(client,client.getInetAddress().getHostAddress(),0,signupReq.name,signupReq.password);
				System.out.println(log.toMessage());
				break;
			}
			case 1:{
				CPLoginReq loginReq=(CPLoginReq)cp;
				LoginLog log=loginoutManager.Login(client,loginReq.id,loginReq.password,client.getInetAddress().getHostAddress());
				System.out.println(log.toMessage());
				break;
			}
			case 2:{
				CPMessage message=(CPMessage)cp;
				MessageLog log=messageManager.ProcessMessage(message.receiver_id,message.offline_message);
				System.out.println(log.toMessage());
				break;
			}
			case 3:{
				CPMessageReceived messageReceived=(CPMessageReceived)cp;
				MessageReceivedLog log=messageReceiveManager.DeleteMessage(messageReceived.id,messageReceived.global_message_id);
				System.out.println(log.toMessage());
				break;
			}
			default:{
				System.out.println("Warning!!!: Received Unknown Package. From "+client.getInetAddress().getHostAddress());
				break;
			}
		}
	}
}