package JTalk.util;

public class MessageReceivedLog implements Message {
	int result_number;
	String message;

	MessageLog(int result_number, String message) {
		this.result_number;
		this.message = message;
	}

	String toMessage() {
		switch(result_number) {
			case 0:
				return "Success " + message;
			case 1:
				return "Failed " + message;
			case 2:
				return "Faild " + message;
		}
	}
}
