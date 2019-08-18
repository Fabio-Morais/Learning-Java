package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label nameField; //nome igual ao sample.fxml
    @FXML
    private Label ourLabel;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private TextField textField;

    @FXML
    public void initialize(){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }
    @FXML
    public void unButtonClicked(ActionEvent e){
        Runnable task = new Runnable() {
            @Override
            public void run() {

                /*FAZER COISA EM PARALELO SEM TRAVAR*/
                try{
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println(s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println(s);
                            ourLabel.setText("we did something!");
                        }
                    });
                }catch(InterruptedException exce){

                }
            }
        };

        new Thread(task).start();

        nameField.setVisible(true);
        if(e.getSource().equals(helloButton))
            nameField.setText("Hello " + textField.getText());
        else if(e.getSource().equals(byeButton))
            nameField.setText("Bye " + textField.getText());
        System.out.println( nameField.getText());
        System.out.println(e.getSource());
    }

    @FXML
    public void handleKeyReleased(){
        String text = textField.getText();
        boolean disableButton = text.isEmpty() | text.trim().isEmpty();
        helloButton.setDisable(disableButton);
        byeButton.setDisable(disableButton);
    }
}
