package JTalk.server.model;
import JTalk.util.*;
import java.sql.*;
import java.util.*;

public class JTDBAccount{
	private Connection DBConnection;
	private PreparedStatement updateStatement;
	private PreparedStatement checkStatement;
	private PreparedStatement addStatement;
	private PreparedStatement searchStatement;
	private PreparedStatement idStatement;
	private PreparedStatement createFriend;
	private PreparedStatement createOfflineMessage;
	public JTDBAccount(Connection DB){
		DBConnection=DB;
	}

	public AccountInitialResult initial(){
		AccountInitialResult result=new AccountInitialResult();
		try{
			DatabaseMetaData metaData= DBConnection.getMetaData();
			ResultSet tables= metaData.getTables(null,null,"Account",new String[]{"TABLE"});
			if(tables.next()){
				result.result=0;
			}
			else{
				Statement statement=DBConnection.createStatement();
				statement.executeUpdate("create table Account(ID int AUTO_INCREMENT, Password char(60), Name char(20), LoginTime char(30),LoginIP char(40),primary key (ID))");
				result.result=0;
				result.causeinfo="table Account missed. Rebuilded.";
			}
			createFriend=DBConnection.prepareStatement("create table Friend? ( id int )");
			createOfflineMessage=DBConnection.prepareStatement("create table OfflineMessage? ( type int,	sender_id int,	message_id int,	time bigint, content varchar(255))");
			checkStatement=DBConnection.prepareStatement("select Name, LoginTime, LoginIP from Account where ID = ? and Password = ? ");
			updateStatement=DBConnection.prepareStatement("update Account set LoginTime = ?, LoginIP = ? where ID = ?");
			addStatement=DBConnection.prepareStatement("insert into Account (Password, Name) values (?, ?)");
			searchStatement=DBConnection.prepareStatement("select Name from Account where ID = ?");
			idStatement=DBConnection.prepareStatement("select ID from Account where Name = ? and Password = ?");
		}
		catch(SQLFeatureNotSupportedException e){
			result.result=1;
			result.causeinfo=e.toString();
		}
		catch(SQLTimeoutException e){
			result.result=1;
			result.causeinfo=e.toString();
		}
		catch(SQLException e){
			result.result=1;
			result.causeinfo=e.toString();
		}
		return result;
	}

	public AccountCheckResult Check(Integer id, String passwd, String loginTime, String loginIP){
		AccountCheckResult result=new AccountCheckResult();
		try{
			checkStatement.setInt(1,id);
			checkStatement.setString(2,passwd);
			ResultSet rset= checkStatement.executeQuery();
			if(rset.next()){
				result.result=0;
				result.name=rset.getString(1);
				result.loginTime=rset.getString(2);
				result.loginIP=rset.getString(3);
			}
			else{
				result.result=1;
				result.causeinfo="User ID or Password wrong.";
				return result;
			}
			updateStatement.setString(1,loginTime);
			updateStatement.setString(2,loginIP);
			updateStatement.setInt(3,id);
			if(updateStatement.executeUpdate()==1){
				result.result=0;
			}
			else{
				result.result=3;	
				result.causeinfo="Update failed.";
			}
		}
		catch(SQLTimeoutException e){
			result.result=2;
			result.causeinfo=e.toString();
		}
		catch(SQLException e){
			result.result=2;
			result.causeinfo=e.toString();
		}
		return result;
	}

	public AccountAddResult Add(String name, String passwd){
		AccountAddResult result=new AccountAddResult();
		try{
			addStatement.setString(2,name);
			addStatement.setString(1,passwd);
			addStatement.executeUpdate();
			idStatement.setString(1,name);
			idStatement.setString(2,passwd);
			ResultSet rset=idStatement.executeQuery();
			if(rset.next()){
				result.result=0;
				result.id=rset.getInt(1);
				createFriend.setInt(1,rset.getInt(1));
				createOfflineMessage.setInt(1,rset.getInt(1));
				createFriend.executeUpdate();
				createOfflineMessage.executeUpdate();
			}
			else{
				result.result=1;
				result.causeinfo="Add failed";
			}
		}
		catch(SQLTimeoutException e){
			result.result=2;
			result.causeinfo=e.toString();
		}
		catch(SQLException e){
			result.result=2;
			result.causeinfo=e.toString();
		}
		return result;
	}

	public AccountSearchResult SearchInfo(Integer id){
		AccountSearchResult result=new AccountSearchResult();
		try{
			searchStatement.setInt(1,id);
			searchStatement.executeQuery();
			ResultSet rset=searchStatement.executeQuery();
			if(rset.next()){
				result.result=0;
				result.name=rset.getString(1);
			}
			else{
				result.result=1;
				result.causeinfo="ID was not found.";
			}
		}
		catch(SQLTimeoutException e){
			result.result=2;
			result.causeinfo=e.toString();
		}
		catch(SQLException e){
			result.result=2;
			result.causeinfo=e.toString();
		}
		return result;
	}

	public static void main(String[] args){
		System.out.println("Goodnight");
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");

		Connection connection	=	DriverManager.getConnection("jdbc:mysql://localhost/JTalk","root","");
		System.out.println("Database connected");
		JTDBAccount account=new JTDBAccount(connection);
		
		AccountInitialResult initialResult= account.initial();
		System.out.println(initialResult.toMessage());

		AccountCheckResult checkResult= account.Check(123456,"123456","2015-12-16","127.0.0.1");
		System.out.println(checkResult.toMessage());

		AccountAddResult addresult= account.Add("zyclincoln","123456");
		System.out.println(addresult.toMessage());
		System.out.println("add id = "+addresult.id);


		AccountCheckResult checkResult1= account.Check(addresult.id,"123456","2015-12-16","127.0.0.1");
		System.out.println(checkResult1.toMessage());
		System.out.println("name = "+checkResult1.name+" loginIP = "+checkResult1.loginIP+" loginTime = "+checkResult1.loginTime);

		AccountSearchResult searchResult= account.SearchInfo(addresult.id);
		System.out.println(searchResult.toMessage()+ " name = "+searchResult.name);
		connection.close();
		}
		catch(ClassNotFoundException e){
			System.out.println("partial");
			System.out.println(e);
			
			
		}
		catch(Exception e){
			System.out.println("total!");
			System.out.println(e);
			
		}
	}
}
