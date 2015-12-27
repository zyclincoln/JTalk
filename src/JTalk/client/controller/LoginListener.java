package JTalk.client.controller;
import JTalk.client.view.*;
import JTalk.util.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginListener implements ActionListener{
	private JTCView view;
	
	public void addView(JTCView view){
		this.view=view;
	}

	public void actionPerformed(ActionEvent e){
		view.controller.setMe(Integer.parseInt(view.loginWindow.userID.getText()));
		view.controller.sender.setSocket(view.loginWindow.serverIP.getText(), Integer.parseInt(view.loginWindow.serverPort.getText()));
		view.controller.Deliver(
			new CPLoginReq(
				Integer.parseInt(view.loginWindow.userID.getText()),
				new String(view.loginWindow.userPassword.getPassword()),
				view.controller.server_socket.getLocalPort()
			)
		);

		System.out.println(view.loginWindow.serverIP.getText());
		System.out.println(view.loginWindow.serverPort.getText());
		System.out.println(view.loginWindow.userID.getText());
		System.out.println(view.loginWindow.userPassword.getPassword());
	}
}