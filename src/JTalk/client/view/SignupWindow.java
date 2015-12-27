package JTalk.client.view;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class SignupWindow extends JFrame{
	public JTextField userName;
	private JPanel namePanel;
	public JPasswordField userPassword;
	private JPanel pwPanel;
	public JTextField serverIP;
	public JTextField serverPort;
	private JPanel serverPanel;
	private JPanel inputPanel;
	private JPanel buttonPanel;
	private JButton signup;
	public SignupWindow(ActionListener signupListener){
		userName= new JTextField(20); 
		userPassword=new JPasswordField(20);
		pwPanel=new JPanel();
		namePanel=new JPanel();
		inputPanel=new JPanel();
		signup=new JButton("Sign Up");
		buttonPanel=new JPanel();
		serverIP=new JTextField(15);
		serverPort=new JTextField(6);
		serverPanel=new JPanel();

		namePanel.setLayout(new BoxLayout(namePanel,BoxLayout.X_AXIS));
		namePanel.add(new JLabel("User Name            "));
		namePanel.add(Box.createHorizontalStrut(20));
		namePanel.add(userName);

		pwPanel.setLayout(new BoxLayout(pwPanel,BoxLayout.X_AXIS));
		pwPanel.add(new JLabel("User Password"));
		pwPanel.add(Box.createHorizontalStrut(20));
		pwPanel.add(userPassword);

		userName.setHorizontalAlignment(JTextField.LEFT);
		userPassword.setHorizontalAlignment(JTextField.LEFT);

		serverPanel.setLayout(new BoxLayout(serverPanel,BoxLayout.X_AXIS));
		serverPanel.add(new JLabel("Server IP"));
		serverPanel.add(Box.createHorizontalStrut(10));
		serverPanel.add(serverIP);
		serverPanel.add(Box.createHorizontalStrut(20));
		serverPanel.add(new JLabel("port"));
		serverPanel.add(Box.createHorizontalStrut(10));
		serverPanel.add(serverPort);


		inputPanel.setLayout(new GridLayout(3,1,12,12));
		inputPanel.add(serverPanel);
		inputPanel.add(namePanel);
		inputPanel.add(pwPanel);

		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(Box.createHorizontalStrut(250));
		buttonPanel.add(signup);

		setLayout(new BorderLayout());
		add(inputPanel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		inputPanel.setBorder(new EmptyBorder(20,20,0,20));
		buttonPanel.setBorder(new EmptyBorder(20,20,15,20));
		signup.addActionListener(signupListener);
	}
}