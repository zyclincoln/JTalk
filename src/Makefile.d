LIB = -Djava.ext.dirs=lib

ROOT = JTalk/
SERVER = $(ROOT)server/
SERVER_MODEL = $(SERVER)model/
SERVER_VIEW= $(SERVER)view/
SERVER_CONTROLLER = $(SERVER)controller/
SERVER_UTIL = $(SERVER)util/
UTIL = $(ROOT)util/
CLIENT = $(ROOT)client/
CLIENT_MODEL = $(CLIENT)model/
CLIENT_VIEW = $(CLIENT)view/
CLIENT_CONTROLLER = $(CLIENT)controller/
CLIENT_UTIL = $(CLIENT)util/
DIR = $(UTIL) $(SERVER) $(SERVER_MODEL) $(SERVER_VIEW) $(SERVER_CONTROLLER) $(SERVER_UTIL) $(CLIENT) $(CLIENT_MODEL) $(CLIENT_VIEW) $(CLIENT_CONTROLLER) $(CLIENT_UTIl)

TARGET =  $(TARGET1) $(TARGET2) $(TARGET3) $(TARGET4) $(TARGET5) $(TARGET6) $(TARGET7) $(TARGET8) $(TARGET9)

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

TARGET5 = $(CLIENT_MODEL)JTDatabase.class

TARGET6 = $(CLIENT_VIEW)LoginWindow.class\
			$(CLIENT_VIEW)JTCView.class

TARGET7 = $(CLIENT_CONTROLLER)JTController.class\
			$(CLIENT_CONTROLLER)JTCJobManager.class\
			$(CLIENT_CONTROLLER)JTCListener.class

TARGET8 = $(SERVER)JTServer.class

TARGET9 = $(CLIENT)JTClient.class


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
	@ javac $(@:%.class=%.java)

$(TARGET6): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET7): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET8): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET9): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

run1:
	@ java $(LIB) $($(@:run%=TARGET%):%.class=%)

run2:
	@ java $(LIB) $($(@:run%=TARGET%):%.class=%)

run3:
	@ java $(LIB) $($(@:run%=TARGET%):%.class=%)

run:
	@ java $(LIB) $(CLIENT)JTClient

clean:
	@ rm -f $(DIR:%=%*.class)
