Account {
	ID;
	Password;
	Name;
	LoginTime;
	LoginIP;
	MessageCount;
}

class CheckResult {
	boolean IsSuc;
	result;
}

login
	CheckResult check(id, pwd, logintime, liginip);

add account
	AddAccount(name, pwd);

search info
	(ID, Name) SearchInfo(ID);

===========================

Friend[ID] {
	ID
}

GetFriend(ID);
AddFriend(ID1, ID2);
DeleteFriend(ID1, ID2);

===========================

OfflineMessage[ID] {
	SenderID;
	MessangeID;
	Time;
	Content;
}

GetMessage(ID);
RemoveMessage(ID, GlobalMessageID);
AddMessage();
