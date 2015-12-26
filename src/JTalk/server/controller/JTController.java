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
	JTCMessageReceivedManager messageReceiveManager;

	public JTController() {
		database = new JTDatabase();
		loginTable = new LoginTable();
		signupManager = new JTCSignupManager(database);
		loginoutManager = new JTCLoginoutManager(database, loginTable);
		messageManager = new JTCMessageManager(database, loginTable);
		messageReceiveManager = new JTCMessageReceivedManager(database);
	}

	public void Init() {
		database.initial();
	}

	public void Run() {
		Thread thread_listener = new Thread.(new Listener(signupManager, loginoutManager, messageManager, messageReceivedManager));
		thread_listener.start();
		thread_listener.join();
	}

	public void Terminate() {
		database.Terminate();
	}
}
