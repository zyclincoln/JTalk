package JTalk.client.view;
import JTalk.client.controller.*;
import JTalk.client.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import JTalk.util.*;


public class JTCView{
	public JTController controller;
	public LoginWindow loginWindow;
	public SignupWindow signupWindow;
	public MainWindow mainWindow;
	public JTCView(JTController controller, ActionListener loginListener, ActionListener signupListener,ActionListener signupConfirm){
		this.controller = controller;
		loginWindow=new LoginWindow(loginListener,signupListener);
		signupWindow=new SignupWindow(signupConfirm);
		loginWindow.setTitle("JTalk");
		loginWindow.setSize(400,200);
		loginWindow.setLocationRelativeTo(null);
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setVisible(false);
		signupWindow.setTitle("JTalk");
		signupWindow.setSize(400,200);
		signupWindow.setLocationRelativeTo(null);
		signupWindow.setVisible(false);
	}

	public void createMainWindow(int id, String name, FriendList friendList, FriendChooseListener friendChooseListener){
		mainWindow=new MainWindow(id,name,friendList,friendChooseListener);
		mainWindow.setTitle("JTalk");
		mainWindow.setSize(200,500);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createChatWindow(int id, String name, ArrayList<UnreadMessage> messageSet){
		ChatWindow chatWindow= new ChatWindow(controller.friendList,id,name,messageSet);
		chatWindow.setTitle("Chat with "+name);
		chatWindow.setSize(600,600);
		chatWindow.setLocationRelativeTo(null);
		chatWindow.setVisible(true);
	}

	public void setLoginVisible(boolean show){
		loginWindow.setVisible(show);
	}

	public void setSignupVisible(boolean show){
		signupWindow.setVisible(show);
	}

	public void setMainWindowVisible(boolean show){
		mainWindow.setVisible(show);
	}

	public void showMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

/*
	public static void main(String[] args){
		LoginListener loginListener=new LoginListener();
		SignupListenr signupListener=new SignupListener();
		JTCView jtcview=new JTCView(loginListener,signupListener);
		loginListener.addView(jtcview);
		signupListener.addView(jtcview);
		jtcview.setLoginVisible(true);
	}
*/
}
