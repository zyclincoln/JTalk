CFLAGS = -Djava.ext.dirs=lib
ROOT = JTalk/
SERVER = $(ROOT)server/
MODEL = $(SERVER)model/
TARGET = $(MODEL)JTDBOfflineMessage.class

all: $(TARGET)

$(TARGET):  $(MODEL)JTDBOfflineMessage.java
	@ javac $(MODEL)JTDBOfflineMessage.java

run:
	@ java $(CFLAGS) $(MODEL)JTDBOfflineMessage

clean:
	@ rm $(TARGET)
