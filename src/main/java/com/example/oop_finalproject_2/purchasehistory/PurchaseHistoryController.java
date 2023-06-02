package com.example.oop_finalproject_2.purchasehistory;

import com.example.oop_finalproject_2.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class PurchaseHistoryController implements Initializable {

    @FXML
    private Button button_account;

    @FXML
    private Button button_food;

    @FXML
    private Button button_movies;

    @FXML
    private Button button_purchases;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Button[] buttons = {button_account, button_food, button_purchases, button_movies};
        for (Button button : buttons) {
            button.setCursor(Cursor.HAND);
        }
        button_account.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "account.fxml", "<APP NAME> - Account", null, null);
            }
        });

        button_movies.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "main-menu.fxml", "<APP NAME> - Movies", null, null);
            }
        });

    }
}
