package JTalk.client.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame{
	private JTextField userID;
	private JPanel idPanel;
	private JTextField userPassword;
	private JPanel pwPanel;
	private JPanel inputPanel;
	private JPanel buttonPanel;
	private JButton signup;
	private JButton login;
	private LogoPanel logo;
	public LoginWindow(){
		userID= new JTextField(20); 
		userPassword=new JTextField(20);
		pwPanel=new JPanel();
		idPanel=new JPanel();
		inputPanel=new JPanel();
		logo=new LogoPanel();
		login=new JButton("Sign In");
		signup=new JButton("Sign Up");
		buttonPanel=new JPanel();

		idPanel.setLayout(new BorderLayout(5,5));
		idPanel.add(new JLabel("User ID              "),BorderLayout.WEST);
		idPanel.add(userID,BorderLayout.CENTER);
		pwPanel.setLayout(new BorderLayout(5,0));
		pwPanel.add(new JLabel("User Password"),BorderLayout.WEST);
		pwPanel.add(userPassword,BorderLayout.CENTER);
		userID.setHorizontalAlignment(JTextField.LEFT);
		userPassword.setHorizontalAlignment(JTextField.LEFT);

		inputPanel.setLayout(new GridLayout(3,1));
		inputPanel.add(idPanel);
		inputPanel.add(new JPanel());
		inputPanel.add(pwPanel);

		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(login);
		buttonPanel.add(signup);

		setLayout(new BorderLayout(10,10));
		add(inputPanel,BorderLayout.CENTER);
		add(logo,BorderLayout.NORTH);
		add(buttonPanel,BorderLayout.SOUTH);
	}

	class LogoPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			ImageIcon icon=new ImageIcon("logo.png");
			g.drawImage(icon.getImage(),0,0,null);
		}
	}

	public static void main(String[] args){
		try{
			LoginWindow demo=new LoginWindow();
			demo.setTitle("JTalk");
			demo.setSize(400,200);
			demo.setLocationRelativeTo(null);
			demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			demo.setVisible(true);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}