package JTalk.client.view;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame{
	public JTextField userID;
	private JPanel idPanel;
	public JPasswordField userPassword;
	private JPanel pwPanel;
	public JTextField serverIP;
	public JTextField serverPort;
	private JPanel serverPanel;
	private JPanel inputPanel;
	private JPanel buttonPanel;
	private JButton signup;
	private JButton login;
	public LoginWindow(ActionListener loginListener, ActionListener signupListener){
		userID= new JTextField(20); 
		userPassword=new JPasswordField(20);
		pwPanel=new JPanel();
		idPanel=new JPanel();
		inputPanel=new JPanel();
		login=new JButton("Sign In");
		signup=new JButton("Sign Up");
		buttonPanel=new JPanel();
		serverIP=new JTextField(15);
		serverPort=new JTextField(6);
		serverPanel=new JPanel();

		idPanel.setLayout(new BoxLayout(idPanel,BoxLayout.X_AXIS));
		idPanel.add(new JLabel("User ID              "));
		idPanel.add(Box.createHorizontalStrut(20));
		idPanel.add(userID);

		pwPanel.setLayout(new BoxLayout(pwPanel,BoxLayout.X_AXIS));
		pwPanel.add(new JLabel("User Password"));
		pwPanel.add(Box.createHorizontalStrut(20));
		pwPanel.add(userPassword);

		userID.setHorizontalAlignment(JTextField.LEFT);
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
		inputPanel.add(idPanel);
		inputPanel.add(pwPanel);

		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(Box.createHorizontalStrut(180));
		buttonPanel.add(login);
		buttonPanel.add(Box.createHorizontalStrut(10));
		buttonPanel.add(signup);

		setLayout(new BorderLayout());
		add(inputPanel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		inputPanel.setBorder(new EmptyBorder(20,20,0,20));
		buttonPanel.setBorder(new EmptyBorder(20,20,15,20));
		login.addActionListener(loginListener);
		signup.addActionListener(signupListener);
	}
/*
	public static void main(String[] args){
		try{
			LoginWindow demo=new LoginWindow();
			demo.setTitle("JTalk");
			demo.setSize(400,200);
			demo.setLocationRelativeTo(null);
			demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			demo.setVisible(true);
			LoginWindow demo1=new LoginWindow();
			demo1.setTitle("JTalk");
			demo1.setSize(400,200);
			demo1.setLocationRelativeTo(null);
			demo1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			demo1.setVisible(true);
			demo1.dispose(); 
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
*/
}