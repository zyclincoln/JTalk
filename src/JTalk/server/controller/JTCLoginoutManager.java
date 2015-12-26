package JTalk.server.controller;
import JTalk.util.*;
import JTalk.server.util.*;
import JTalk.server.model.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class JTCLoginoutManager{
	JTDatabase database;
	Calendar calendar;
	LoginTable loginTable;
	public JTCLoginoutManager(JTDatabase database,LoginTable loginTable){
		this.database=database;
		calendar = Calendar.getInstance();
		this.loginTable=loginTable;
	}

	public LogoutLog Logout(int id){
		LogoutLog log;
		if(loginTable.Logout(id)==0){
			log=new LogoutLog(true,id+" has logout.");
		}
		else{
			log=new LogoutLog(false,id+" hasn't login.");
		}
		return log;
	}

	public LoginLog Login(int id,String password,String loginIP){
		java.text.SimpleDateFormat timeformat =  new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(calendar.getTimeInMillis());
		AccountCheckResult result=database.CheckIn(id,password,timeformat.format(date),loginIP);
		LoginLog log;
		String errorCause=new String();
		Boolean isSuc=true;

		if(result.result==0){
			HashMap<Integer,String> friends = new HashMap<Integer,String>();
			ArrayList<OfflineMessage> offlineMessage;
			GetFriendResult gfResult=database.GetFriend(id);
			if(gfResult.result_number==0){
				for(int index = 0;index < gfResult.friend.size();index++){
					AccountSearchResult asResult=database.SearchAccountInfo(gfResult.friend.get(index));
					if(asResult.result==0){
						friends.put(gfResult.friend.get(index),asResult.name);
					}
					else{
						errorCause="Cannot get friend : "+gfResult.friend.get(index);
						isSuc=false;
						break;
					}
				}
				if(isSuc==true){
					GetMessageResult gmResult=database.GetMessage(id);
					if(gmResult.result_number==0){
						offlineMessage=gmResult.offline_message;
						SPLogin reply=new SPLogin(result.name,friends,offlineMessage);
						loginTable.Login(id,loginIP);
						if(loginTable.getSender(id).Deliver(reply)==0){
							log = new LoginLog(true,result,"Login succeed : "+id);
							return log;
						}
						else{
							errorCause="deliver reply error.";
						}
					}
					else{
						errorCause="get OfflineMassage error";
					}
				}
				else{
					errorCause="get Friend info error";
				}
			}
			else{
				errorCause="get Friend id error";
			}
		}

		try{
			Socket client=new Socket(loginIP,8000);
			ObjectOutputStream toClient=new ObjectOutputStream(client.getOutputStream());
			toClient.writeObject(new SPLogin());
			toClient.flush();
			log=new LoginLog(false,result,"Login failed :"+errorCause);
			toClient.close();
		}
		catch(Exception e){
			log=new LoginLog(false,result,"Login failed : "+e.toString());
		}
		return log;
	}
}