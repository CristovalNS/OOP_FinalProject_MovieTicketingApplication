package com.example.oop_finalproject_2.purchaseticket;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.SeatManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class BasePurchaseTicketTemplateController implements Initializable {

    @FXML
    private Button button_A1;

    @FXML
    private Button button_A2;

    @FXML
    private Button button_A3;

    @FXML
    private Button button_A4;

    @FXML
    private Button button_A5;

    @FXML
    private Button button_A6;

    @FXML
    private Button button_A7;

    @FXML
    private Button button_A8;

    @FXML
    private Button button_B1;

    @FXML
    private Button button_B2;

    @FXML
    private Button button_B3;

    @FXML
    private Button button_B4;

    @FXML
    private Button button_B5;

    @FXML
    private Button button_B6;

    @FXML
    private Button button_B7;

    @FXML
    private Button button_B8;

    @FXML
    private Button button_C1;

    @FXML
    private Button button_C2;

    @FXML
    private Button button_C3;

    @FXML
    private Button button_C4;

    @FXML
    private Button button_C5;

    @FXML
    private Button button_C6;

    @FXML
    private Button button_C7;

    @FXML
    private Button button_C8;

    @FXML
    private Button button_D1;

    @FXML
    private Button button_D2;

    @FXML
    private Button button_D3;

    @FXML
    private Button button_D4;

    @FXML
    private Button button_D5;

    @FXML
    private Button button_D6;

    @FXML
    private Button button_D7;

    @FXML
    private Button button_D8;

    @FXML
    private Button button_E1;

    @FXML
    private Button button_E2;

    @FXML
    private Button button_E3;

    @FXML
    private Button button_E4;

    @FXML
    private Button button_E5;

    @FXML
    private Button button_E6;

    @FXML
    private Button button_E7;

    @FXML
    private Button button_E8;

    @FXML
    private Button button_F1;

    @FXML
    private Button button_F2;

    @FXML
    private Button button_F3;

    @FXML
    private Button button_F4;

    @FXML
    private Button button_F5;

    @FXML
    private Button button_F6;

    @FXML
    private Button button_F7;

    @FXML
    private Button button_F8;

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
    private Label label_movie_duration;

    @FXML
    private Label label_movie_time;

    @FXML
    private Label label_movie_title;

    @FXML
    private Label label_movie_availability;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set button cursors
        Button[] buttons_menu = { button_account, button_food, button_movies, button_purchases, button_buy_ticket, button_return };

        for (Button button : buttons_menu) {
            button.setCursor(Cursor.HAND);
        }

        Button[] buttons_chairs = { button_A1, button_A2, button_A3, button_A4, button_A5, button_A6, button_A7, button_A8
                , button_B1, button_B2, button_B3, button_B4, button_B5, button_B6, button_B7, button_B8
                , button_C1, button_C2, button_C3, button_C4, button_C5, button_C6, button_C7, button_C8
                , button_D1, button_D2, button_D3, button_D4, button_D5, button_D6, button_D7, button_D8
                , button_E1, button_E2, button_E3, button_E4, button_E5, button_E6, button_E7, button_E8
                , button_F1, button_F2, button_F3, button_F4, button_F5, button_F6, button_F7, button_F8};

        for (Button button : buttons_chairs) {
            button.setCursor(Cursor.HAND);
        }

        // ChangeScenes after button click
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
