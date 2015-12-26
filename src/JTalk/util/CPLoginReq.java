package JTalk.util;

public class CPLoginReq extends ClientPackage{
	public int id;
	public String password;
	public CPLoginReq(int id, String password){
		super.type=1;
		this.id=id;
		this.password=password;
	};
}
