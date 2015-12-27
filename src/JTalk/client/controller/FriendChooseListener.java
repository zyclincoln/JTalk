package JTalk.client.controller;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class FriendChooseListener extends MouseAdapter{
	private FriendList friendList;
	private JList viewList;

	public FriendChooseListener(FriendList friendList){
		this.friendList=friendList;
	}

	public void setViewList(JList list){
		viewList=list;
	}

	public void mouseClicked(MouseEvent e){
		if(viewList==null){
			return;
		}
		else{
			if(e.getClickCount()==2){
				int index=viewList.getSelectedIndex();
				friendList.ClearUnreadMessage(index);
				friendList.SetChattingbyIndex(index,true);
				viewList.repaint();
			}
		}
	}
}