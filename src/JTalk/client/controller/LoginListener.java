package JTalk.client.controller;
import JTalk.client.view.*;
import javax.swing.*;

public class LoginListener implements ActionListener{
	private JTCView view;
	
	public void addView(JTCView view){
		this.view=view;
	}

	public void actionPerformed(ActionEvent e){
		System.out.println(view.loginWindow.serverIP.getText());
		System.out.println(view.loginWindow.serverPort.getText());
		System.out.println(view.loginWindow.userID.getText());
		System.out.println(view.loginWindow.userPassword.getText());
	}
}