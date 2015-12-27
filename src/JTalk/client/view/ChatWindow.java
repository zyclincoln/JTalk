package JTalk.client.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatWindow extends JFrame{
	private JLabel idInfo;
	private JLabel nameInfo;
	private JTextArea contents;
	public JTextArea sendContents;
	private JButton send;
	private JPanel panel;
	private JPanel buttonPanel;

	public ChatWindow(int id, String name, ArrayList<OfflineMessage> messageSet, ActionListener sendListener){
		idInfo=new JLabel(id);
		nameInfo=new JLabel(name);
		nameInfo=new JTextArea();
		sendContents=new JTextArea();
		send=new JButton("Send");

		panel=new JPanel();
		panel.setLayout(new BoxLayout(contents,BoxLayout.Y_AXIS));
		panel.add(idInfo);
		panel.add(nameInfo);
		panel.add(Box.createVerticalStrut(30));
		panel.add(contents);
		panel.add(Box.createVerticalStrut(30));
		panel.add(sendContents);
		panel.add(Box.createVerticalStrut(30));
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(send);
		panel.add(buttonPanel);

		setLayout(new BorderLayout());
		add(panel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);

		send.addActionListener(sendListener);

		for(int i=0;i<messageSet.size();i++){
			Date date=new Date(message.get(i).time());
			
			contents.append(message.get(i).)
		}

	}
	
}