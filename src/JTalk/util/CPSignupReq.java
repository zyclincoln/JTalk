package JTalk.util;

public class CPSignupReq extends ClientPackage{
	public String name;
	public String password;
	public CPSignupReq(String name, String password){
		super.type=0;
		this.name=name;
		this.password=password;
	};
}