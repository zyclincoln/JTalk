package JTalk.client.controller;

import JTalk.client.view.*;
import JTalk.client.model.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;

public class FriendChooseListener extends MouseAdapter{
	private FriendList friendList;
	private JList viewList;
	private JTCView view;

	public FriendChooseListener(JTCView view, FriendList friendList){
		this.friendList=friendList;
		this.view = view;
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

				int friend_id = friendList.getID(index);
				if(friendList.getChatWindow(friend_id) == null) {
					ArrayList<UnreadMessage> unread_message = view.controller.database.GetUnreadMessage(view.controller.me, friend_id);
					ChatWindow cw = view.createChatWindow(friend_id, friendList.GetNamebyIndex(index), unread_message);
					friendList.addChatWindow(index, cw);
				}
			}
		}
	}
}