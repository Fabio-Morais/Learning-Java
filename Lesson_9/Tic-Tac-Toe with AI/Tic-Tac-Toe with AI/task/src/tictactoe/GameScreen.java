
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameScreen {
    private char[][] symbols;
    private int numX;
    private int numO;

    private int whoPlay;    /* * 0-> FIRST PLAYER * 1-> SECOND PLAYER * */
    public String IASymbol;
    public String enemySymbol;

    private static Scanner scanner = new Scanner(System.in);

    /*  CONSTRUCTURE*/
    public GameScreen() {
        this.symbols = new char[3][3];
        this.resetGame();

    }

    /*      RESET VARIABLES AND SET " " TO ARRAY OF SYMBOLS     */
    public void resetGame() {
        numX = 0;
        numO = 0;
        whoPlay = 0; // I start first
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                this.symbols[i][j] = " ".charAt(0);
        }
        this.printGame();
    }

    /*      SET SMBOLS BY STRING*/
    public void setSymbols(String cells) {
        System.out.println(cells.length());
        if (cells.length() != 11)
            System.out.println("error");
        else {
            int c = 0;
            int r = 0;
            for (int i = 1; i < cells.length() - 1; i++) {

                if (i == 4 || i == 7) {
                    c++;
                    r = 0;
                }
                this.symbols[c][r] = Character.toUpperCase(cells.charAt(i));
                if (this.symbols[c][r] == "X".charAt(0))
                    numX++;
                else if (this.symbols[c][r] == "O".charAt(0))
                    numO++;
                r++;
            }
        }
    }

    /*      INPUT OF START  USER/EASY/MEDUM/HARD
     *       RETURN: ARRAY OF PLAYERS, [0]-> first, [1]->second
     *       IE: START EASY USER     -> [O]->EASY, [1]-> USER
     *  */
    public int[] startMenu() {
        int[] option = new int[2];
        String[] splitStr;
        while (true) {
            System.out.print("Input command: ");
            String string = scanner.nextLine();
            splitStr = string.split(" ");
            if (splitStr.length != 3)
                System.out.println("Bad parameters!");
            else {
                if (!splitStr[0].toUpperCase().equals("START"))
                    System.out.println("Bad parameters!");
                else
                    break;
            }
        }
        if (splitStr[1].toUpperCase().equals("USER"))
            option[0] = 0;
        else if (splitStr[1].toUpperCase().equals("EASY"))
            option[0] = 1;
        else if (splitStr[1].toUpperCase().equals("MEDIUM"))
            option[0] = 2;
        else if (splitStr[1].toUpperCase().equals("HARD")) {
            option[0] = 3;
            enemySymbol = "O";
            IASymbol = "X";
        }

        if (splitStr[2].toUpperCase().equals("USER"))
            option[1] = 0;
        else if (splitStr[2].toUpperCase().equals("EASY"))
            option[1] = 1;
        else if (splitStr[2].toUpperCase().equals("MEDIUM"))
            option[1] = 2;
        else if (splitStr[2].toUpperCase().equals("HARD")) {
            option[1] = 3;
            enemySymbol = "X";
            IASymbol = "O";
        }


        return option;
    }

    public void printMenu(){
        System.out.println("User vs user");
        System.out.println("User vs pc");
    }
    public void printMenu2(){
        System.out.println("Easy Mode");
        System.out.println("Medium Mode");
        System.out.println("Hard Mode");
    }
    /*      MAKE A MOVE EASY (RANDOM)   */
    public void makeMoveEasy() {
        /*1 to 3*/
        int x, y;

        Random random = new Random();
        /*
         * ((Max - Min)+1) + 1
         * */
        while (true) {
            x = random.nextInt((3 - 1) + 1) + 1;
            y = random.nextInt((3 - 1) + 1) + 1;
            if (this.isEmpty(x, y))
                break;
        }
        this.setSymbols(x, y);
        this.changeWhoPlay();
    }

    /*      MAKE A MOVE EASY (RANDOM)   */
    public void makeMoveMedium() {
        if (!this.winMove()) {// if can't win
            if (!this.enemyWinMove()) // if can't combat the enemy
                this.makeMoveEasy();//random move
        }

    }

    public Move makeMoveHard(char[][] board, String player) {
        Move minimaxResult = new Move();
        int bestResult = -11;
        /*
        * 0-> Y, i
        * 1-> X, j
        * */
        int[][] availableSpaces= emptyIndexies(board);
        if(availableSpaces.length == 8 && board[1][1] == " ".charAt(0)){
            minimaxResult.setSimulationResult(10);
            int[] aux= winning(board, IASymbol);
            minimaxResult.setxCoordinates(1);
            minimaxResult.setyCoordinates(1);
            return minimaxResult;
        }

        if(winning(board, IASymbol) != null ){
            System.out.println("ia");
            minimaxResult.setSimulationResult(10);
            int[] aux= winning(board, IASymbol);
            minimaxResult.setxCoordinates(aux[1]);
            minimaxResult.setyCoordinates(aux[0]);
            return minimaxResult;
        }else if(winning(board, enemySymbol) != null){
            System.out.println("enem");
            minimaxResult.setSimulationResult(-10);
            int[] aux= winning(board, enemySymbol);
            minimaxResult.setxCoordinates(aux[1]);
            minimaxResult.setyCoordinates(aux[0]);
            return minimaxResult;
        }else if(availableSpaces.length == 0){
            minimaxResult.setSimulationResult(0);
            minimaxResult.setIsDraw(true);
            return minimaxResult;
        }
        List<Move> moves = new ArrayList<>();
        for(int i=0; i<availableSpaces.length; i++){

            Move currentResult = new Move();
            currentResult.setxCoordinates(availableSpaces[i][1]);
            currentResult.setyCoordinates(availableSpaces[i][0]);

            // set the empty spot to the current player
            board[availableSpaces[i][0]][availableSpaces[i][1]] = player.charAt(0);

            //if collect the score resulted from calling minimax on the opponent of the current player
            String aux="X";
            if(player.equals(IASymbol)){
                aux= enemySymbol;
            }else if(player.equals(enemySymbol)){
                aux= IASymbol;
            }
            Move currentResultAux= makeMoveHard(board, aux);
            currentResult.setSimulationResult(currentResultAux.getSimulationResult());

            moves.add(currentResult);
            board[availableSpaces[i][0]][availableSpaces[i][1]] = " ".charAt(0);

           /* if(player.equals(IASymbol)){
                if(bestResult < currentResult.getSimulationResult() || bestResult == -11){
                    bestResult = currentResult.getSimulationResult();
                    minimaxResult.setSimulationResult(currentResult.getSimulationResult());
                    minimaxResult.setxCoordinates(availableSpaces[i][1]);
                    minimaxResult.setyCoordinates(availableSpaces[i][0]);
                }
            }else {
                if(bestResult > currentResult.getSimulationResult() || bestResult == -11){
                    bestResult = currentResult.getSimulationResult();
                    minimaxResult.setSimulationResult(currentResult.getSimulationResult());
                    minimaxResult.setxCoordinates(availableSpaces[i][1]);
                    minimaxResult.setyCoordinates(availableSpaces[i][0]);
                }
            }*/
        }

        int bestMove=0;
        if(player.equals(IASymbol)){
            int bestScore=-10000;
            for(int i=0; i<moves.size(); i++){

                if(moves.get(i).getSimulationResult() > bestScore){
                    bestScore =  moves.get(i).getSimulationResult();
                    bestMove = i;
                }
            }
        }else{
            int bestScore= 10000;
            for(int i=0; i<moves.size(); i++){
                if(moves.get(i).getSimulationResult() < bestScore){
                    bestScore =  moves.get(i).getSimulationResult();
                    bestMove = i;
                }
            }

        }
        System.out.println(moves.get(bestMove).getxCoordinates() + " .> "+  moves.get(bestMove).getyCoordinates());

        return moves.get(bestMove);
    }

    public boolean winMove() {
        String winV, winH, mySymbol;
        int r = -1;
        int c = -1;
        boolean set = false;
        if (whoPlay == 0)
            mySymbol = "X";
        else if (whoPlay == 1)
            mySymbol = "O";
        else
            mySymbol = "error";


        for (int i = 0; i < 3; i++) {
            /*horizontal*/
            winH = "" + this.symbols[i][0] + "" + this.symbols[i][1] + "" + this.symbols[i][2];
            /*vertical*/
            winV = "" + this.symbols[0][i] + "" + this.symbols[1][i] + "" + this.symbols[2][i];

            /*  HORIZONTAL  */
            if (winH.equals(" " + mySymbol + mySymbol)) {
                c = i;
                r = 0;
                set = true;
                break;
            } else if (winH.equals(mySymbol + " " + mySymbol)) {
                c = i;
                r = 1;
                set = true;
                break;
            } else if (winH.equals(mySymbol + mySymbol + " ")) {
                c = i;
                r = 2;
                set = true;
                break;
                /*  VERTICAL  */
            } else if (winV.equals(" " + mySymbol + mySymbol)) {
                c = 0;
                r = i;
                set = true;
                break;
                /*  "X X"  */
            } else if (winV.equals(mySymbol + " " + mySymbol)) {
                c = 1;
                r = i;
                set = true;
                break;
                /*  "XX "  */
            } else if (winV.equals(mySymbol + mySymbol + " ")) {
                c = 2;
                r = i;
                set = true;
                break;
            }
        }
        /*Diagonal*/
        String winD = "" + this.symbols[0][0] + "" + this.symbols[1][1] + "" + this.symbols[2][2] + "" + this.symbols[0][2] + "" + this.symbols[1][1] + "" + this.symbols[2][0];

        if (winD.substring(0, 3).equals(mySymbol + mySymbol + " ")) {
            r = 2;
            c = 2;
            set = true;
        } else if (winD.substring(0, 3).equals(mySymbol + " " + mySymbol)) {
            r = 1;
            c = 1;
            set = true;
        } else if (winD.substring(0, 3).equals(" " + mySymbol + mySymbol)) {
            r = 0;
            c = 0;
            set = true;
        } else if (winD.substring(3, 6).equals(mySymbol + mySymbol + " ")) {
            r = 0;
            c = 2;
            set = true;
        } else if (winD.substring(3, 6).equals(mySymbol + " " + mySymbol)) {
            r = 1;
            c = 1;
            set = true;
        } else if (winD.substring(3, 6).equals(" " + mySymbol + mySymbol)) {
            r = 2;
            c = 0;
            set = true;
        }

        this.setSymbols(r, c, set);
        return set;
    }

    public boolean enemyWinMove() {
        String winV, winH, enemySymbol;
        int r = -1;
        int c = -1;
        boolean set = false;
        if (whoPlay == 0)
            enemySymbol = "O";
        else if (whoPlay == 1)
            enemySymbol = "X";
        else
            enemySymbol = "error";


        for (int i = 0; i < 3; i++) {
            /*horizontal*/
            winH = "" + this.symbols[i][0] + "" + this.symbols[i][1] + "" + this.symbols[i][2];
            /*vertical*/
            winV = "" + this.symbols[0][i] + "" + this.symbols[1][i] + "" + this.symbols[2][i];

            /*  HORIZONTAL  */
            if (winH.equals(" " + enemySymbol + enemySymbol)) {
                c = i;
                r = 0;
                set = true;
                break;
            } else if (winH.equals(enemySymbol + " " + enemySymbol)) {
                c = i;
                r = 1;
                set = true;
                break;
            } else if (winH.equals(enemySymbol + enemySymbol + " ")) {
                c = i;
                r = 2;
                set = true;
                break;
                /*  VERTICAL  */
            } else if (winV.equals(" " + enemySymbol + enemySymbol)) {
                c = 0;
                r = i;
                set = true;
                break;
                /*  "X X"  */
            } else if (winV.equals(enemySymbol + " " + enemySymbol)) {
                c = 1;
                r = i;
                set = true;
                break;
                /*  "XX "  */
            } else if (winV.equals(enemySymbol + enemySymbol + " ")) {
                c = 2;
                r = i;
                set = true;
                break;
            }
        }
        /*Diagonal*/
        String winD = "" + this.symbols[0][0] + "" + this.symbols[1][1] + "" + this.symbols[2][2] + "" + this.symbols[0][2] + "" + this.symbols[1][1] + "" + this.symbols[2][0];

        if (winD.substring(0, 3).equals(enemySymbol + enemySymbol + " ")) {
            r = 2;
            c = 2;
            set = true;
        } else if (winD.substring(0, 3).equals(enemySymbol + " " + enemySymbol)) {
            r = 1;
            c = 1;
            set = true;
        } else if (winD.substring(0, 3).equals(" " + enemySymbol + enemySymbol)) {
            r = 0;
            c = 0;
            set = true;
        } else if (winD.substring(3, 6).equals(enemySymbol + enemySymbol + " ")) {
            r = 0;
            c = 2;
            set = true;
        } else if (winD.substring(3, 6).equals(enemySymbol + " " + enemySymbol)) {
            r = 1;
            c = 1;
            set = true;
        } else if (winD.substring(3, 6).equals(" " + enemySymbol + enemySymbol)) {
            r = 2;
            c = 0;
            set = true;
        }

        this.setSymbols(r, c, set);
        return set;
    }

    public int[] winning(char[][] board, String symbolPlay) {
        String winV, winH;
        int r = -1;
        int c = -1;
        boolean set = false;


        for (int i = 0; i < 3; i++) {
            /*horizontal*/
            winH = "" + this.symbols[i][0] + "" + this.symbols[i][1] + "" + this.symbols[i][2];
            /*vertical*/
            winV = "" + this.symbols[0][i] + "" + this.symbols[1][i] + "" + this.symbols[2][i];

            /*  HORIZONTAL  */
            if (winH.equals(" " + symbolPlay + symbolPlay)) {
                c = i;
                r = 0;
                set = true;
                break;
            } else if (winH.equals(symbolPlay + " " + symbolPlay)) {
                c = i;
                r = 1;
                set = true;
                break;
            } else if (winH.equals(symbolPlay + symbolPlay + " ")) {
                c = i;
                r = 2;
                set = true;
                break;
                /*  VERTICAL  */
            } else if (winV.equals(" " + symbolPlay + symbolPlay)) {
                c = 0;
                r = i;
                set = true;
                break;
                /*  "X X"  */
            } else if (winV.equals(symbolPlay + " " + symbolPlay)) {
                c = 1;
                r = i;
                set = true;
                break;
                /*  "XX "  */
            } else if (winV.equals(symbolPlay + symbolPlay + " ")) {
                c = 2;
                r = i;
                set = true;
                break;
            }
        }
        /*Diagonal*/
        String winD = "" + this.symbols[0][0] + "" + this.symbols[1][1] + "" + this.symbols[2][2] + "" + this.symbols[0][2] + "" + this.symbols[1][1] + "" + this.symbols[2][0];

        if (winD.substring(0, 3).equals(symbolPlay + symbolPlay + " ")) {
            r = 2;
            c = 2;
            set = true;
        } else if (winD.substring(0, 3).equals(symbolPlay + " " + symbolPlay)) {
            r = 1;
            c = 1;
            set = true;
        } else if (winD.substring(0, 3).equals(" " + symbolPlay + symbolPlay)) {
            r = 0;
            c = 0;
            set = true;
        } else if (winD.substring(3, 6).equals(symbolPlay + symbolPlay + " ")) {
            r = 0;
            c = 2;
            set = true;
        } else if (winD.substring(3, 6).equals(symbolPlay + " " + symbolPlay)) {
            r = 1;
            c = 1;
            set = true;
        } else if (winD.substring(3, 6).equals(" " + symbolPlay + symbolPlay)) {
            r = 2;
            c = 0;
            set = true;
        }
        if(r!=-1 && c!= -1){
            int[] coord = new int[2];
            coord[1]=r;
            coord[0]=c;
            return coord;
        }else
            return null;
    }

    public int[][] emptyIndexies(char[][] board) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == " ".charAt(0)) {
                    count++;
                }

            }
        }
        int[][] array = new int[count][2];
        count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == " ".charAt(0)) {
                    array[count][0] = i;
                    array[count][1] = j;
                    count++;
                }

            }
        }
        return array;

    }

    /*      REQUEST COORDINATES FOR USER PLAYER */
    public boolean requestCoord() {
        int aux;
        int x = 4;
        int y = 4;

        while (true) {
            System.out.print("Enter the number: ");
            if(!scanner.hasNextInt()){
                System.out.println("invalid, just numbers allow");
            }
           else{
                aux = scanner.nextInt();
                if ((aux>9 && aux <1) )
                    System.out.println("You should enter valid numbers (1-9) !");
                else {
                    break;
                }
            }

        }
        switch (aux){
            case 1:
                x=1;
                y=1;
                break;
            case 2:
                x=2;
                y=1;
                break;
            case 3:
                x=3;
                y=1;
                break;
            case 4:
                x=1;
                y=2;
                break;
            case 5:
                x=2;
                y=2;
                break;
            case 6:
                x=3;
                y=2;
                break;
            case 7:
                x=1;
                y=3;
                break;
            case 8:
                x=2;
                y=3;
                break;
            case 9:
                x=3;
                y=3;
                break;
        }
        this.setSymbols(x, y);
        this.changeWhoPlay();
        return true;
    }

    /*      CHECK IF IS EMPTY   (X,Y)
     *       RETURN: TRUE / FALSE    */
    public boolean isEmpty(int x, int y) {
        int x1 = Math.abs(x - 1);
        int y1 = Math.abs(y - 3);

        return this.symbols[y1][x1] == " ".charAt(0);

    }

    /*      PRINT ALL ARRAY OF SYMBOLS  */
    public void printGame() {

        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 4)
                System.out.println("---------");
            else {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(symbols[i - 1][j] + " ");
                }
                System.out.print("|\n");
            }

        }


    }

    /*      SET SMBOLS BY COORDINATES   */
    public void setSymbols(int x, int y) {
        int x1 = Math.abs(x - 1);
        int y1 = Math.abs(y - 3);
        if (whoPlay == 0) {
            this.symbols[y1][x1] = "X".charAt(0);
            numX++;
        } else if (whoPlay == 1) {
            this.symbols[y1][x1] = "O".charAt(0);
            numO++;
        }
    }

    public void setSymbols(int r, int c, boolean aux) {
        if (aux) {
            if (whoPlay == 0) {
                this.symbols[c][r] = "X".charAt(0);
                numX++;
            } else if (whoPlay == 1) {
                this.symbols[c][r] = "O".charAt(0);
                numO++;
            }
            this.changeWhoPlay();//change turn
        }
    }

    /*      CHECK IF GAME IS FINISHED AND PRINT*/
    public boolean gameState() {
        boolean xWins = false;
        boolean oWins = false;
        String winV, winH, winD;
        /*Diagonal*/
        winD = "" + this.symbols[0][0] + "" + this.symbols[1][1] + "" + this.symbols[2][2] + "" + this.symbols[0][2] + "" + this.symbols[1][1] + "" + this.symbols[2][0];

        for (int i = 0; i < 3; i++) {
            /*vertical*/
            winH = "" + this.symbols[i][0] + "" + this.symbols[i][1] + "" + this.symbols[i][2];
            /*horizontal*/
            winV = "" + this.symbols[0][i] + "" + this.symbols[1][i] + "" + this.symbols[2][i];

            if (winV.equals("XXX") || winH.equals("XXX") || winD.substring(0, 3).equals("XXX") || winD.substring(3, 6).equals("XXX"))
                xWins = true;
            else if (winV.equals("OOO") || winH.equals("OOO") || winD.substring(0, 3).equals("OOO") || winD.substring(3, 6).equals("OOO"))
                oWins = true;

        }

        /* Print game state */
        if (xWins && oWins || (Math.abs(numX - numO) > 1))
            System.out.println("Impossible");
        else if (xWins)
            System.out.println("X wins");
        else if (oWins)
            System.out.println("O wins");
        else if ((numO + numX) != 9) {
            //System.out.println("Game not finished");
            return false;
        } else
            System.out.println("Draw");

        return true;
    }

    /*      CHANGE THE VALUE OF WHOPLAY VARIABLE*/
    private void changeWhoPlay() {
        if (whoPlay == 0)
            whoPlay = 1;
        else if (whoPlay == 1)
            whoPlay = 0;
    }

    public char[][] getSymbols() {
        return symbols;
    }
}
