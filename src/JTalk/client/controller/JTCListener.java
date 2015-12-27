package JTalk.server.controller;

import java.net.*;
import java.util.concurrent.*;

public class JTCListener implements Runnable {
	ServerSocket serverSocket;
	ExecutorService executor;
	JTController controller;

	public JTCListener(ServerSocket serverSocket, JTController controller) {
		this.serverSocket = serverSocket;
		this.controller = controller;
		this.executor = Executors.newCachedThreadPool();
	}

	public void run() {
		try{
			while(true) {
				Socket client = serverSocket.accept();
				executor.execute(new JTCJobManager(client, controller));
			}
		} catch(Exception e){
			System.out.println("Warning: JTCListener.run() error." + e);
		}
	}
}
