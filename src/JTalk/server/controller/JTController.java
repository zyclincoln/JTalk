package JTalk.server.controller;

import JTalk.util.*;
import JTalk.server.util.*;
import JTalk.server.model.*;

import java.net.*;

public class JTController {
	JTDatabase database;
	LoginTable loginTable;
	JTCSignupManager signupManager;
	JTCLoginoutManager loginoutManager;
	JTCMessageManager messageManager;
	JTCMessageReceivedManager messageReceivedManager;

	public JTController() {
		database = new JTDatabase();
		loginTable = new LoginTable();
		signupManager = new JTCSignupManager(database);
		loginoutManager = new JTCLoginoutManager(database, loginTable);
		messageManager = new JTCMessageManager(database, loginTable);
		messageReceivedManager = new JTCMessageReceivedManager(database);
	}

	public void Init() {
		database.initial();
	}

	public void Run() {
		Thread thread_listener = new Thread(new JTCListener(signupManager, loginoutManager, messageManager, messageReceivedManager));
		thread_listener.start();
		try{
			thread_listener.join();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void Terminate() {
		database.Terminate();
	}
}
