package com.example.oop_finalproject_2.view;

import com.example.oop_finalproject_2.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseMovieTemplate_View implements Initializable {

    @FXML
    private Button button_account;

    @FXML
    private Button button_buy_ticket;

    @FXML
    private Button button_food;

    @FXML
    private Button button_movies;

    @FXML
    private Button button_purchases;

    @FXML
    private Label label_movie_desc;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set button cursors
        Button[] buttons = {button_account, button_food, button_movies, button_purchases, button_buy_ticket};
        for (Button button : buttons) {
            button.setCursor(Cursor.HAND);
        }

        label_movie_desc.setWrapText(true);
        label_movie_desc.setMaxWidth(300);

        button_movies.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "main-menu.fxml", "<APP NAME> - Account", null, null);
            }
        });

        button_purchases.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "purchase-history.fxml", "<APP NAME> - Account", null, null);
            }
        });

        button_account.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "account.fxml", "<APP NAME> - Account", null, null);
            }
        });
    }
}
