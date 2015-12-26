package JTalk.server.model;
import JTalk.util.*;
import java.sql.*;
import java.util.*;

public class JTDatabase{
	private Connection DBConnection;
	private JTDBAccount Account;
	private JTDBFriend Friend;
	private JTDBOfflineMessage OfflineMessage;
	public JTDatabase(){

	}
	
	public JTDBInitResult initial(){	
		JTDBInitResult result=new JTDBInitResult();
		result.result_number=0;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			DBConnection=DriverManager.getConnection("jdbc:mysql://localhost/JTalk","root","");
		}
		catch(Exception e){
			System.out.println(e);
			result.result_number=1;
			result.message="JTDB Initial failed." + e.toString();
			return result;
		}
		Friend=new JTDBFriend(DBConnection);
		Account= new JTDBAccount(DBConnection);
		OfflineMessage=new JTDBOfflineMessage(DBConnection);
		Account.initial();
		Friend.Init();
		OfflineMessage.Init();
		result.message="JTDB Initial finish.";
		return result;
	}

	public AddFriendResult AddFriend(int id_1,int id_2){
		return Friend.AddFriend(id_1,id_2);
	}

	public GetFriendResult GetFriend(int id){
		return Friend.GetFriend(id);
	}

	public DeleteFriendResult DeleteFriend(int id_1,int id_2){
		return Friend.DeleteFriend(id_1,id_2);
	}

	public AccountCheckResult ChekcIn(Integer id,String passwd, String loginTime, String loginIP){
		return Account.Check(id,passwd,loginTime,loginIP);
	}

	public AccountAddResult AddAccount(String name,String passwd){
		return Account.Add(name,passwd);
	}

	public AccountSearchResult SearchAccountInfo(Integer id){
		return Account.SearchInfo(id);
	}

	public GetMessageResult GetMessage(int id){
		return OfflineMessage.GetMessage(id);
	}

	public AddMessageResult AddMessage(int id, OfflineMessage message){
		return OfflineMessage.AddMessage(id,message);
	}

	public DeleteMessageResult DeleteMessage(int id,int message_id){
		return OfflineMessage.DeleteMessage(id,message_id);
	}

	public JTDBTerminateResult Terminate(){
		JTDBTerminateResult result=new JTDBTerminateResult();
		result.result_number=0;
		try{
			DBConnection.close();
			result.message="Database Terminate.";
		}
		catch(SQLException e){
			System.out.println(e);
			result.result_number=1;
			result.message="Database Terminate failed.";
			return result;
		}
		return result;
	}
}
