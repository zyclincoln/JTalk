package JTalk.server.util;

public class SignupLog implements Message{
	public boolean isSuc;
	private AccountAddResult result;
	private String info;
	public String toMessage(){
		if(isSuc==true){
			return "Signup Operation Succeed. "+info +" "+result.toMessage();
		}
		else{
			return "Signup Operation Failed. " + info + " "+result.toMessage();
		}
	}
	public SignupLog(boolean isSuc,AccountAddResult result,String info){
		this.isSuc=isSuc;
		this.result=result;
		this.info=info;
	}
}