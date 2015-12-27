package JTalk.client.controller;
import JTalk.client.view.*;
import JTalk.client.model.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import JTalk.util.*;

public class ControllerDemo{
	public static void main(String[] args){
		
		LoginListener loginListener=new LoginListener();
		SignupListener signupListener=new SignupListener();
		SignupConfirmListener signupConfirmListener=new SignupConfirmListener();
		JTController nULL=new JTController();
		
		JTCView jtcview=new JTCView(nULL,loginListener,signupListener,signupConfirmListener);
		loginListener.addView(jtcview);
		signupListener.addView(jtcview);
		signupConfirmListener.addView(jtcview);
		//jtcview.setLoginVisible(true);

		friendList friendList=new FriendList();
		friendList.InsertFriend(4113,"zyclincoln");
		friendList.InsertFriend(1010,"Chaosink");
		nULL.setFriendList(friendList);
		//friendList.AddMessagebyID(1010,10);
		//friendChooseListener friendChooseListener=new FriendChooseListener(friendList);

		//tcview.createMainWindow(10000,"administrator",friendList,friendChooseListener);

		//riendChooseListener.setViewList(jtcview.mainWindow.getListView());

		//jtcview.setMainWindowVisible(true);

		ArrayList<UnreadMessage> message=new ArrayList<UnreadMessage>();
		message.add(new UnreadMessage(0,110000000,"Please"));
		message.add(new UnreadMessage(0,110001000,"Remember"));
		message.add(new UnreadMessage(0,110002000,"Always"));
		message.add(new UnreadMessage(0,110003000,"Trying"));
		message.add(new UnreadMessage(0,110004000,"To"));	
		message.add(new UnreadMessage(0,110005000,"Go"));	
		message.add(new UnreadMessage(0,110006000,"Ahead"));	
		message.add(new UnreadMessage(0,110007000,"Amen"));
		jtcview.createChatWindow(10000,"administrator",message);
	}
}