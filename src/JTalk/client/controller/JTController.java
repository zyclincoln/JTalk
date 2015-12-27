package JTalk.client.controller;

import java.net.*;

public class JTController {
	JTDatabase database;

	public JTController() {
		database = new JTDatabase();
	}

	public void Init() {
		database.initial();
	}

	public void Run() {
		ServerSocket server_socket = new ServerSocket(0);
		Thread thread_listener = new Thread(new JTCListener(server_socket, this));
		thread_listener.start();
		// GUI
	}

	public void Terminate() {
		database.Terminate();
	}

	public void Signup(SPSignup signup) {

	}

	public void Login(SPLogin login) {

	}

	synchronized public void ProcessMessage(SPMessage message) {

	}
}
