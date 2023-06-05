package com.example.oop_finalproject_2.view;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.controller.MainMenuController;
import com.example.oop_finalproject_2.domainmodel.UserSessionDM;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class MainMenuView implements Initializable {

    @FXML
    private Button button_account;

    @FXML
    private Button button_food;

    @FXML
    private Button button_movies;

    @FXML
    private Button button_purchases;

    @FXML
    private Button button_next_page;

    @FXML
    private Button button_movieP1;

    @FXML
    private Button button_movieP2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_account.setCursor(Cursor.HAND);
        button_food.setCursor(Cursor.HAND);
        button_movies.setCursor(Cursor.HAND);
        button_purchases.setCursor(Cursor.HAND);
        button_next_page.setCursor(Cursor.HAND);
        button_movieP1.setCursor(Cursor.HAND);
        button_movieP2.setCursor(Cursor.HAND);

        button_account.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "account.fxml", "<APP NAME> - Account", null, null);
            }
        });

        button_purchases.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMenuController.purchaseCheck();

                if (MainMenuController.purchaseCheck()) {
                    DBUtils.changeScene(event, "purchase-history.fxml", "<APP NAME> - Account", null, null);
                }
            }
        });

        button_movieP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "movie-p1.fxml", "<APP NAME> - Movie1", null, null);
            }
        });

        button_movieP2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "movie-p2.fxml", "<APP NAME> - Movie2", null, null);
            }
        });
    }
}

