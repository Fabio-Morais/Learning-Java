package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class Controller {

    private GameScreen gameScreen = new GameScreen();
    @FXML
    private Button b00,b01,b02,b10,b11,b12,b20,b21,b22;
    @FXML
    public void handleActionButton(){
        char[][] symbols = gameScreen.getSymbols();
        char empty=" ".charAt(0);

        /*of button clicked and array is empty (without a symbol O,X)*/
        if(b00.isArmed() && symbols[0][0]==empty){
            changeButtonStyle(b00);
        }else if(b01.isArmed() && symbols[0][1]==empty){
            changeButtonStyle(b01);
        }else if(b02.isArmed() && symbols[0][2]==empty){
            changeButtonStyle(b02);
        }else if(b10.isArmed() && symbols[1][0]==empty){
            changeButtonStyle(b10);
        }else if(b11.isArmed() && symbols[1][1]==empty){
            changeButtonStyle(b11);
        }else if(b12.isArmed() && symbols[1][2]==empty){
            changeButtonStyle(b12);
        }else if(b20.isArmed() && symbols[2][0]==empty){
            changeButtonStyle(b20);
        }else if(b21.isArmed() && symbols[2][1]==empty){
            changeButtonStyle(b21);
        }else if(b22.isArmed() && symbols[2][2]==empty){
            changeButtonStyle(b22);
        }

    }

    public void changeButtonStyle(Button button){
        if(gameScreen.getWhoPlay() == 0){
            button.setStyle("-fx-background-image: url('x.jpg');");
        }else if(gameScreen.getWhoPlay() == 1){
            button.setStyle("-fx-background-image: url('o.jpg');");
        }
        gameScreen.changeWhoPlay();
    }

}
