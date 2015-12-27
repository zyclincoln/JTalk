package JTalk.client.view;
import JTalk.client.controller.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class FriendListRender implements ListCellRenderer{
	private FriendList friendList;
	private JLabel cell=new JLabel("",JLabel.LEFT);
	private Border lineBorder= BorderFactory.createLineBorder(Color.black,1);
	private Border emptyBorder= BorderFactory.createEmptyBorder(2,2,2,2);
	public FriendListRender(FriendList list){
		friendList=list;
	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
		cell.setOpaque(true);
		String text=friendList.GetNamebyIndex(index);
		int unreadMessageNum=friendList.GetUnreadMessageNumbyIndex(index);
		if(friendList.CheckChattingbyIndex(index)==false && unreadMessageNum!=0){
			text+="("+unreadMessageNum+")";
		}
		cell.setText(text);
		if(isSelected){
			cell.setForeground(list.getSelectionForeground());
			cell.setBackground(list.getSelectionBackground());
		}
		else{
			cell.setForeground(list.getForeground());
			cell.setBackground(list.getBackground());
		}
		cell.setBorder(cellHasFocus? lineBorder : emptyBorder);
		return cell;
	}
}