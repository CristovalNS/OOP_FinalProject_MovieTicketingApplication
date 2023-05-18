// Responsible for the UI that the user sees to confirm a log in to an account

package com.example.oop_finalproject_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button button_login_no;

    @FXML
    private Button button_login_yes;

    @FXML
    private Label label_username_confirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_login_no.setCursor(Cursor.HAND);
        button_login_yes.setCursor(Cursor.HAND);

        button_login_no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "pre-menu-login.fxml", "Log in", null, null);
            }
        });
    }

    public void usernameConfirmation(String username) {
        label_username_confirm.setText(username + "?");
    }

}
