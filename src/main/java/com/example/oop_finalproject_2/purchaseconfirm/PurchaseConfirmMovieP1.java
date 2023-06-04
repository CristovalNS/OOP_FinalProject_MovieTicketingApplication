package com.example.oop_finalproject_2.purchaseconfirm;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.SeatManager;
import com.example.oop_finalproject_2.SeatSelection;
import com.example.oop_finalproject_2.UserSession;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PurchaseConfirmMovieP1 extends BasePurchaseConfirmTemplateController implements Initializable {

    @FXML
    private Label movie_title;
    @FXML
    private Label seat_test;

    @FXML
    private Label price_test;

    @FXML
    private Label date_test;

    @FXML
    private Label time_test;

    @FXML
    private Label duration_test;

    @FXML
    private Button button_return;

    @FXML
    private Button button_buy_ticket;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle); // Call the initialize method of the parent class to set the button cursors

        // Temp data
        int userId = DBUtils.getUserId(UserSession.getUsername());
        String movie_title2 = "";
        StringBuilder seat_number = new StringBuilder();
        String reservation_date = "";
        String reservation_time = "";

        // Establish a connection to the database - Movie Data
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieData", "root", "*neoSQL01")) {
            // Create a SQL statement
            String query = "SELECT * FROM movies WHERE movie_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 1);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the movie details from the result set
                String movieAvailability = resultSet.getString("movie_availability");
                String movieAvailableTime = resultSet.getString("movie_schedule");
                String duration = resultSet.getString("movie_duration");
                String movieTitle = resultSet.getString("movie_title");

                // Set the retrieved values to the JavaFX labels and image view
                movie_title.setText(movieTitle);
                seat_test.setText(SeatSelection.getSelectedButtons() + "");
                date_test.setText(movieAvailability);
                time_test.setText(movieAvailableTime);
                duration_test.setText(duration);
                price_test.setText("Rp." + SeatManager.getTotalSelectedSeats() * 100000);

                movie_title2 = movieTitle;
                reservation_date = movieAvailability;
                reservation_time = movieAvailableTime;
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        button_return.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String[] button_names = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8",
                        "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8",
                        "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8",};

                String[] button_names2 = SeatSelection.getSelectedButtons().toArray(new String[0]);

                for (String button : button_names2) {
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
                        String updateQuery = "UPDATE bookingData.seats_1 SET " + button + " = ? WHERE movie_id = ?";
                        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);

                        updateStatement.setInt(1, 0);
                        updateStatement.setInt(2, 1); // movie_id = 1

                        updateStatement.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                DBUtils.changeScene(event, "purchase-ticket-movie-P1.fxml", "<APP NAME> - Guardians of The Galaxy Vol 3", null, null);
            }
        });


        String finalReservation_date = reservation_date;
        String finalMovieTitle = movie_title2;
        String finalReservation_time = reservation_time;

        button_buy_ticket.setOnAction(event -> {
            // Update the table to change the values
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
                for (String buttonText : SeatSelection.getSelectedButtons()) {

                    PreparedStatement updateStatement = connection.prepareStatement("UPDATE bookingData.seats_1 SET " + buttonText + " = ? WHERE movie_id = ?");
                    updateStatement.setInt(1, 1); // Set value to 1
                    updateStatement.setInt(2, 1); // movie_id = 1
                    updateStatement.executeUpdate();
                    seat_number.append(buttonText).append(" ");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
                String insertQuery = "INSERT INTO bookingData.reservation_data_1 (user_id, movie_title, seat_number, reservation_date, reservation_time) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

                insertStatement.setInt(1, userId);
                insertStatement.setString(2, finalMovieTitle);
                insertStatement.setString(3, seat_number.toString());
                insertStatement.setString(4, finalReservation_date);
                insertStatement.setString(5, finalReservation_time);

                // Debug
                System.out.println("User ID: " + userId);
                System.out.println("Movie Title: " + finalMovieTitle);
                System.out.println("Seat Number: " + seat_number);
                System.out.println("com.example.oop_finalproject_2.Reservation Date: " + finalReservation_date);
                System.out.println("com.example.oop_finalproject_2.Reservation Time: " + finalReservation_time);

                int rowsAffected = insertStatement.executeUpdate();
                if (rowsAffected > 0) {
                    ResultSet generatedKeys = insertStatement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int reservationId = generatedKeys.getInt(1);
                        System.out.println("com.example.oop_finalproject_2.Reservation ID: " + reservationId);
                    }
                    generatedKeys.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            DBUtils.changeScene(event, "purchase-successful.fxml", "<APP NAME> - Purchase Successful!", null, null);
        });
    }
}
