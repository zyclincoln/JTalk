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
		jtcview.setLoginVisible(true);

	}
}