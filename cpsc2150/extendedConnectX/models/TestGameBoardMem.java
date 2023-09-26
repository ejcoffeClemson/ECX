package cpsc2150.extendedConnectX.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestGameBoardMem {


    private String MakeBoardString(char[][] fun){

        String printBoard = "";
        int i = 0;
        int j = 0;
        int nine = 9;

        for (int l = 0; l < fun[0].length; l++) {
            if(l <= nine){
                printBoard += ("| " + l);
            }
            else {
                printBoard += ("|" + l);
            }
        }
        printBoard += "|\n";

        for(i = fun.length-1; i >= 0; --i){

            for(j = 0; fun[0].length > j; ++j){
                printBoard += ("|" + fun[i][j] + " ");

            }

            printBoard += ("|\n");

        }

        return printBoard;

    }

    //Private function the makes 2d array , give it all blank spaces
    private char[][] MakeABlankBoard(int R,int C){
        char temp[][] = new char[R][C];

        for(int i = 0; i < R; i++){

            for(int b = 0; b < C; b++){
                temp[i][b] = ' ';
            }
        }

        return temp;
    }

    private IGameBoard MakeAGameBoard(int nRow, int nCol, int wTok) {
        return new GameBoardMem(nRow,nCol,wTok);
    }

    @Test
    public void testConstructor_Board_Ten_By_Ten_Tok_Five(){
        IGameBoard q = MakeAGameBoard(10,10,5);
        char temp[][] = MakeABlankBoard(10,10);
        String end = MakeBoardString(temp);

        assertEquals(q.toString(), end);
    }

    @Test
    public void testConstructor_Board_Three_By_Three_Tok_Three(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);
        String end = MakeBoardString(temp);

        assertEquals(q.toString(), end);
    }

    @Test
    public void testConstructor_Board_Hundred_By_Hundred_Tok_TwentyFive(){
        IGameBoard q = MakeAGameBoard(100,100,25);
        char temp[][] = MakeABlankBoard(100,100);
        String end = MakeBoardString(temp);

        assertEquals(q.toString(), end);
    }


    @Test
    public void testcheckIfFree_Test_One_Empty_Column(){
        IGameBoard q = MakeAGameBoard(5,5,4);
        char temp[][] = MakeABlankBoard(5,5);

        temp[0][0] = 'O';
        temp[0][1] = 'X';
        temp[0][2] = 'O';

        q.placeToken('O',0);
        q.placeToken('X',1);
        q.placeToken('O',2);

        String end = MakeBoardString(temp);

        assertEquals(true, q.checkIfFree(3));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testcheckIfFree_Test_Two_Slightly_Filled_Column(){
        IGameBoard q = MakeAGameBoard(5,5,4);
        char temp[][] = MakeABlankBoard(5,5);

        temp[0][0] = 'X';
        temp[1][0] = 'O';
        temp[2][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'X';
        temp[2][1] = 'O';

        temp[0][2] = 'X';
        temp[1][2] = 'O';
        temp[2][2] = 'O';

        temp[0][3] = 'O';
        temp[1][3] = 'X';
        temp[2][3] = 'X';
        temp[3][3] = 'O';

        temp[0][4] = 'X';
        temp[1][4] = 'O';
        temp[2][4] = 'X';

        q.placeToken('X',0);
        q.placeToken('O',0);
        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('X',1);
        q.placeToken('O',1);

        q.placeToken('X',2);
        q.placeToken('O',2);
        q.placeToken('O',2);

        q.placeToken('O',3);
        q.placeToken('X',3);
        q.placeToken('X',3);
        q.placeToken('O',3);

        q.placeToken('X',4);
        q.placeToken('O',4);
        q.placeToken('X',4);

        String end = MakeBoardString(temp);

        assertEquals(true, q.checkIfFree(2));
        assertEquals(q.toString(), end);

    }

    @Test
    public void testcheckIfFree_Test_Three_Fully_Filled_Column(){
        IGameBoard q = MakeAGameBoard(5,5,4);
        char temp[][] = MakeABlankBoard(5,5);

        temp[0][0] = 'O';
        temp[1][0] = 'O';
        temp[2][0] = 'X';
        temp[3][0] = 'X';
        temp[4][0] = 'X';

        temp[0][1] = 'X';
        temp[1][1] = 'X';
        temp[2][1] = 'O';
        temp[3][1] = 'O';
        temp[4][1] = 'O';

        q.placeToken('O',0);
        q.placeToken('O',0);
        q.placeToken('X',0);
        q.placeToken('X',0);
        q.placeToken('X',0);

        q.placeToken('X',1);
        q.placeToken('X',1);
        q.placeToken('O',1);
        q.placeToken('O',1);
        q.placeToken('O',1);

        String end = MakeBoardString(temp);

        assertEquals(false, q.checkIfFree(0));
        assertEquals(q.toString(), end);
    }


    @Test
    public void testcheckHoriz_Test_One_Winning_Horizontal_Mid(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'X';
        temp[1][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'X';

        temp[0][2] = 'O';
        temp[1][2] = 'X';
        temp[2][2] = 'O';

        q.placeToken('X',0);
        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('X',1);

        q.placeToken('O',2);
        q.placeToken('X',2);
        q.placeToken('O',2);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(1,0);

        assertEquals(true, q.checkHorizWin(f, 'X'));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testcheckHoriz_Test_Two_NonWinning_Horizontal_(){
        IGameBoard q = MakeAGameBoard(3,4,3);
        char temp[][] = MakeABlankBoard(3,4);

        temp[0][0] = 'X';
        temp[1][0] = 'O';

        temp[0][1] = 'O';
        temp[1][1] = 'X';

        temp[0][2] = 'X';
        temp[1][2] = 'O';

        q.placeToken('X',0);
        q.placeToken('O',0);

        q.placeToken('O',1);
        q.placeToken('X',1);

        q.placeToken('X',2);
        q.placeToken('O',2);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(1,2);

        assertEquals(false, q.checkHorizWin(f, 'X'));
        assertEquals(q.toString(), end);

    }

    @Test
    public void testcheckHoriz_Test_Three_NFull_Winning_Horizontal(){
        IGameBoard q = MakeAGameBoard(4,4,3);
        char temp[][] = MakeABlankBoard(4,4);

        temp[0][0] = 'X';
        temp[1][0] = 'O';
        temp[2][0] = 'X';
        temp[3][0] = 'O';

        temp[0][1] = 'O';
        temp[1][1] = 'X';
        temp[2][1] = 'O';
        temp[3][1] = 'X';

        temp[0][2] = 'X';
        temp[1][2] = 'O';
        temp[2][2] = 'O';
        temp[3][2] = 'X';

        temp[0][3] = 'X';
        temp[1][3] = 'O';
        temp[2][3] = 'O';

        q.placeToken('X',0);
        q.placeToken('O',0);
        q.placeToken('X',0);
        q.placeToken('O',0);

        q.placeToken('O',1);
        q.placeToken('X',1);
        q.placeToken('O',1);
        q.placeToken('X',1);

        q.placeToken('X',2);
        q.placeToken('O',2);
        q.placeToken('O',2);
        q.placeToken('X',2);

        q.placeToken('X',3);
        q.placeToken('O',3);
        q.placeToken('O',3);


        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(2,3);

        assertEquals(true, q.checkHorizWin(f, 'O'));
        assertEquals(q.toString(), end);

    }

    @Test
    public void testcheckHoriz_Test_Four_GoodCount_NotRow_Check(){
        IGameBoard q = MakeAGameBoard(4,4,3);
        char temp[][] = MakeABlankBoard(4,4);

        temp[0][0] = 'X';
        temp[1][0] = 'O';
        temp[2][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'X';
        temp[2][1] = 'O';

        temp[0][2] = 'X';
        temp[1][2] = 'O';
        temp[2][2] = 'X';
        temp[3][2] = 'O';

        temp[0][3] = 'O';
        temp[1][3] = 'X';
        temp[2][3] = 'X';
        temp[3][3] = 'O';

        q.placeToken('X',0);
        q.placeToken('O',0);
        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('X',1);
        q.placeToken('O',1);

        q.placeToken('X',2);
        q.placeToken('O',2);
        q.placeToken('X',2);
        q.placeToken('O',2);

        q.placeToken('O',3);
        q.placeToken('X',3);
        q.placeToken('X',3);
        q.placeToken('O',3);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(2,0);

        assertEquals(false, q.checkHorizWin(f, 'X'));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testcheckVert_Test_One_Winning_Min(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'X';
        temp[1][0] = 'X';
        temp[2][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'O';

        q.placeToken('X',0);
        q.placeToken('X',0);
        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('O',1);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(2,0);

        assertEquals(true, q.checkVertWin(f, 'X'));
        assertEquals(q.toString(), end);

    }

    @Test
    public void testcheckVert_Test_Two_NonWinning_Game_Min(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'O';
        temp[1][0] = 'X';
        temp[2][0] = 'O';

        temp[0][1] = 'X';
        temp[1][1] = 'O';
        temp[2][1] = 'X';

        q.placeToken('O',0);
        q.placeToken('X',0);
        q.placeToken('O',0);

        q.placeToken('X',1);
        q.placeToken('O',1);
        q.placeToken('X',1);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(2,1);

        assertEquals(false, q.checkVertWin(f, 'X'));
        assertEquals(q.toString(), end);
    }


    @Test
    public void testcheckVert_Test_Three_Winning_Game_NearMax(){
        IGameBoard q = MakeAGameBoard(4,4,4);
        char temp[][] = MakeABlankBoard(4,4);

        temp[0][0] = 'O';
        temp[1][0] = 'O';
        temp[2][0] = 'O';

        temp[0][1] = 'X';
        temp[1][1] = 'X';
        temp[2][1] = 'X';
        temp[3][1] = 'X';

        temp[0][2] = 'X';
        temp[1][2] = 'X';
        temp[2][2] = 'X';

        //Originally 4 O on project report. however this shouldn't be possible in actual game
        temp[0][3] = 'O';
        temp[1][3] = 'O';
        temp[2][3] = 'O';


        q.placeToken('O',0);
        q.placeToken('O',0);
        q.placeToken('O',0);

        q.placeToken('X',1);
        q.placeToken('X',1);
        q.placeToken('X',1);
        q.placeToken('X',1);

        q.placeToken('X',2);
        q.placeToken('X',2);
        q.placeToken('X',2);

        q.placeToken('O',3);
        q.placeToken('O',3);
        q.placeToken('O',3);

        String end = MakeBoardString(temp);

        //Orinally (1,1), however positions would not would work as is (due to not being where the token was lasted placed.
        BoardPosition f = new BoardPosition(3,1);

        assertEquals(true, q.checkVertWin(f, 'X'));
        assertEquals(q.toString(), end);


    }

    @Test
    public void testcheckVert_Test_Four_NonWinning_Game_NearMax(){
        IGameBoard q = MakeAGameBoard(4,4,4);
        char temp[][] = MakeABlankBoard(4,4);

        temp[0][0] = 'O';
        temp[1][0] = 'O';
        temp[2][0] = 'O';
        temp[3][0] = 'X';

        temp[0][1] = 'X';
        temp[1][1] = 'X';
        temp[2][1] = 'X';
        temp[3][1] = 'O';

        temp[0][2] = 'O';
        temp[1][2] = 'X';
        temp[2][2] = 'X';

        //Originally 4 O on project report. however this shouldn't be possible in actual game
        temp[0][3] = 'X';
        temp[1][3] = 'O';
        temp[2][3] = 'O';
        temp[3][3] = 'O';


        q.placeToken('O',0);
        q.placeToken('O',0);
        q.placeToken('O',0);
        q.placeToken('X',0);

        q.placeToken('X',1);
        q.placeToken('X',1);
        q.placeToken('X',1);
        q.placeToken('O',1);

        q.placeToken('O',2);
        q.placeToken('X',2);
        q.placeToken('X',2);

        q.placeToken('X',3);
        q.placeToken('O',3);
        q.placeToken('O',3);
        q.placeToken('O',3);

        String end = MakeBoardString(temp);

        //Orinally (1,3), however positions would not would work as is (due to not being where the token was lasted placed.
        BoardPosition f = new BoardPosition(3,3);

        assertEquals(false, q.checkVertWin(f, 'X'));
        assertEquals(q.toString(), end);

    }

    @Test
    public void testcheckDiagWin_Test_One_Right_Diag_Win(){
        IGameBoard q = MakeAGameBoard(4,4,3);
        char temp[][] = MakeABlankBoard(4,4);

        temp[0][0] = 'X';
        temp[1][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'X';

        temp[0][2] = 'O';
        temp[1][2] = 'O';
        temp[2][2] = 'X';

        q.placeToken('X',0);
        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('X',1);

        q.placeToken('O',2);
        q.placeToken('O',2);
        q.placeToken('X',2);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(2,2);

        assertEquals(true, q.checkDiagWin(f, 'X'));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testcheckDiagWin_Test_Two_Right_Diag_Lose(){
        IGameBoard q = MakeAGameBoard(4,4,3);
        char temp[][] = MakeABlankBoard(4,4);

        temp[0][0] = 'X';
        temp[1][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'O';

        temp[0][2] = 'O';
        temp[1][2] = 'X';
        temp[2][2] = 'O';

        q.placeToken('X',0);
        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('O',1);

        q.placeToken('O',2);
        q.placeToken('X',2);
        q.placeToken('O',2);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(2,2);

        assertEquals(false, q.checkDiagWin(f, 'X'));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testcheckDiagWin_Test_Three_Left_Diag_Win(){
        IGameBoard q = MakeAGameBoard(4,4,3);
        char temp[][] = MakeABlankBoard(4,4);

        temp[0][3] = 'O';
        temp[1][3] = 'X';

        temp[0][2] = 'O';
        temp[1][2] = 'O';

        temp[0][1] = 'X';
        temp[1][1] = 'X';
        temp[2][1] = 'O';

        q.placeToken('O',3);
        q.placeToken('X',3);

        q.placeToken('O',2);
        q.placeToken('O',2);

        q.placeToken('X',1);
        q.placeToken('X',1);
        q.placeToken('O',1);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(2,1);

        assertEquals(true, q.checkDiagWin(f, 'O'));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testcheckDiagWin_Test_Four_Left_Diag_Lose(){
        IGameBoard q = MakeAGameBoard(4,4,3);
        char temp[][] = MakeABlankBoard(4,4);

        temp[0][3] = 'X';
        temp[1][3] = 'X';

        temp[0][2] = 'O';
        temp[1][2] = 'O';

        temp[0][1] = 'X';
        temp[1][1] = 'O';
        temp[2][1] = 'X';

        q.placeToken('X',3);
        q.placeToken('X',3);

        q.placeToken('O',2);
        q.placeToken('O',2);

        q.placeToken('X',1);
        q.placeToken('O',1);
        q.placeToken('X',1);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(2,1);

        assertEquals(false, q.checkDiagWin(f, 'X'));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testcheckDiagWin_Test_Five_Left_Diag__Top_Corner_Win(){
        IGameBoard q = MakeAGameBoard(5,5,4);
        char temp[][] = MakeABlankBoard(5,5);

        temp[0][0] = 'X';
        temp[1][0] = 'O';
        temp[2][0] = 'X';
        temp[3][0] = 'O';
        temp[4][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'X';
        temp[2][1] = 'O';
        temp[3][1] = 'X';

        temp[0][2] = 'O';
        temp[1][2] = 'O';
        temp[2][2] = 'X';

        temp[0][3] = 'X';
        temp[1][3] = 'X';

        temp[0][4] = 'O';


        q.placeToken('X',0);
        q.placeToken('O',0);
        q.placeToken('X',0);
        q.placeToken('O',0);
        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('X',1);
        q.placeToken('O',1);
        q.placeToken('X',1);

        q.placeToken('O',2);
        q.placeToken('O',2);
        q.placeToken('X',2);

        q.placeToken('X',3);
        q.placeToken('X',3);

        q.placeToken('O',4);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(4,0);

        assertEquals(true, q.checkDiagWin(f, 'X'));
        assertEquals(q.toString(), end);
    }


    @Test
    public void testcheckDiagWin_Test_Six_Right_Diag__Edge_Win(){
        IGameBoard q = MakeAGameBoard(5,5,4);
        char temp[][] = MakeABlankBoard(5,5);

        temp[0][1] = 'O';

        temp[0][2] = 'X';
        temp[1][2] = 'O';

        temp[0][3] = 'O';
        temp[1][3] = 'X';
        temp[2][3] = 'O';
        temp[3][3] = 'X';

        temp[0][4] = 'X';
        temp[1][4] = 'O';
        temp[2][4] = 'X';
        temp[3][4] = 'O';
        temp[4][4] = 'X';

        q.placeToken('O',1);

        q.placeToken('X',2);
        q.placeToken('O',2);

        q.placeToken('O',3);
        q.placeToken('X',3);
        q.placeToken('O',3);
        q.placeToken('X',3);

        q.placeToken('X',4);
        q.placeToken('O',4);
        q.placeToken('X',4);
        q.placeToken('O',4);
        q.placeToken('X',4);

        String end = MakeBoardString(temp);
        //Changes (0,1) needed due to incorrect board position.
        BoardPosition f = new BoardPosition(0,1);

        assertEquals(true, q.checkDiagWin(f, 'O'));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testcheckDiagWin_Test_Seven_Left_Diag__Edge_Lose(){
        IGameBoard q = MakeAGameBoard(5,5,4);
        char temp[][] = MakeABlankBoard(5,5);

        temp[0][0] = 'X';
        temp[1][0] = 'O';
        temp[2][0] = 'X';
        temp[3][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'X';
        temp[2][1] = 'O';

        temp[0][2] = 'X';
        temp[1][2] = 'O';

        temp[0][3] = 'X';

        q.placeToken('X',0);
        q.placeToken('O',0);
        q.placeToken('X',0);
        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('X',1);
        q.placeToken('O',1);

        q.placeToken('X',2);
        q.placeToken('O',2);

        q.placeToken('X',3);

        String end = MakeBoardString(temp);
        //Changes (0,1) needed due to incorrect board position.
        BoardPosition f = new BoardPosition(0,3);

        assertEquals(false, q.checkDiagWin(f, 'O'));
        assertEquals(q.toString(), end);

    }


    @Test
    public void testcheckTie_Test_OneFull_Board_TenPlayers(){
        IGameBoard q = MakeAGameBoard(4,4,4);
        char temp[][] = MakeABlankBoard(4,4);

        temp[0][0] = 'D';
        temp[1][0] = 'C';
        temp[2][0] = 'B';
        temp[3][0] = 'A';

        temp[0][1] = 'E';
        temp[1][1] = 'F';
        temp[2][1] = 'G';
        temp[3][1] = 'H';

        temp[0][2] = 'I';
        temp[1][2] = 'J';
        temp[2][2] = 'A';
        temp[3][2] = 'B';

        temp[0][3] = 'C';
        temp[1][3] = 'D';
        temp[2][3] = 'E';
        temp[3][3] = 'F';

        q.placeToken('D',0);
        q.placeToken('C',0);
        q.placeToken('B',0);
        q.placeToken('A',0);

        q.placeToken('E',1);
        q.placeToken('F',1);
        q.placeToken('G',1);
        q.placeToken('H',1);

        q.placeToken('I',2);
        q.placeToken('J',2);
        q.placeToken('A',2);
        q.placeToken('B',2);

        q.placeToken('C',3);
        q.placeToken('D',3);
        q.placeToken('E',3);
        q.placeToken('F',3);

        String end = MakeBoardString(temp);
        assertEquals(true, q.checkTie());
        assertEquals(q.toString(), end);
    }

    @Test
    public void testcheckTie_Test_Two_NonFull_Board_TwoPlayers(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'X';
        temp[0][1] = 'O';

        q.placeToken('X',0);
        q.placeToken('O',1);

        String end = MakeBoardString(temp);
        assertEquals(false, q.checkTie());
        assertEquals(q.toString(), end);


    }

    @Test
    public void testcheckTie_Test_Three_NonFullTwo_Board_EightPlayers(){
        IGameBoard q = MakeAGameBoard(4,4,4);
        char temp[][] = MakeABlankBoard(4,4);

        temp[0][0] = 'X';
        temp[1][0] = 'Z';
        temp[2][0] = 'C';
        temp[3][0] = 'V';

        temp[0][1] = 'A';
        temp[1][1] = 'M';
        temp[2][1] = 'N';
        temp[3][1] = 'B';

        temp[0][2] = 'X';
        temp[1][2] = 'Z';
        temp[2][2] = 'C';
        temp[3][2] = 'V';

        temp[0][3] = 'A';
        temp[1][3] = 'M';
        temp[2][3] = 'N';

        q.placeToken('X',0);
        q.placeToken('Z',0);
        q.placeToken('C',0);
        q.placeToken('V',0);

        q.placeToken('A',1);
        q.placeToken('M',1);
        q.placeToken('N',1);
        q.placeToken('B',1);

        q.placeToken('X',2);
        q.placeToken('Z',2);
        q.placeToken('C',2);
        q.placeToken('V',2);

        q.placeToken('A',3);
        q.placeToken('M',3);
        q.placeToken('N',3);

        String end = MakeBoardString(temp);
        assertEquals(false, q.checkTie());
        assertEquals(q.toString(), end);

    }

    @Test
    public void  testcheckTie_Test_Four_FullTwo_Board_SevenPlayers(){
        IGameBoard q = MakeAGameBoard(7,9,7);
        char temp[][] = MakeABlankBoard(7,9);

        temp[0][0] = 'J';
        temp[1][0] = 'H';
        temp[2][0] = 'G';
        temp[3][0] = 'F';
        temp[4][0] = 'D';
        temp[5][0] = 'S';
        temp[6][0] = 'A';

        temp[0][1] = 'J';
        temp[1][1] = 'H';
        temp[2][1] = 'G';
        temp[3][1] = 'F';
        temp[4][1] = 'D';
        temp[5][1] = 'S';
        temp[6][1] = 'A';

        temp[0][2] = 'H';
        temp[1][2] = 'G';
        temp[2][2] = 'F';
        temp[3][2] = 'D';
        temp[4][2] = 'S';
        temp[5][2] = 'A';
        temp[6][2] = 'J';

        temp[0][3] = 'J';
        temp[1][3] = 'H';
        temp[2][3] = 'G';
        temp[3][3] = 'F';
        temp[4][3] = 'D';
        temp[5][3] = 'S';
        temp[6][3] = 'A';

        temp[0][4] = 'J';
        temp[1][4] = 'H';
        temp[2][4] = 'G';
        temp[3][4] = 'F';
        temp[4][4] = 'D';
        temp[5][4] = 'S';
        temp[6][4] = 'A';

        temp[0][5] = 'J';
        temp[1][5] = 'H';
        temp[2][5] = 'G';
        temp[3][5] = 'F';
        temp[4][5] = 'D';
        temp[5][5] = 'S';
        temp[6][5] = 'A';

        temp[0][6] = 'J';
        temp[1][6] = 'H';
        temp[2][6] = 'G';
        temp[3][6] = 'F';
        temp[4][6] = 'D';
        temp[5][6] = 'S';
        temp[6][6] = 'A';

        temp[0][7] = 'J';
        temp[1][7] = 'H';
        temp[2][7] = 'G';
        temp[3][7] = 'F';
        temp[4][7] = 'D';
        temp[5][7] = 'S';
        temp[6][7] = 'A';

        temp[0][8] = 'J';
        temp[1][8] = 'H';
        temp[2][8] = 'G';
        temp[3][8] = 'F';
        temp[4][8] = 'D';
        temp[5][8] = 'S';
        temp[6][8] = 'A';


        q.placeToken('J',0);
        q.placeToken('H',0);
        q.placeToken('G',0);
        q.placeToken('F',0);
        q.placeToken('D',0);
        q.placeToken('S',0);
        q.placeToken('A',0);

        q.placeToken('J',1);
        q.placeToken('H',1);
        q.placeToken('G',1);
        q.placeToken('F',1);
        q.placeToken('D',1);
        q.placeToken('S',1);
        q.placeToken('A',1);

        q.placeToken('H',2);
        q.placeToken('G',2);
        q.placeToken('F',2);
        q.placeToken('D',2);
        q.placeToken('S',2);
        q.placeToken('A',2);
        q.placeToken('J',2);

        q.placeToken('J',3);
        q.placeToken('H',3);
        q.placeToken('G',3);
        q.placeToken('F',3);
        q.placeToken('D',3);
        q.placeToken('S',3);
        q.placeToken('A',3);

        q.placeToken('J',4);
        q.placeToken('H',4);
        q.placeToken('G',4);
        q.placeToken('F',4);
        q.placeToken('D',4);
        q.placeToken('S',4);
        q.placeToken('A',4);

        q.placeToken('J',5);
        q.placeToken('H',5);
        q.placeToken('G',5);
        q.placeToken('F',5);
        q.placeToken('D',5);
        q.placeToken('S',5);
        q.placeToken('A',5);

        q.placeToken('J',6);
        q.placeToken('H',6);
        q.placeToken('G',6);
        q.placeToken('F',6);
        q.placeToken('D',6);
        q.placeToken('S',6);
        q.placeToken('A',6);

        q.placeToken('J',7);
        q.placeToken('H',7);
        q.placeToken('G',7);
        q.placeToken('F',7);
        q.placeToken('D',7);
        q.placeToken('S',7);
        q.placeToken('A',7);

        q.placeToken('J',8);
        q.placeToken('H',8);
        q.placeToken('G',8);
        q.placeToken('F',8);
        q.placeToken('D',8);
        q.placeToken('S',8);
        q.placeToken('A',8);

        String end = MakeBoardString(temp);
        assertEquals(true, q.checkTie());
        assertEquals(q.toString(), end);
    }

    @Test
    public void testwhatsAtPos_Test_One_CharO_SB(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'X';
        temp[0][1] = 'O';

        q.placeToken('X',0);
        q.placeToken('O',1);

        BoardPosition f = new BoardPosition(0,1);
        String end = MakeBoardString(temp);

        assertEquals('O', q.whatsAtPos(f));
        assertEquals(q.toString(), end);

    }

    @Test
    public void  testwhatsAtPos_Test_Two_CharX_SB(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'X';
        temp[0][1] = 'O';

        q.placeToken('X',0);
        q.placeToken('O',1);

        BoardPosition f = new BoardPosition(0,0);
        String end = MakeBoardString(temp);

        assertEquals('X', q.whatsAtPos(f));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testwhatsAtPos_Test_Three_BlankS_SB(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'X';
        temp[0][1] = 'O';

        q.placeToken('X',0);
        q.placeToken('O',1);

        BoardPosition f = new BoardPosition(0,2);
        String end = MakeBoardString(temp);

        assertEquals(' ', q.whatsAtPos(f));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testwhatsAtPos_Test_Four_LeftCharO_DB(){
        IGameBoard q = MakeAGameBoard(6,6,6);
        char temp[][] = MakeABlankBoard(6,6);

        temp[0][0] = 'X';
        temp[1][0] = 'O';
        temp[2][0] = 'X';
        temp[3][0] = 'O';
        temp[4][0] = 'X';
        temp[5][0] = 'O';

        temp[0][1] = 'O';
        temp[1][1] = 'X';

        temp[0][2] = 'X';
        temp[1][2] = 'O';

        temp[0][3] = 'O';
        temp[1][3] = 'X';

        temp[0][4] = 'X';
        temp[1][4] = 'O';
        temp[2][4] = 'X';

        temp[0][5] = 'O';
        temp[1][5] = 'X';
        temp[2][5] = 'O';
        temp[3][5] = 'X';
        temp[4][5] = 'O';
        temp[5][5] = 'O';


        q.placeToken('X',0);
        q.placeToken('O',0);
        q.placeToken('X',0);
        q.placeToken('O',0);
        q.placeToken('X',0);
        q.placeToken('O',0);

        q.placeToken('O',1);
        q.placeToken('X',1);

        q.placeToken('X',2);
        q.placeToken('O',2);

        q.placeToken('O',3);
        q.placeToken('X',3);

        q.placeToken('X',4);
        q.placeToken('O',4);
        q.placeToken('X',4);

        q.placeToken('O',5);
        q.placeToken('X',5);
        q.placeToken('O',5);
        q.placeToken('X',5);
        q.placeToken('O',5);
        q.placeToken('O',5);

        BoardPosition f = new BoardPosition(5,5);
        String end = MakeBoardString(temp);

        assertEquals('O', q.whatsAtPos(f));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testwhatsAtPos_Test_Five_LeftCharX_DB(){
        IGameBoard q = MakeAGameBoard(6,6,6);
        char temp[][] = MakeABlankBoard(6,6);

        temp[0][0] = 'O';
        temp[1][0] = 'X';
        temp[2][0] = 'O';
        temp[3][0] = 'X';
        temp[4][0] = 'O';
        temp[5][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'X';

        q.placeToken('O',0);
        q.placeToken('X',0);
        q.placeToken('O',0);
        q.placeToken('X',0);
        q.placeToken('O',0);
        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('X',1);

        BoardPosition f = new BoardPosition(5,0);
        String end = MakeBoardString(temp);

        assertTrue(q.whatsAtPos(f) == 'X');
        assertTrue(q.toString().equals(end));
    }

    @Test
    public void testisPlayerAtPos_Test_One_PIAP_SB(){
        //PIAP, PLayer is at Position
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'O';

        temp[0][2] = 'X';

        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('O',1);

        q.placeToken('X',2);

        BoardPosition f = new BoardPosition(1,1);
        String end = MakeBoardString(temp);

        assertEquals(true, q.isPlayerAtPos(f, 'O'));
        assertEquals(q.toString(), end);


    }

    @Test
    public void testisPlayerAtPos_Test_Two_PINOTAP_SB(){
        //PINOTAP, PLayer is not at Position
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'X';

        temp[0][1] = 'O';
        temp[1][1] = 'O';

        temp[0][2] = 'X';

        q.placeToken('X',0);

        q.placeToken('O',1);
        q.placeToken('O',1);

        q.placeToken('X',2);

        BoardPosition f = new BoardPosition(0,1);
        String end = MakeBoardString(temp);

        assertEquals(false, q.isPlayerAtPos(f, 'X'));
        assertEquals(q.toString(), end);

    }

    @Test
    public void testisPlayerAtPos_Test_Three_PIAPFiveByFive_MB(){
        IGameBoard q = MakeAGameBoard(5,5,5);
        char temp[][] = MakeABlankBoard(5,5);

        temp[0][0] = 'J';
        temp[0][1] = 'K';
        temp[0][2] = 'L';
        temp[0][3] = 'V';

        temp[0][4] = 'J';
        temp[1][4] = 'K';
        temp[2][4] = 'L';
        temp[3][4] = 'V';

        q.placeToken('J',0);
        q.placeToken('K',1);
        q.placeToken('L',2);
        q.placeToken('V',3);

        q.placeToken('J',4);
        q.placeToken('K',4);
        q.placeToken('L',4);
        q.placeToken('V',4);

        //Orignally (0,3), miscounted columns.
        BoardPosition f = new BoardPosition(0,2);
        String end = MakeBoardString(temp);

        assertEquals(true, q.isPlayerAtPos(f, 'L'));
        assertEquals(q.toString(), end);

    }

    @Test
    public void testisPlayerAtPos_Test_Four_PINAPFiveByFive_MB(){
        IGameBoard q = MakeAGameBoard(5,5,5);
        char temp[][] = MakeABlankBoard(5,5);

        temp[0][0] = 'J';
        temp[0][1] = 'K';
        temp[0][2] = 'L';
        temp[0][3] = 'V';

        temp[0][4] = 'J';
        temp[1][4] = 'K';
        temp[2][4] = 'L';
        temp[3][4] = 'V';

        q.placeToken('J',0);
        q.placeToken('K',1);
        q.placeToken('L',2);
        q.placeToken('V',3);

        q.placeToken('J',4);
        q.placeToken('K',4);
        q.placeToken('L',4);
        q.placeToken('V',4);

        //Orignally (0,3), miscounted columns.
        BoardPosition f = new BoardPosition(3,4);
        String end = MakeBoardString(temp);

        assertEquals(false, q.isPlayerAtPos(f, 'L'));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testisPlayerAtPos_Test_Five_PIAPFULLFiveByFive_MB(){
        IGameBoard q = MakeAGameBoard(5,5,5);
        char temp[][] = MakeABlankBoard(5,5);

        temp[0][0] = 'J';
        temp[1][0] = 'K';
        temp[2][0] = 'L';
        temp[3][0] = 'V';
        temp[4][0] = 'J';

        temp[0][1] = 'K';
        temp[1][1] = 'K';
        temp[2][1] = 'V';
        temp[3][1] = 'L';
        temp[4][1] = 'J';

        temp[0][2] = 'L';
        temp[1][2] = 'J';
        temp[2][2] = 'K';
        temp[3][2] = 'L';
        temp[4][2] = 'V';

        temp[0][3] = 'V';
        temp[1][3] = 'K';
        temp[2][3] = 'L';
        temp[3][3] = 'V';
        temp[4][3] = 'J';

        temp[0][4] = 'J';
        temp[1][4] = 'K';
        temp[2][4] = 'L';
        temp[3][4] = 'V';
        temp[4][4] = 'J';

        q.placeToken('J',0);
        q.placeToken('K',0);
        q.placeToken('L',0);
        q.placeToken('V',0);
        q.placeToken('J',0);

        q.placeToken('K',1);
        q.placeToken('K',1);
        q.placeToken('V',1);
        q.placeToken('L',1);
        q.placeToken('J',1);

        q.placeToken('L',2);
        q.placeToken('J',2);
        q.placeToken('K',2);
        q.placeToken('L',2);
        q.placeToken('V',2);

        q.placeToken('V',3);
        q.placeToken('K',3);
        q.placeToken('L',3);
        q.placeToken('V',3);
        q.placeToken('J',3);

        q.placeToken('J',4);
        q.placeToken('K',4);
        q.placeToken('L',4);
        q.placeToken('V',4);
        q.placeToken('J',4);

        BoardPosition f = new BoardPosition(4,0);
        String end = MakeBoardString(temp);

        assertEquals(true, q.isPlayerAtPos(f, 'J'));
        assertEquals(q.toString(), end);
    }

    @Test
    public void testplaceToken_Test_One_PT_Unique_Char(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'O';
        temp[0][1] = 'X';

        q.placeToken('O',0);
        q.placeToken('X',1);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(0,1);

        assertEquals(q.whatsAtPos(f), temp[0][1]);
        assertEquals(q.toString(), end);
    }

    @Test
    public void testplaceToken_Test_Two_PT_Full_Board(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'O';
        temp[1][0] = 'X';
        temp[2][0] = 'O';

        temp[0][1] = 'O';
        temp[1][1] = 'X';
        temp[2][1] = 'O';

        temp[0][2] = 'X';
        temp[1][2] = 'X';
        temp[2][2] = 'O';

        q.placeToken('O',0);
        q.placeToken('X',0);
        q.placeToken('O',0);

        q.placeToken('O',1);
        q.placeToken('X',1);
        q.placeToken('O',1);

        q.placeToken('X',2);
        q.placeToken('X',2);
        q.placeToken('O',2);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(2,2);

        assertEquals(q.whatsAtPos(f), temp[2][2]);
        assertEquals(q.toString(), end);
    }

    @Test
    public void testplaceToken_Test_Three_PT_Empty_Board(){
        IGameBoard q = MakeAGameBoard(3,3,3);
        char temp[][] = MakeABlankBoard(3,3);

        temp[0][0] = 'X';
        q.placeToken('X',0);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(0,0);

        assertEquals(q.whatsAtPos(f), temp[0][0]);
        assertEquals(q.toString(), end);
    }

    @Test
    public void testplaceToken_Test_Four_PT_Bigger_Board_HalfFull(){
        IGameBoard q = MakeAGameBoard(4,5,3);
        char temp[][] = MakeABlankBoard(4,5);

        temp[0][0] = 'X';

        temp[0][1] = 'C';
        temp[1][1] = 'C';

        temp[0][2] = 'V';
        temp[1][2] = 'X';
        temp[2][2] = 'V';

        temp[0][3] = 'X';
        temp[1][3] = 'V';

        temp[0][4] = 'C';

        q.placeToken('X',0);

        q.placeToken('C',1);
        q.placeToken('C',1);

        q.placeToken('V',2);
        q.placeToken('X',2);
        q.placeToken('V',2);

        q.placeToken('X',3);
        q.placeToken('V',3);

        q.placeToken('C',4);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(2,2);

        assertEquals(q.whatsAtPos(f), temp[2][2]);
        assertEquals(q.toString(), end);
    }

    @Test
    public void testplaceToken_Test_Five_PT_Bigger_Board_Ontop(){
        IGameBoard q = MakeAGameBoard(4,5,3);
        char temp[][] = MakeABlankBoard(4,5);

        temp[0][0] = 'X';
        temp[1][0] = 'V';

        q.placeToken('X',0);
        q.placeToken('V',0);

        String end = MakeBoardString(temp);

        BoardPosition f = new BoardPosition(1,0);

        assertEquals(q.whatsAtPos(f), temp[1][0]);
        assertEquals(q.toString(), end);

    }
}
