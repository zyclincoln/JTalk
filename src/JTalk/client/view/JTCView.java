package JTalk.client.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JTCView{
	public LoginWindow loginWindow;
	public SignupWindow signupWindow;
	public JTCView(ActionListener loginListener, ActionListener signupListener,ActionListener signupConfirm){
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

	public void setLoginVisible(boolean show){
		loginWindow.setVisible(show);
	}

	public void setSignupVisible(boolean show){
		signupWindow.setVisible(show);
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
