package JTalk.util;

public class CPLoginReq extends ClientPackage{
	public int id;
	public String password;
	public int port;
	public CPLoginReq(int id, String password,int port){
		super.type=1;
		this.id=id;
		this.password=password;
		this.port=port;
	};
}
