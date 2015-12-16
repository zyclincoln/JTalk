LIB = -Djava.ext.dirs=lib

ROOT = JTalk/
SERVER = $(ROOT)server/
SERVER_MODEL = $(SERVER)model/
SERVER_VIEW= $(SERVER)view/
SERVER_CONTROLLER = $(SERVER)controller/
SERVER_UTIL = $(SERVER)util/
DIR = $(SERVER_MODEL) $(SERVER_MODEL) $(SERVER_CONTROLLER) $(SERVER_UTIL)

TARGET = $(TARGET1) $(TARGET2) $(TARGET3)
TARGET1 = $(SERVER_MODEL)JTDBAccount.class
TARGET2 = $(SERVER_MODEL)JTDBFriend.class
TARGET3 = $(SERVER_MODEL)JTDBOfflineMessage.class

all: $(TARGET)

$(TARGET1): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET2): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

$(TARGET3): $(@:%.class=%.java)
	@ javac $(@:%.class=%.java)

run1:
	@ java $(LIB) $($(@:run%=TARGET%):%.class=%)

run2:
	@ java $(LIB) $($(@:run%=TARGET%):%.class=%)

run3:
	@ java $(LIB) $($(@:run%=TARGET%):%.class=%)

clean:
	@ rm -f $(DIR:%=%*.class)
