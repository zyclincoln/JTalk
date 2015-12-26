package JTalk.server.util;

class AccountSearchResult implements Message {
	public int result;
	public String causeinfo;
	public String toMessage(){
		if(result==0){
			return "Database: search succeeded.";
		}
		else{
			return "Database: search error: "+causeinfo;
		}
	}
	public String name;
}