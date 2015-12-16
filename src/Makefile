LIB = -Djava.ext.dirs=lib
ROOT = JTalk/
SERVER = $(ROOT)server/
SERVER_MODEL = $(SERVER)model/
SERVER_UTIL = $(SERVER)util/
TARGET = \
	$(SERVER_MODEL)JTDBAccount.class

all: $(TARGET)

$(SERVER_MODEL)JTDBAccount.class: $(SERVER_MODEL)JTDBAccount.java
	@ javac $(SERVER_MODEL)JTDBAccount.java

run:
	@ java $(LIB) $(SERVER_MODEL)JTDBAccount

clean:
	@ rm $(TARGET)
