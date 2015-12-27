package JTalk.client.controller;
import JTalk.client.view.*;
import javax.swing.*;

public class SignupListener implements ActionListener{
	private JTCView view;
	
	public void addView(JTCView view){
		this.view=view;
	}

	public void actionPerformed(ActionEvent e){
		System.out.println("Press Sign up Button");
	}
}