package tictactoe;

public class GameScreen {
    private char[][] symbols;
    private int numX;
    private int numY;
    public GameScreen() {
        this.symbols = new char[3][3];
        numX=0;
        numY=0;
    }

    public void setSymbols(String cells) {
        System.out.println(cells.length());
        if(cells.length() != 11)
            System.out.println("error");
        else{
            int c=0;
            int r=0;
            for(int i=1; i<cells.length()-1; i++){

                if(i==4 || i==7)
                {
                    c++;
                    r=0;
                }
                this.symbols[c][r] = Character.toUpperCase(cells.charAt(i));
                if(this.symbols[c][r] == "X".charAt(0))
                    numX++;
                else if(this.symbols[c][r] == "O".charAt(0))
                    numY++;
                r++;
            }
        }
    }

    public boolean isEmpty(int x, int y){
        int x1=Math.abs(x-1);
        int y1=Math.abs(y-3);

        return this.symbols[y1][x1]==" ".charAt(0);

    }

    public void printGame(){

           for (int i = 0; i < 5; i++) {
               if (i == 0 || i == 4)
                   System.out.println("---------");
               else {
                   System.out.print("| ");
                   for (int j = 0; j < 3; j++) {
                       System.out.print(symbols[i-1][j] + " ");
                   }
                   System.out.print("|\n");
               }

           }


    }

    public void setCoordSymb(int x, int y){
        int x1=Math.abs(x-1);
        int y1=Math.abs(y-3);
        this.symbols[y1][x1]="X".charAt(0);
    }

    public void gameState(){
        boolean xWins=false;
        boolean oWins=false;
        String winV, winH, winD;
        /*Diagonal*/
        winD=""+this.symbols[0][0]+""+this.symbols[1][1]+""+this.symbols[2][2]+ ""+this.symbols[0][2]+""+this.symbols[1][1]+""+this.symbols[2][0];

        for(int i=0; i<3; i++){
                /*vertical*/
            winV=""+this.symbols[i][0]+""+this.symbols[i][1]+""+this.symbols[i][2];
                /*horizontal*/
            winH=""+this.symbols[0][i]+""+this.symbols[1][i]+""+this.symbols[2][i];

            if(winV.equals("XXX") || winH.equals("XXX") || winD.substring(0,3).equals("XXX") || winD.substring(3,6).equals("XXX"))
                xWins=true;
            else if(winV.equals("OOO") || winH.equals("OOO") || winD.substring(0,3).equals("OOO") || winD.substring(3,6).equals("OOO"))
                oWins=true;

        }

        /* Print game state */
        if(xWins && oWins || (Math.abs(numX-numY)>1))
            System.out.println("Impossible");
        else if(xWins)
            System.out.println("X wins");
        else if(oWins)
            System.out.println("O wins");
        else if((numY+numX) != 9)
            System.out.println("Game not finished");
        else
            System.out.println("Draw");
    }
}
