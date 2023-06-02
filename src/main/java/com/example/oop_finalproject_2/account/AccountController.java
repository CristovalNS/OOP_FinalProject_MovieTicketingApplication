package com.example.oop_finalproject_2.account;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.UserSession;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {
    @FXML
    private Button button_account;

    @FXML
    private Button button_change_details;

    @FXML
    private Button button_food;

    @FXML
    private Button button_movies;

    @FXML
    private Button button_purchases;

    @FXML
    private Label label_email;

    @FXML
    private Label label_password;

    @FXML
    private Label label_username;

    @FXML
    private Label label_user_id;

    @FXML
    private Button button_log_out;

    protected String username;

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Set button cursors
        button_change_details.setCursor(Cursor.HAND);
        button_account.setCursor(Cursor.HAND);
        button_food.setCursor(Cursor.HAND);
        button_movies.setCursor(Cursor.HAND);
        button_purchases.setCursor(Cursor.HAND);
        button_log_out.setCursor(Cursor.HAND);

        // Retrieve user ID from the database and update the label
        int userId = DBUtils.getUserId(UserSession.getUsername());
        label_user_id.setText(String.valueOf(userId));

        String userEmail = DBUtils.getUserEmail(UserSession.getUsername());
        label_email.setText(String.valueOf(userEmail));

        label_username.setText(UserSession.getUsername());
        label_password.setText(UserSession.getPassword());


        // Change scenes
        button_movies.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "main-menu.fxml", "<APP NAME> - Main Menu", null, null);
            }
        });

        button_purchases.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "purchase-history.fxml", "<APP NAME> - Account", null, null);
            }
        });

        button_log_out.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "pre-menu-login.fxml", "<APP NAME> - Main Menu", null, null);
            }
        });
    }
}
