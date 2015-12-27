package JTalk.client;

import JTalk.util.*;

import java.net.*;
import java.io.*;

public class JTClient {
	public static void main(String[] argv) {
		try {
			ServerSocket server_socket = new ServerSocket(0);
			new Thread(new Listener(server_socket)).start();
			Socket socket;
			ObjectOutputStream toServer;

			socket = new Socket("127.0.0.1", 8086);
			toServer = new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(new CPSignupReq("2", "2", server_socket.getLocalPort()));
			toServer.flush();

			socket = new Socket("127.0.0.1", 8086);
			toServer = new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(new CPLoginReq(1, "1", server_socket.getLocalPort()));
			toServer.flush();

			Thread.sleep(3000);

			socket = new Socket("127.0.0.1", 8086);
			toServer = new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(new CPMessage(1, new OfflineMessage(0, 1, 1, 1, "Hello!")));
			toServer.flush();

			Thread.sleep(3000);

			socket = new Socket("127.0.0.1", 8086);
			toServer = new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(new CPLogout(1));
			toServer.flush();
			System.out.println("!");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}

class Listener implements Runnable {
	ServerSocket server_socket;

	Listener(ServerSocket server_socket) {
		this.server_socket = server_socket;
	}

	public void run() {
		try {
			while(true) {
				Socket socket = server_socket.accept();	
				ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());

				ServerPackage sp = (ServerPackage)fromServer.readObject();
				switch(sp.type) {
					case 0:
						System.out.println(((SPSignup)sp).id);
						break;
					case 1:
						System.out.println(((SPLogin)sp).name);
						break;
					case 2: {
						System.out.println(((SPMessage)sp).offline_message.content);
						break;
					}
					default:
						break;
				}
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
