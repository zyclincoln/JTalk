CFLAGS = -Djava.ext.dirs=lib
SERVER = JTalk/server/
TARGET = $(SERVER)util/Message.class\
	$(SERVER)model/JTDBAccount.class
	
#	$(SERVER)DatabaseCreator.class \
#	$(SERVER)DatabaseCreatorTest.class

all: $(TARGET)
$(SERVER)util/Message.class: $(SERVER)util/Message.java
	@ javac $(SERVER)util/Message.java

$(SERVER)model/JTDBAccount.class: $(SERVER)model/JTDBAccount.java
	@ javac $(SERVER)util/Message.java $(SERVER)model/JTDBAccount.java

#$(SERVER)DatabaseCreator.class: $(SERVER)DatabaseCreator.java
#	@ javac $(SERVER)DatabaseCreator.java

#$(SERVER)DatabaseCreatorTest.class: $(SERVER)DatabaseCreator.java $(SERVER)DatabaseCreatorTest.java
#	@ javac $(SERVER)DatabaseCreatorTest.java

run:
	java -cp $(SERVER)util:. $(CFLAGS) $(SERVER)model/JTDBAccount

clean:
	@ rm $(TARGET)
