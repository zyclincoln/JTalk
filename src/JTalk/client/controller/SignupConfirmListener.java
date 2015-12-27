package JTalk.client.controller;
import JTalk.client.view.*;
import JTalk.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupConfirmListener implements ActionListener{
	private JTCView view;
	
	public void addView(JTCView view){
		this.view=view;
	}

	public void actionPerformed(ActionEvent e){
		view.controller.sender.setSocket(view.signupWindow.serverIP.getText(), Integer.parseInt(view.signupWindow.serverPort.getText()));
		view.controller.Deliver(
			new CPSignupReq(
				view.signupWindow.userName.getText(),
				new String(view.signupWindow.userPassword.getPassword()),
				view.controller.server_socket.getLocalPort()
			)
		);

		System.out.println(view.signupWindow.serverIP.getText());
		System.out.println(view.signupWindow.serverPort.getText());
		System.out.println(view.signupWindow.userName.getText());
		System.out.println(view.signupWindow.userPassword.getPassword());
		view.signupWindow.dispose();
	}
}