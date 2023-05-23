package com.example.oop_finalproject_2.login_register;

import com.example.oop_finalproject_2.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Button button_login;

    @FXML
    private Button button_register;

    @FXML
    private TextField tf_confirm_password;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_login.setCursor(Cursor.HAND);
        button_register.setCursor(Cursor.HAND);

        button_register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty() && !tf_email.getText().trim().isEmpty()) {
                    DBUtils.registerUser(event, tf_username.getText(), "Temp", tf_password.getText(), tf_confirm_password.getText(), tf_email.getText());
                } else {
                    System.out.println("Please fill in all information!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sign up!");

                    // Set the font style for the text
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.setStyle("-fx-font-family: Arial");

                    alert.show();
                }
            }
        });

        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "pre-menu-login.fxml", "Log in!", null, null);
            }
        });
    }
}
