package com.example.oop_finalproject_2.domainmodel;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatManagerDM {
    private SeatSelectionDM seatSelectionDM;

    public SeatManagerDM(SeatSelectionDM seatSelectionDM) {
        this.seatSelectionDM = seatSelectionDM;
    }

    public void handleButtonAction(Button button, String buttonText, SeatManagerDM seatManagerDM) {
        int buttonValue = getButtonValueFromDatabase(buttonText);

        if (buttonValue == 1) {
            System.out.println("Seat has been reserved!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Seat has been reserved!");

            // Set the font style for the text
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-family: Arial");

            alert.showAndWait();
        } else {
            toggleButtonColor(button, String.valueOf(seatManagerDM));
            seatSelectionDM.addButton(buttonText);
            System.out.println(SeatSelectionDM.getSelectedButtons()); // Debug purposes
        }
    }


    public void initializeButtons(Button[] buttons, SeatManagerDM seatManagerDM) {
        for (Button button : buttons) {
            String buttonText = button.getText();
            System.out.println(buttonText);
            button.setOnAction(event -> handleButtonAction(button, buttonText, seatManagerDM));
            if (getButtonValueFromDatabase(buttonText) == 1) {
                button.setStyle("-fx-background-color: red");
            }
        }
    }

    public int getButtonValueFromDatabase(String buttonText) {
        int buttonValue = 0;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
            PreparedStatement selectStatement = connection.prepareStatement("SELECT " + buttonText + " FROM bookingData.seats_1 WHERE movie_id = ?");
            selectStatement.setInt(1, 1); // movie_id = 1
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                buttonValue = resultSet.getInt(buttonText);
            }

            resultSet.close();
            selectStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return buttonValue;
    }

    public static void toggleButtonColor(Button button, String buttonStyle) {
        buttonStyle = button.getStyle();

        if (buttonStyle.isEmpty()) {
            button.setStyle("-fx-background-color: #98fb98;");
        } else {
            button.setStyle("");
        }
    }

}
