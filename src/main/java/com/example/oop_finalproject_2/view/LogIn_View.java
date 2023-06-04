package com.example.oop_finalproject_2.view;

import com.example.oop_finalproject_2.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LogIn_View implements Initializable {

    @FXML
    private Button button_login;

    @FXML
    private Button button_register;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_login.setCursor(Cursor.HAND);
        button_register.setCursor(Cursor.HAND);

        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.logInUser(event, tf_username.getText(), tf_password.getText(), DBUtils.getUserId(tf_username.getText()));
                // Testing purposes
                System.out.println(DBUtils.getUserId(tf_username.getText()));
            }
        });

        button_register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "pre-menu-register.fxml", "Register", null, null);
            }
        });
    }
}
