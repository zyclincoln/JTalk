package JTalk.server.controller;
import JTalk.util.*;
import JTalk.server.model.*;
import java.util.*;

public class JTCLoginoutManager{
	JTDatabase database;
	Calendar calendar;
	LoginTable loginTable;
	public JTCLoginoutManager(JTDatabase database,LoginTable loginTable){
		this.database=database;
		calendar = Calendar.getInstance();
		this.loginTable=loginTable;
	}

	public LoginLog Login(int id,String password,String loginIP){
		AccountCheckResult result=database.CheckIn(id,password,calendar.getTimeInMillis(),loginIP);
		LoginLog log;
		String errorCause;
		Boolean isSuc=true;

		if(result.result==0){
			//loginTable.Login(id,loginIP);
			HashMap<Integer,String> friends = new HashMap<Integer,String>();
			ArrayList<OfflineMessage> offlineMessage;
			GetFriendResult gfResult database.GetFriend(id);
			if(gfResult.result_number==0){
				for(int index = 0;index < gfResult.friend.size();index++){
					AccountSearchResult asResult database.SearchAccountInfo(gfResult.friend.get(index));
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
					GetMessageResult gmResult database.GetMessage(id);
					if(gmResult.result_number==0){
						offlineMessage=gmResult.offline_message;
						SPLogin reply=new SPLogin(result.name,)
						loginTable.Login(id,loginIP,friends,offlineMessage);
						if(loginTable.getSender(id).Deliver(reply)){
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

		ObjectOutputStream toClient;
		try{
			Socket client=new Socket(loginIP,8000);
			toClient=new ObjectOutputStream(client.getOutputStream());
			toClient.writeObject(new SPLogin());
			log=new LoginLog(false,result,"Login failed :"+errorCause);
		}
		catch(Exception e){
			log=new LoginLog(false,result,"Login failed : "+e.toString());
		}
		finally{
			try{
				toClient.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		return log;
	}
}