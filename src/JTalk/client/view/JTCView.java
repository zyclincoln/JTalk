package JTalk.client.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JTCView{
	public LoginWindow loginWindow;

	public JTCView(ActionListener loginListener, ActionListener signupListener){
		loginWindow=new LoginWindow(loginListener,signupListener);
		loginWindow.setTitle("JTalk");
		loginWindow.setSize(400,200);
		loginWindow.setLocationRelativeTo(null);
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setVisible(false);
	}

	public void setLoginVisible(boolean show){
		loginWindow.setVisible(show);
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
