package JTalk.client.controller;
import java.util.*;

public class FriendList{
	public class FriendInfo{
		private int id;
		private String name;
		private int unreadMessage;
		private boolean isChatting;
		public FriendInfo(int id, String name, int unreadMessage, boolean isChatting){
			this.id=id;
			this.name=name;
			this.unreadMessage=unreadMessage;
			this.isChatting=isChatting;
		}
		public synchronized void AddUnreadMessage(int n){
			unreadMessage+=n;
		}
		public String GetName(){
			return name;
		}
		public void SetChatting(boolean isChatting){
			this.isChatting=isChatting;
		}
		public boolean HasUnreadMessage(){
			return unreadMessage!=0;
		}
		public synchronized void ClearUnreadMessage(){
			unreadMessage=0;
		}
		public boolean IsChatting(){
			return isChatting;
		}
		public int GetID(){
			return id;
		}
		public int GetUnreadMessageNum(){
			return unreadMessage;
		}
	}

	private ArrayList<FriendInfo> friend;

	public FriendList(){
		friend=new ArrayList<FriendInfo>();
	}

	public void InsertFriend(int id, String name){
		friend.add(new FriendInfo(id,name,0,false));
	}

	public String GetNamebyIndex(int index){
		return friend.get(index).GetName();
	}

	public boolean CheckChattingbyIndex(int index){
		return friend.get(index).IsChatting();
	}

	public void ClearUnreadMessage(int index){
		friend.get(index).ClearUnreadMessage();
	}

	public int GetUnreadMessageNumbyIndex(int index){
		return friend.get(index).GetUnreadMessageNum();
	}

	public void SetChattingbyIndex(int index, boolean isChatting){
		friend.get(index).SetChatting(isChatting);
	}

	public int AddMessagebyID(int id,int n){
		for(int i=0;i<friend.size();i++){
			if(friend.get(i).GetID()==id){
				friend.get(i).AddUnreadMessage(n);
				return 0;
			}
		}
		return -1;
	}

	public int GetSize(){
		return friend.size();
	}

	public String toString(){
		String result=new String();
		for(int i=0;i<friend.size();i++){
			result+=friend.get(i).GetID();
			result+=friend.get(i).GetName();
			result+=friend.get(i).GetUnreadMessageNum();
			result+=friend.get(i).IsChatting();
			result+="\n";
		}
		return result;
	}
}
