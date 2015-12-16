LIB = -Djava.ext.dirs=lib
ROOT = JTalk/
SERVER = $(ROOT)server/
SERVER_MODEL = $(SERVER)model/
SERVER_UTIL = $(SERVER)util/
TARGET = $(SERVER_MODEL)JTDBAccount.class
SRC = $(TARGET:%.class=%.java)
CLASS = $(TARGET:%.class=%)

all: $(TARGET)

$(TARGET): $(SRC)
	@ javac $(SRC)

run:
	@ java $(LIB) $(CLASS)

clean:
	@ rm -f $(TARGET)
