package JTalk.server.controller;
import JTalk.server.model.*;
import JTalk.server.util.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class JTCSignupManager {
	JTDatabase database;
	ObjectOutputStream toClient;
	public JTCSignupManager(JTDatabase database){
		this.database=database;
	}
	public SignupLog Signup(Socket client, int messageID, String name, String password){
		AccountAddResult result=database.AddAccount(name,password);
		SignupLog log;
		SPSignupInfo reply;
		if(result.result==0){
			reply=new SPSignupInfo(messageID,Calendar.getInstance().getTimeInMillis(),result.id,true);
		}
		else{
			reply=new SPSignupInfo(messageID,Calendar.getInstance().getTimeInMillis(),0,false);
		}

		try{
			toClient=new ObjectOutputStream(client.getOutputStream());
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
	public static void main(String[] args){
		JTDatabase database=new JTDatabase();
		database.initial();
		ObjectInputStream input;
		JTCSignupManager signupManager=new JTCSignupManager(database);
		try{
			ServerSocket server=new ServerSocket(8000);
			System.out.println("Server started");

			while(true){
				Socket socket=server.accept();
				input=new ObjectInputStream(socket.getInputStream());
				CPSignupReq req=(CPSignupReq)input.readObject();

				SignupLog log = signupManager.Signup(socket,0,req.name,req.password);
				System.out.println(log.toMessage());
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
