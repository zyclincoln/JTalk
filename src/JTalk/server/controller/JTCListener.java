package JTalk.server.controller;
import JTalk.server.util.*;
import JTalk.util.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class JTCListener implements Runnable{
	ServerSocket serverSocket;
	ExecutorService executor;
	JTCSignupManager signupManager;
	JTCLoginoutManager loginoutManager;
	JTCMessageManager messageManager;
	JTCMessageReceivedManager messageReceiveManager;
	public JTCListener(JTCSignupManager signupManager, JTCLoginoutManager loginoutManager,
	 JTCMessageManager messageManager, JTCMessageReceivedManager messageReceiveManager){
		try{
			serverSocket=new ServerSocket(8086);
		}
		catch(IOException e){
			System.out.println("Fatal: JTCListener initial failed."+e);
		}
		executor=Executors.newCachedThreadPool();
		this.signupManager=signupManager;
		this.loginoutManager=loginoutManager;
		this.messageReceiveManager=messageReceiveManager;
		this.messageManager=messageManager;
	}

	public void run(){
		try{
			while(true){
				Socket client=serverSocket.accept();
				executor.execute(new JTCJobManager(client,signupManager,loginoutManager,messageManager,messageReceiveManager));
			}
		}
		catch(IOException e){
			System.out.println("Warning: JTCListener.run error." +e);
		}
	}
}
