package JTalk.client.controller;

import JTalk.client.model.*;
import JTalk.client.view.*;
import JTalk.util.*;

import java.net.*;
import java.util.*;

public class JTController {
	JTDatabase database;
	Sender sender;
	JTCView view;
	FriendList friendList;
	ServerSocket server_socket;
	int me;

	public JTController() {
		database = new JTDatabase();
		sender = new Sender("127.0.0.1", 8086);
		LoginListener loginListener = new LoginListener();
		SignupListener signupListener = new SignupListener();
		SignupConfirmListener signupConfirmListener = new SignupConfirmListener();
		view = new JTCView(this, loginListener, signupListener, signupConfirmListener);
		loginListener.addView(view);
		signupListener.addView(view);
		signupConfirmListener.addView(view);
		friendList = new FriendList();
	}	

	public void Init() {
		database.Init();
	}

	public void Run() {
		try {
			server_socket = new ServerSocket(0);
			Thread thread_listener = new Thread(new JTCListener(server_socket, this));
			thread_listener.start();
			view.setLoginVisible(true);

//			Deliver(new CPSignupReq("2", "2", server_socket.getLocalPort()));
//			Thread.sleep(1000);
//			Deliver(new CPLoginReq(1, "1", server_socket.getLocalPort()));
//			Thread.sleep(1000);
//			Deliver(new CPMessage(1, new OfflineMessage(0, 1, 1, 1, "你好！")));
//			Thread.sleep(1000);
//			Deliver(new CPLogout(1));
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void Terminate() {
		database.Terminate();
	}

	public void Signup(SPSignup signup) {
		System.out.println("New ID: " + signup.id);
		view.showMessage("Your new ID is: " + signup.id, "Signup Success");
	}

	public void Login(SPLogin login) {
		System.out.println("Login result: " + login.isSuc);
		if(login.isSuc) {
			view.setLoginVisible(false);

			database.AddAccount(me, login.friends);
			Iterator it = login.offlineMessage.iterator();
			while(it.hasNext()){
				database.AddMessage(me, (OfflineMessage)it.next());
			}

			it = login.friends.entrySet().iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry)it.next();
				int friend_id = (int)entry.getKey();
				friendList.InsertFriend(friend_id, (String)entry.getValue());
				friendList.AddMessagebyID(friend_id, database.GetUnreadMessageNum(me, friend_id));
			}
			System.out.println(me);
			FriendChooseListener friendChooseListener = new FriendChooseListener(friendList);
			view.createMainWindow(me, login.name, friendList, friendChooseListener);
			friendChooseListener.setViewList(view.mainWindow.getListView());
			view.setMainWindowVisible(true);
		} else {
			view.showMessage("No such ID or wrong password!", "Login Failed");
		}
	}

	synchronized public void ProcessMessage(SPMessage message) {
		System.out.println(message.offline_message.content);
		Deliver(new CPMessageReceived(1, message.offline_message.message_id));
	}

	public void Deliver(JTPackage message) {
		sender.Deliver(message);
	}

	public void setMe(int id) {
		this.me = id;
	}
}
