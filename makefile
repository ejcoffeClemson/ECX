default: cpsc2150/extendedConnectX/GameScreen.java cpsc2150/extendedConnectX/models/AbsGameBoard.java cpsc2150/extendedConnectX/models/BoardPosition.java cpsc2150/extendedConnectX/models/GameBoard.java cpsc2150/extendedConnectX/models/IGameBoard.java
	javac cpsc2150/extendedConnectX/GameScreen.java	cpsc2150/extendedConnectX/models/AbsGameBoard.java cpsc2150/extendedConnectX/models/BoardPosition.java cpsc2150/extendedConnectX/models/GameBoard.java cpsc2150/extendedConnectX/models/IGameBoard.java


run: cpsc2150/extendedConnectX/GameScreen.class cpsc2150/extendedConnectX/models/AbsGameBoard.class cpsc2150/extendedConnectX/models/BoardPosition.class cpsc2150/extendedConnectX/models/GameBoard.class cpsc2150/extendedConnectX/models/IGameBoard.class
	java cpsc2150.extendedConnectX.GameScreen

test: cpsc2150/extendedConnectX/models/TestGameBoard.java cpsc2150/extendedConnectX/models/TestGameBoardMem.java cpsc2150/extendedConnectX/models/AbsGameBoard.java cpsc2150/extendedConnectX/models/BoardPosition.java cpsc2150/extendedConnectX/models/GameBoard.java cpsc2150/extendedConnectX/models/IGameBoard.java
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/extendedConnectX/models/TestGameBoard.java cpsc2150/extendedConnectX/models/TestGameBoardMem.java cpsc2150/extendedConnectX/models/AbsGameBoard.java cpsc2150/extendedConnectX/models/BoardPosition.java cpsc2150/extendedConnectX/models/GameBoard.java cpsc2150/extendedConnectX/models/IGameBoard.java

testGB: cpsc2150/extendedConnectX/models/TestGameBoard.class cpsc2150/extendedConnectX/models/AbsGameBoard.class cpsc2150/extendedConnectX/models/BoardPosition.class cpsc2150/extendedConnectX/models/GameBoard.class cpsc2150/extendedConnectX/models/IGameBoard.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.extendedConnectX.models.TestGameBoard

testGBmem: cpsc2150/extendedConnectX/models/TestGameBoardMem.class cpsc2150/extendedConnectX/models/AbsGameBoard.class cpsc2150/extendedConnectX/models/BoardPosition.class cpsc2150/extendedConnectX/models/GameBoard.class cpsc2150/extendedConnectX/models/IGameBoard.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.extendedConnectX.models.TestGameBoardMem

clean:
	rm -f cpsc2150/extendedConnectX/*.class
	rm -f cpsc2150/extendedConnectX/models/*.class


