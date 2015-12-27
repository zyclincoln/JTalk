package JTalk.client.controller;

import JTalk.client.model.*;
import JTalk.util.*;

import java.net.*;

public class JTController {
	JTDatabase database;
	Sender sender;

	public JTController() {
		database = new JTDatabase();
		sender = new Sender("127.0.0.1", 8086);
	}

	public void Init() {
		database.Init();
	}

	public void Run() {
		ServerSocket server_socket;
		try {
			server_socket = new ServerSocket(0);
			Thread thread_listener = new Thread(new JTCListener(server_socket, this));
			thread_listener.start();
			Deliver(new CPSignupReq("2", "2", server_socket.getLocalPort()));
			Thread.sleep(1000);
			Deliver(new CPLoginReq(1, "1", server_socket.getLocalPort()));
			Thread.sleep(1000);
			Deliver(new CPMessage(1, new OfflineMessage(0, 1, 1, 1, "你好！")));
			Thread.sleep(1000);
			Deliver(new CPLogout(1));
		} catch(Exception e) {
			System.out.println(e);
		}
		while(true) {} // GUI
	}

	public void Terminate() {
		database.Terminate();
	}

	public void Signup(SPSignup signup) {
		System.out.println(signup.id);
	}

	public void Login(SPLogin login) {
		System.out.println(login.name);
	}

	synchronized public void ProcessMessage(SPMessage message) {
		System.out.println(message.offline_message.content);
		Deliver(new CPMessageReceived(1, message.offline_message.message_id));
	}

	public void Deliver(JTPackage message) {
		sender.Deliver(message);
	}
}
