CFLAGS = -Djava.ext.dirs=lib
ROOT = JTalk/
SERVER = $(ROOT)server/
MODEL = $(SERVER)model/
TARGET = $(MODEL)JTDBFriend.class

all: $(TARGET)

$(TARGET): $(MODEL)JTDBFriend.java
	@ javac $(MODEL)JTDBFriend.java

run:
	@ java $(CFLAGS) $(MODEL)JTDBFriend

clean:
	@ rm $(TARGET)
