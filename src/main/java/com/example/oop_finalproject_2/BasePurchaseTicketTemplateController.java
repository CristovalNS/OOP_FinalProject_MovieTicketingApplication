package com.example.oop_finalproject_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

//TODO: This is supposed to be abstract class. Temporarily set as normal.
public class BasePurchaseTicketTemplateController implements Initializable {

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
    private Button button_return;

    @FXML
    private Label label_movie_title;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_movies.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "main-menu.fxml", "<APP NAME> - Account", null, null);
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
