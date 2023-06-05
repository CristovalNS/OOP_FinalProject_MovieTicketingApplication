package com.example.oop_finalproject_2.controller;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.domainmodel.Customer;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

import java.sql.*;

public class MainMenuController {

    public static boolean purchaseCheck() {
        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
            // Create a SQL statement
            String query = "SELECT * FROM reservation_data_1 WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, DBUtils.getUserId(Customer.getUsername()));

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the user ID is found
            if (resultSet.next()) {
                // User ID found, proceed to change scene
                return true;
            } else {
                // User ID not found, display an alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No tickets purchased yet.");

                // Set the font style for the text
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle("-fx-font-family: Arial");

                alert.show();
                return false;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
