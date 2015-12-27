package JTalk.client.view;
import JTalk.client.model.*;
import JTalk.client.controller.*;
import JTalk.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.border.*;

public class ChatWindow extends JFrame{
	public FriendList friendList;
	private JLabel idInfo;
	public JLabel nameInfo;
	private JTextArea contents;
	public JTextArea sendContents;
	private JButton send;
	private JPanel panel;
	private JPanel buttonPanel;
	private JPanel infoPanel;
	private JScrollPane sendScroll;
	private JScrollPane contentScroll;
	private SimpleDateFormat sdf;
	private Date date;
	private int id;
	public ChatWindow(final FriendList friendList, final int id, String name, ArrayList<UnreadMessage> messageSet){
		this.friendList=friendList;
		this.id=id;
		sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date=new Date();
		idInfo=new JLabel("    "+((Integer)id).toString());
		nameInfo=new JLabel("    "+name);
		contents=new JTextArea();
		infoPanel=new JPanel();
		sendContents=new JTextArea();
		send=new JButton("Send");

		infoPanel.setLayout(new GridLayout(2,1,10,0));
		infoPanel.add(idInfo);
		infoPanel.add(nameInfo);

		panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(infoPanel);
		panel.add(Box.createVerticalStrut(30));
		contentScroll=new JScrollPane(contents);
		contentScroll.setMinimumSize(new Dimension(500,300));
		panel.add(contentScroll);
		panel.add(Box.createVerticalStrut(30));
		sendScroll=new JScrollPane(sendContents);
		sendScroll.setMinimumSize(new Dimension(500,150));
		panel.add(sendScroll);
		panel.add(Box.createVerticalStrut(30));
		panel.setBorder(new EmptyBorder(10,10,10,10));

		buttonPanel=new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(send);
		panel.add(buttonPanel);

		setLayout(new BorderLayout());
		add(panel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);

		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				contents.append("Me  "+sdf.format(date.getTime())+"\n\n");
				contents.append("   "+sendContents.getText()+"\n\n");
				contents.setCaretPosition(contents.getText().length());
				sendContents.setText("");

			}
		});

		for(int i=0;i<messageSet.size();i++){
			Date messageDate=new Date(messageSet.get(i).time);
			contents.append(name+ "  " +sdf.format(messageDate)+"\n\n");
			contents.append("   "+messageSet.get(i).content+"\n\n");
		}

		contents.setWrapStyleWord(true);
		contents.setLineWrap(true);
		contents.setEditable(false);

		sendContents.setEditable(true);
		sendContents.setLineWrap(true);
		sendContents.setWrapStyleWord(true);

		addWindowListener(new WindowAdapter(){
			public void windowClosed(WindowEvent event){
				friendList.closeChatWindow(id);
				System.out.println(friendList);
			}
			public void windowClosing(WindowEvent event){
				friendList.closeChatWindow(id);
				System.out.println(friendList);
			}
		});
	}
}