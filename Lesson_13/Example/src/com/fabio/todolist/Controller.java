package com.fabio.todolist;

import com.fabio.todolist.datamodel.TodoData;
import com.fabio.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;
    public void initialize(){
       /* TodoItem item1 = new TodoItem("Mail birthday card","Buy a 30th birthday card for john", LocalDate.of(2016, Month.APRIL, 25));
        TodoItem item2 = new TodoItem("Doctor's Appointment","See Dr.Smith at 123 main street. bring ", LocalDate.of(2016, Month.MAY, 20));
        TodoItem item3 = new TodoItem("Finish my work","Finish my project", LocalDate.of(2016, Month.JULY, 11));
        TodoItem item4 = new TodoItem("Pickup doug t the train station","Doug-s arriving on march 23 on march", LocalDate.of(2016, Month.AUGUST, 5));
        todoItems = new ArrayList<>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);

        TodoData.getInstance().setTodoItems(todoItems);*/

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if(newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, YYYY");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });
        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // se carregar no shift nao seleciona mais que 1
        todoListView.getSelectionModel().selectFirst();
    }
    @FXML
    public void handleClickListView(){

        /*TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, YYYY");
        deadlineLabel.setText(df.format(item.getDeadline()));
        deadlineLabel.setText(item.getDeadline().toString());
        System.out.println(item);
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline());
        itemDetailsTextArea.setText(sb.toString());*/
    }
    }
