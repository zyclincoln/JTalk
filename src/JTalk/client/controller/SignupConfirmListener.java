package JTalk.client.controller;
import JTalk.client.view.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupConfirmListener implements ActionListener{
	private JTCView view;
	
	public void addView(JTCView view){
		this.view=view;
	}

	public void actionPerformed(ActionEvent e){
		System.out.println(view.signupWindow.serverIP.getText());
		System.out.println(view.signupWindow.serverPort.getText());
		System.out.println(view.signupWindow.userName.getText());
		System.out.println(view.signupWindow.userPassword.getPassword());
	}
}