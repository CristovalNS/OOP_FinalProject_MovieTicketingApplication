package com.example.oop_finalproject_2.mainmenu;

import com.example.oop_finalproject_2.DBUtils;
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

public class MainMenuController implements Initializable {

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
                // Establish a connection to the database
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
                    // Create a SQL statement
                    String query = "SELECT * FROM reservation_data_1 WHERE user_id = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, DBUtils.getUserId(UserSessionDM.getUsername()));

                    // Execute the query
                    ResultSet resultSet = statement.executeQuery();

                    // Check if the user ID is found
                    if (resultSet.next()) {
                        // User ID found, proceed to change scene
                        DBUtils.changeScene(event, "purchase-history.fxml", "<APP NAME> - Account", null, null);
                    } else {
                        // User ID not found, display an alert
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("No tickets purchased yet.");

                        // Set the font style for the text
                        DialogPane dialogPane = alert.getDialogPane();
                        dialogPane.setStyle("-fx-font-family: Arial");

                        alert.show();

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
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

