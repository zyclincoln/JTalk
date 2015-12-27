LIB  = -Djava.ext.dirs=lib
FLAG = -Xlint:unchecked

ROOT = JTalk/
UTIL = $(ROOT)util/
SERVER = $(ROOT)server/
SERVER_UTIL = $(SERVER)util/
SERVER_MODEL = $(SERVER)model/
SERVER_VIEW= $(SERVER)view/
SERVER_CONTROLLER = $(SERVER)controller/
CLIENT = $(ROOT)client/
CLIENT_UTIL = $(CLIENT)util/
CLIENT_MODEL = $(CLIENT)model/
CLIENT_VIEW = $(CLIENT)view/
CLIENT_CONTROLLER = $(CLIENT)controller/

DIR = $(ROOT) $(UTIL) $(SERVER) $(SERVER_UTIL) $(SERVER_MODEL) $(SERVER_VIEW) $(SERVER_CONTROLLER) $(CLIENT) $(CLIENT_UTIL) $(CLIENT_MODEL) $(CLIENT_VIEW) $(CLIENT_CONTROLLER)

TARGET = $(TARGET2) $(TARGET3) $(TARGET4) $(TARGET5) $(TARGET7) $(TARGET9) $(TARGET10) $(TARGET11)

TARGET1 =

TARGET2 = $(UTIL)ClientPackage.class\
			$(UTIL)CPLoginReq.class\
			$(UTIL)CPLogout.class\
			$(UTIL)CPMessageReceived.class\
			$(UTIL)CPMessage.class\
			$(UTIL)CPSignupReq.class\
			$(UTIL)Message.class\
			$(UTIL)Sender.class\
			$(UTIL)SPLogin.class\
			$(UTIL)ServerPackage.class\
			$(UTIL)SPMessage.class\
			$(UTIL)SPSignup.class\
			$(UTIL)OfflineMessage.class

TARGET3 = $(SERVER)JTServer.class

TARGET4 = $(SERVER_UTIL)LoginLog.class\
			$(SERVER_UTIL)LoginTable.class\
			$(SERVER_UTIL)SignupLog.class\
			$(SERVER_UTIL)LogoutLog.class\
			$(SERVER_UTIL)MessageLog.class\
			$(SERVER_UTIL)MessageReceivedLog.class

TARGET5 = $(SERVER_MODEL)JTDBAccount.class\
			$(SERVER_MODEL)AccountAddResult.class\
			$(SERVER_MODEL)AccountCheckResult.class\
			$(SERVER_MODEL)AccountInitialResult.class\
			$(SERVER_MODEL)AccountSearchResult.class\
			$(SERVER_MODEL)AddFriendResult.class\
			$(SERVER_MODEL)AddMessageResult.class\
			$(SERVER_MODEL)DeleteFriendResult.class\
			$(SERVER_MODEL)DeleteMessageResult.class\
			$(SERVER_MODEL)GetFriendResult.class\
			$(SERVER_MODEL)GetMessageResult.class\
			$(SERVER_MODEL)JTDatabase.class\
			$(SERVER_MODEL)JTDBFriend.class\
			$(SERVER_MODEL)JTDBInitResult.class\
			$(SERVER_MODEL)JTDBOfflineMessage.class\
			$(SERVER_MODEL)JTDBTerminateResult.class

TARGET6 =

TARGET7 = $(CLIENT)JTClient.class

TARGET8 =

TARGET9 = $(CLIENT_MODEL)JTDatabase.java

TARGET10 = $(CLIENT_VIEW)LoginWindow.class\
			$(CLIENT_VIEW)JTCView.class\
			$(CLIENT_VIEW)SignupWindow.class\
			$(CLIENT_VIEW)FriendListRender.class\
			$(CLIENT_VIEW)MainWindow.class

TARGET11 = $(CLIENT_CONTROLLER)JTController.class\
			$(CLIENT_CONTROLLER)LoginListener.class\
			$(CLIENT_CONTROLLER)SignupListener.class\
			$(CLIENT_CONTROLLER)SignupConfirmListener.class\
			$(CLIENT_CONTROLLER)FriendList.class\
			$(CLIENT_CONTROLLER)FriendChooseListener.class

all: $(TARGET)

$(TARGET2): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET3): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET4): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET5): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET7): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET9): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET10): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET11): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

server:
	@ java $(LIB) $(SERVER)JTServer

client:
	@ java $(LIB) $(CLIENT)JTClient

clean:
	@ rm -f $(DIR:%=%*.class)
