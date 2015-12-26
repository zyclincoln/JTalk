package JTalk.util;

public class SPSignup extends ServerPackage{
	public int id;
	public boolean isSuc;
	public SPSignup(int id, boolean isSuc){
		super.type=0;
		this.id=id;
		this.isSuc=isSuc;
	};
}