package editor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextEditor extends JFrame {

    public TextEditor() {
        super("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        Color color = new Color(240, 240, 245);

        /********CENTER  PANEL**********/
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(color);
        panel.setBorder(new EmptyBorder(5,40,20,40));
         getContentPane().add(panel);

        /********NORTH  PANEL**********/
        JPanel topPanel = new JPanel();
        topPanel.setBackground(color);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(topPanel, BorderLayout.NORTH);


        /************MENU*************/
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.white);
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        fileMenu.setName("MenuFile");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        JMenuItem MenuLoad = new JMenuItem("Load");
        MenuLoad.setName("MenuLoad");
        JMenuItem MenuSave = new JMenuItem("Save");
        MenuSave.setName("MenuSave");
        JMenuItem MenuExit = new JMenuItem("Exit");
        MenuExit.setName("MenuExit");

        fileMenu.add(MenuLoad);
        fileMenu.add(MenuSave);
        fileMenu.addSeparator();
        fileMenu.add(MenuExit);


        /********NORTH**********/
        JTextField FilenameField=new JTextField(16);
        FilenameField.setName("FilenameField");
        JButton SaveButton=new JButton("Save");
        SaveButton.setName("SaveButton");
        JButton LoadButton=new JButton("Load");
        LoadButton.setName("LoadButton");

        topPanel.add(FilenameField);
        topPanel.add(SaveButton);
        topPanel.add(LoadButton);

        /*********CENTER*********/

        JTextArea TextArea=new JTextArea("");
        TextArea.setName("TextArea");
        panel.add(TextArea, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(TextArea);
        scroll.setName("ScrollPane");
        panel.add(scroll);


        MenuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        MenuSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean works = saveTextFile(FilenameField.getText(), TextArea.getText());
            }
        });

        MenuLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = getTextFile(FilenameField.getText());
                TextArea.setText(text);
            }
        });


        LoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = getTextFile(FilenameField.getText());
                TextArea.setText(text);
            }
        });

        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean works = saveTextFile(FilenameField.getText(), TextArea.getText());
                Sec sec = new Sec();
                /*dispose();
                sec.setVisible(true);*/
            }
        });

        setVisible(true);
       
    }
    private String getTextFile(String nameFile){
        try{
            File file = new File(nameFile);
            String data = new String(Files.readAllBytes(Paths.get(nameFile)));
            return data;
        }catch (IOException e){
            System.out.println("file does not exit");
            return null;
        }
    }
    private boolean saveTextFile(String nameFile, String text){
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(text);
            myWriter.close();
            //System.out.println(text);
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            return false;
        }
    }

}
