package tictactoe;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter cells: ");
        String cells = scanner.nextLine();
        GameScreen tikTak = new GameScreen();
        tikTak.setSymbols(cells);
        tikTak.printGame();

        String aux;
        int x = 4;
        int y = 4;

        while (true) {
            System.out.print("Enter the coordinates: ");
            aux = scanner.nextLine();

            if (!Character.isDigit(aux.charAt(0)) || !Character.isDigit(aux.charAt(2)))
                System.out.println("You should enter numbers!");
            else {
                x = Character.getNumericValue(aux.charAt(0));
                y = Character.getNumericValue(aux.charAt(2));
                if ((x >= 1 && x <= 3) && (y >= 1 && y <= 3) && tikTak.isEmpty(x,y))
                    break;
                else if((x >= 1 && x <= 3) && (y >= 1 && y <= 3) && !tikTak.isEmpty(x,y))
                    System.out.println("This cell is occupied! Choose another one!");
                else
                    System.out.println("Coordinates should be from 1 to 3!");
            }

        }


        tikTak.setCoordSymb(x, y);
        tikTak.printGame();
        //  tikTak.gameState();
    }

}
