package JTalk.client.controller;
import JTalk.client.view.*;
import javax.swing.*;
import java.awt.event.*;

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

		FriendList friendList=new FriendList();
		friendList.InsertFriend(4113,"zyclincoln");
		friendList.InsertFriend(1010,"Chaosink");
		friendList.AddMessagebyID(1010,10);
		FriendChooseListener friendChooseListener=new FriendChooseListener(friendList);

		jtcview.createMainWindow(10000,"administrator",friendList,friendChooseListener);

		friendChooseListener.setViewList(jtcview.mainWindow.getListView());

		jtcview.setMainWindowVisible(true);		
	}
}