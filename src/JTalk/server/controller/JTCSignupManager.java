package JTalk.server.controller;
import JTalk.server.model.*;
import JTalk.util.*;
import JTalk.server.util.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class JTCSignupManager {
	JTDatabase database;

	public JTCSignupManager(JTDatabase database){
		this.database=database;
	}

	public SignupLog Signup(String ip, int messageID, String name, String password){
		AccountAddResult result=database.AddAccount(name,password);
		SignupLog log;
		SPSignup reply;
		ObjectOutputStream toClient;

		try{
			Socket client=new Socket(ip,8000);
			toClient= new ObjectOutputStream(client.getOutputStream());
		}
		catch(Exception e){
			log=new SignupLog(false,result,e.toString());
			return log;
		}

		if(result.result==0){
			reply=new SPSignup(result.id,true);
		}
		else{
			reply=new SPSignup(0,false);
		}

		try{
			toClient.writeObject(reply);
		}
		catch(Exception e){
			log=new SignupLog(false,result,e.toString());
			return log;
		}
		finally{
			try{
				toClient.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}

		log=new SignupLog(true,result,new String(""));
		return log;
	}
}
