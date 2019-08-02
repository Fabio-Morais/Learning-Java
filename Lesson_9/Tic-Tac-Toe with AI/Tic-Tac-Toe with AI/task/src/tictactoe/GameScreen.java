package tictactoe;

import java.util.ArrayList;

public class GameScreen {
    private ArrayList <Character> symbols;

    public GameScreen() {
        this.symbols = new ArrayList<Character>();
    }

    public void setSymbols(String cells) {
        System.out.println(cells.length());
        if(cells.length() != 11)
            System.out.println("error");
        else{
            for(int i=1; i<cells.length()-1; i++){
                this.symbols.add(Character.toUpperCase(cells.charAt(i)));
            }
        }
    }

    public void printGame(){
       if(this.symbols.size() == 9) {
           for (int i = 0; i < 5; i++) {
               if (i == 0 || i == 4)
                   System.out.println("---------");
               else {
                   System.out.print("| ");
                   for (int j = ((i-1) * 3); j < (3 + ((i-1) * 3)); j++) {
                       System.out.print(symbols.get(j) + " ");
                   }
                   System.out.print("|\n");
               }

           }
       }

    }

    public void gameState(){

    }
}
