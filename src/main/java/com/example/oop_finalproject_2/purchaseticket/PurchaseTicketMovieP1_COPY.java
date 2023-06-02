package com.example.oop_finalproject_2.purchaseticket;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.SeatManager;
import com.example.oop_finalproject_2.SeatSelection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PurchaseTicketMovieP1_COPY extends BasePurchaseTicketTemplateController implements Initializable {
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
    private Button button_buy_ticket;

    @FXML
    private Button button_return;

    @FXML
    private Label label_movie_availability;

    @FXML
    private Label label_movie_duration;

    @FXML
    private Label label_movie_time;

    @FXML
    private Label label_movie_title;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);

        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieData", "root", "*neoSQL01")) {
            // Create a SQL statement
            String query = "SELECT * FROM movies WHERE movie_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 1);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the movie details from the result set
                String movieTitle = resultSet.getString("movie_title");
                String movieAvailability = resultSet.getString("movie_availability");
                String movieAvailableTime = resultSet.getString("movie_schedule");
                String duration = resultSet.getString("movie_duration");

                // Set the retrieved values to the JavaFX labels and image view
                label_movie_title.setText(movieTitle);
                label_movie_duration.setText(duration);
                label_movie_availability.setText(movieAvailability);
                label_movie_time.setText(movieAvailableTime);

                //TODO: FIX THIS SHIT ~ Load and set the image from the file
//                Image image = new Image("file:" + posterPath);
//                img_movie_poster.setImage(image);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Button[] buttons_chairs_select = { button_A1, button_A2, button_A3, button_A4, button_A5, button_A6, button_A7, button_A8
                , button_B1, button_B2, button_B3, button_B4, button_B5, button_B6, button_B7, button_B8
                , button_C1, button_C2, button_C3, button_C4, button_C5, button_C6, button_C7, button_C8
                , button_D1, button_D2, button_D3, button_D4, button_D5, button_D6, button_D7, button_D8
                , button_E1, button_E2, button_E3, button_E4, button_E5, button_E6, button_E7, button_E8
                , button_F1, button_F2, button_F3, button_F4, button_F5, button_F6, button_F7, button_F8};

        SeatManager seatManager = new SeatManager();
        SeatSelection ss = new SeatSelection();

        for (Button button : buttons_chairs_select) {
            button.setOnAction(event -> {

                String buttonText = button.getText();
                Connection connection2 = null;
                ResultSet resultSet = null;
                PreparedStatement selectStatement = null;

                try {
                    connection2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01");
                    selectStatement =  ((Connection) connection2).prepareStatement("SELECT * FROM bookingData.seats_1 WHERE movie_id = ?");
                    selectStatement.setString(1, buttonText);
                    resultSet = selectStatement.executeQuery();

                    if (resultSet.next()) {
                        // The button has a value of '1' in the table
                        // Perform the desired action here
                        button.setDisable(true); // Disable the button
                        button.setStyle("-fx-background-color: Red;"); // Change button text color to red

                        System.out.println("Seat has been reserved!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Seat has been reserved!");

                        // Set the font style for the text
                        DialogPane dialogPane = alert.getDialogPane();
                        dialogPane.setStyle("-fx-font-family: Arial");

                    } else {
                        // The button does not have a value of '1' in the table
                        ButtonColorChanger.toggleButtonColor(button, seatManager);
                        ss.addButton(buttonText);

                        // Update the table based on button selection
                        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
                            String updateQuery = "UPDATE bookingData.seats_1 SET " + buttonText + " = ? WHERE movie_id = ?";
                            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);

                            int buttonValue = 0; // Default value is unselected

                            // Linear search to check if buttonText exists in the list of selected buttons
                            if (SeatSelection.getSelectedButtons().contains(buttonText)) {
                                buttonValue = 1; // Selected
                            }

                            updateStatement.setInt(1, buttonValue);
                            updateStatement.setInt(2, 1); // movie_id = 1

                            updateStatement.executeUpdate();

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }

        button_return.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "movie-p1.fxml", "<APP NAME> - Guardians of The Galaxy Vol 3", null, null);
            }
        });

        button_buy_ticket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (SeatManager.getTotalSelectedSeats() == 0) {
                    System.out.println("No seats selected!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please select a seat to purchase!");
                    alert.show();

                    // Set the font style for the text
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.setStyle("-fx-font-family: Arial");
                } else {
                    DBUtils.changeScene(event, "purchase-confirm-movie-P1.fxml", "<APP NAME> - Guardians of The Galaxy Vol 3", null, null);
                }

            }
        });
    }
}
