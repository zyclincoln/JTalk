package JTalk.util;

public class CPLogout extends ClientPackage{
	public int id;
	public CPLoginReq(int id){
		super.type=4;
		this.id=id;
	};
}