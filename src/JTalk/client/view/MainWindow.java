package JTalk.client.view;
import JTalk.client.controller.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
	private DefaultListModel friendListModel;
	private JList<String> friendList;
	private FriendListRender friendListRender;
	private JLabel idCard;
	private JPanel holdPanel;
	public MainWindow(int id, String name, FriendList list, MouseListener chooseFriend){
		
		friendListModel=new DefaultListModel();
		//friendList=new JList();
		friendList=new JList(friendListModel);
		friendListRender=new FriendListRender(list);
		idCard=new JLabel(name+"("+id+")");
		holdPanel=new JPanel();

		for(int i=0;i<list.GetSize();i++){
			friendListModel.addElement(list.GetNamebyIndex(i));
		}

		friendList.setCellRenderer(friendListRender);

		idCard.setPreferredSize(new Dimension(200,50));
		friendList.setPreferredSize(new Dimension(200,800));

		holdPanel.setLayout(new BoxLayout(holdPanel,BoxLayout.Y_AXIS));
		holdPanel.add(idCard);
		holdPanel.add(Box.createVerticalStrut(30));
		holdPanel.add(new JScrollPane(friendList));

		setLayout(new BorderLayout());
		add(holdPanel,BorderLayout.CENTER);

		friendList.setSelectedIndex(0);
		friendList.addMouseListener(chooseFriend);
		
	}
	public JList getListView(){
		return friendList;
	}
}