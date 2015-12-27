package JTalk.client.controller;
import JTalk.client.view.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import JTalk.util.*;

public class ControllerDemo{
	public static void main(String[] args){
		
		LoginListener loginListener=new LoginListener();
		SignupListener signupListener=new SignupListener();
		SignupConfirmListener signupConfirmListener=new SignupConfirmListener();
		
		JTCView jtcview=new JTCView(loginListener,signupListener,signupConfirmListener);
		loginListener.addView(jtcview);
		signupListener.addView(jtcview);
		signupConfirmListener.addView(jtcview);
		//jtcview.setLoginVisible(true);

		//riendList friendList=new FriendList();
		//riendList.InsertFriend(4113,"zyclincoln");
		//riendList.InsertFriend(1010,"Chaosink");
		//riendList.AddMessagebyID(1010,10);
		//riendChooseListener friendChooseListener=new FriendChooseListener(friendList);

		//tcview.createMainWindow(10000,"administrator",friendList,friendChooseListener);

		//riendChooseListener.setViewList(jtcview.mainWindow.getListView());

		//jtcview.setMainWindowVisible(true);

		ArrayList<OfflineMessage> message=new ArrayList<OfflineMessage>();
		message.add(new OfflineMessage(0,10000,00001,110000000,"Please"));
		message.add(new OfflineMessage(0,10000,00002,110001000,"Remember"));
		message.add(new OfflineMessage(0,10000,00001,110002000,"Always"));
		message.add(new OfflineMessage(0,10000,00002,110003000,"Trying"));
		message.add(new OfflineMessage(0,10000,00003,110004000,"To"));	
		message.add(new OfflineMessage(0,10000,00004,110005000,"Go"));	
		message.add(new OfflineMessage(0,10000,00005,110006000,"Ahead"));	
		message.add(new OfflineMessage(0,10000,00006,110007000,"Amen"));
		jtcview.createChatWindow(10000,"administrator",message);
	}
}