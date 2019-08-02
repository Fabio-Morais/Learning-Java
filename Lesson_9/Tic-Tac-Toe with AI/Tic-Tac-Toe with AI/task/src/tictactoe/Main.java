package tictactoe;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter cells: ");
        String cells= scanner.nextLine();
        GameScreen tikTak = new GameScreen();
        tikTak.setSymbols(cells);
        tikTak.printGame();
    }

}
