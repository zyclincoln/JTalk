package JTalk.util;

public class CPSignupReq extends ClientPackage{
	public String name;
	public String password;
	public int port;
	public CPSignupReq(String name, String password,int port){
		super.type=0;
		this.name=name;
		this.password=password;
		this.port=port;
	};
}