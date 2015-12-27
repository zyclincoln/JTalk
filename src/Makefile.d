LIB  = -Djava.ext.dirs=lib
FLAG = -Xlint
ROOT = JTalk/
SERVER = $(ROOT)server/
SERVER_MODEL = $(SERVER)model/
SERVER_VIEW= $(SERVER)view/
SERVER_CONTROLLER = $(SERVER)controller/
SERVER_UTIL = $(SERVER)util/
UTIL = $(ROOT)util/
CLIENT = $(ROOT)client/
CLIENT_VIEW = $(CLIENT)view/
CLIENT_CONTROLLER = $(CLIENT)controller/
DIR = $(SERVER_MODEL) $(SERVER_MODEL) $(SERVER_CONTROLLER) $(SERVER_UTIL) $(UTIL) $(CLIENT_VIEW) $(CLIENT_CONTROLLER)

TARGET =  $(TARGET1) $(TARGET2) $(TARGET3) $(TARGET4) $(TARGET5) $(TARGET6)
TARGET1 = $(SERVER_MODEL)JTDBAccount.class\
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

TARGET3 = $(SERVER_UTIL)LoginLog.class\
			$(SERVER_UTIL)LoginTable.class\
			$(SERVER_UTIL)SignupLog.class\
			$(SERVER_UTIL)LogoutLog.class\
			$(SERVER_UTIL)MessageLog.class\
			$(SERVER_UTIL)MessageReceivedLog.class

TARGET4 = $(SERVER_CONTROLLER)JTCLoginoutManager.class\
			$(SERVER_CONTROLLER)JTCSignupManager.class\
			$(SERVER_CONTROLLER)JTCMessageManager.class\
			$(SERVER_CONTROLLER)JTCMessageReceivedManager.class\
			$(SERVER_CONTROLLER)JTCJobManager.class\
			$(SERVER_CONTROLLER)JTCListener.class\
			$(SERVER_CONTROLLER)JTController.class

TARGET5 = $(CLIENT_VIEW)LoginWindow.class\
			$(CLIENT_VIEW)JTCView.class\
			$(CLIENT_VIEW)SignupWindow.class\
			$(CLIENT_VIEW)FriendListRender.class\
			$(CLIENT_VIEW)MainWindow.class

TARGET6 = $(CLIENT_CONTROLLER)LoginListener.class\
			$(CLIENT_CONTROLLER)SignupListener.class\
			$(CLIENT_CONTROLLER)SignupConfirmListener.class\
			$(CLIENT_CONTROLLER)ControllerDemo.class\
			$(CLIENT_CONTROLLER)FriendList.class\
			$(CLIENT_CONTROLLER)FriendChooseListener.class





all: $(TARGET)

$(TARGET1): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET2): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET3): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET4): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET5): $(@:%.class=%.java)
	@ javac $(FLAG) $(@:%.class=%.java)

$(TARGET6): $(@:%.class=%.java)
	@ javac $(FLAG) $(@:%.class=%.java)


run1:
	@ java $(LIB) $($(@:run%=TARGET%):%.class=%)

run2:
	@ java $(LIB) $($(@:run%=TARGET%):%.class=%)

run3:
	@ java $(LIB) $($(@:run%=TARGET%):%.class=%)

clean:
	@ rm -f $(DIR:%=%*.class)
