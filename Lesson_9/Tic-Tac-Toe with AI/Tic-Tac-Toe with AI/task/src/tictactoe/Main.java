import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GameScreen tikTak = new GameScreen();
        //System.out.println("Enter cells: ");
        //String cells = scanner.nextLine();
        //tikTak.setSymbols(cells);
        int[] option = new int[2];
        option=tikTak.startMenu();

        while (true) {
            chooseWhoMove(option[0], tikTak);
            tikTak.printGame();
            if(tikTak.gameState())
                break;
            chooseWhoMove(option[1], tikTak);
            tikTak.printGame();
            if(tikTak.gameState())
                break;
        }
    }

    public static void chooseWhoMove(int n, GameScreen tikTak){

        switch (n){
            case 0:
                tikTak.requestCoord();
                break;
            case 1:
                System.out.println("Making move level \"easy\"");
                tikTak.makeMoveEasy();
                break;
            case 2:
                System.out.println("Making move level \"medium\"");
                tikTak.makeMoveMedium();
                break;
            case 3:
                System.out.println("Making move level \"hard\"");
                Move move =tikTak.makeMoveHard(tikTak.getSymbols(), tikTak.IASymbol);
                tikTak.setSymbols(move.getxCoordinates(), move.getyCoordinates(), true);
                break;
            default:
                break;
        }

    }

}
