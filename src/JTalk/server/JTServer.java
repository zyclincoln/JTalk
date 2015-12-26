package JTalk.server;

import JTalk.server.controller.*;

public class JTServer {
	public static void main(String[] argv) {
		JTController controller = new JTController();
		controller.Init();
		controller.Run();
		controller.Terminate();
	}
}
