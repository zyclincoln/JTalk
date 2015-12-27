package JTalk.client;

import JTalk.client.controller.*;

public class JTClient {
	public static void main(String[] argv) {
		JTController controller = new JTController();
		controller.Init();
		controller.Run();
		controller.Terminate();
	}
}
