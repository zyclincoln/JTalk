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
		if(result.result==0){
			loginTable.Login(id,loginIP);


		}
		else{
			try{
				Socket client=new Socket(loginIP,8000);
				ObjectOutputStream toClient=new ObjectOutputStream(client.getOutputStream());
				
			}
		}
	}
}