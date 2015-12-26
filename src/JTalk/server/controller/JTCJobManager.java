package JTalk.server.controller;
import JTalk.util.*;
import java.net.*;

public class JTCJobManager implements Runnable{
	Socket client;
	JTCSignupManager signupManager;
	JTCLoginoutManager loginoutManager;
	JTCMessageManager messageManager;
	JTCMessageReceivedManager messageReceiveManager;
	ObjectInputStream fromClient;
	public JTCJobmanager(Socket client, JTCSignupManager signupManager, JTCLoginoutManager loginoutManager,
	 JTCMessageManager messageManager, JTCMessageReceivedManager messageReceiveManager){
		this.client=client;
		fromClient=new ObjectInputStream(client.getInputStream);
		this.signupManager=signupManager;
		this.loginoutManager=loginoutManager;
		this.messageReceiveManager=messageReceiveManager;
		this.messageManager=this.messageManager;
	}

	public void run(){
		ClientPackage cp=(ClientPackage)(fromClient.readObject());
		switch(cp.type){
			case 0:
				CPSignupReq signupReq=(CPSignupReq)cp;
				SignupLog log=signupManager.Signup(client.getInetAddress().getHostAddress().toString(),0,signupReq.name,signupReq.password);
				System.out.println(log.toMessage());
				break;
			case 1:
				CPLoginReq loginReq=(CPLoginReq)cp;
				LoginLog log=loginoutManager.Login(loginReq.id,loginReq.password,client,getInetAddress().getHostAddress().toString());
				System.out.println(log.toMessage());
				break;
			case 2:
				CPMessage message=(CPMessage)cp;
				MessageLog log=messageManager.ProcessMessage(message.reciver_id,message.offline_message);
				System.out.println(log.toMessage());
				break;
			case 3:
				CPMessageReceived messageReceived=(CPMessageReceived)cp;
				MessageReceivedLog log=messageReceiveManager.DeleteMessage(messageReceived.id,messageReceived.global_message_id);
				System.out.println(log.toMessage());
				break;
			default:
				System.out.println("Warning!!!: Received Unknown Package. From "+client.getInetAddress().getHostAddress().toString());
				break;
		}
	}
}