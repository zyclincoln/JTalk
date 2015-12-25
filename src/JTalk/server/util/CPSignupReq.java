package JTalk.server.util;

public class CPSignupReq extends ClientPackage{
	public String name;
	public String password;
	public CPSignupReq(String name, String password){
		this.name=name;
		this.password=password;
	};
}