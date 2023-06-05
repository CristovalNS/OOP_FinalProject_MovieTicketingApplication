package com.example.oop_finalproject_2.controller;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.domainmodel.Movies;
import com.example.oop_finalproject_2.domainmodel.SeatSelection;
import com.example.oop_finalproject_2.domainmodel.Customer;

import java.sql.*;

public class PurchaseConfirmP1_Controller {
    public static void releaseSelectedSeats() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
            String[] buttonNames = SeatSelection.getSelectedButtons().toArray(new String[0]);

            for (String button : buttonNames) {
                String updateQuery = "UPDATE bookingData.seats_1 SET " + button + " = ? WHERE movie_id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);

                updateStatement.setInt(1, 0);
                updateStatement.setInt(2, 1); // movie_id = 1

                updateStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void reserveSeats() {
        int userId = DBUtils.getUserId(Customer.getUsername());
        // Create an instance of MoviePage1Controller
        MoviePage1_Controller movieController = new MoviePage1_Controller();

        // Movie ID
        int movieId = 1;

        // Call the getMovie method on the moviePage1Controller instance
        Movies movie = movieController.getMovie(movieId);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
            for (String buttonText : SeatSelection.getSelectedButtons()) {

                PreparedStatement updateStatement = connection.prepareStatement("UPDATE bookingData.seats_1 SET " + buttonText + " = ? WHERE movie_id = ?");
                updateStatement.setInt(1, 1); // Set value to 1
                updateStatement.setInt(2, 1); // movie_id = 1
                updateStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
            String insertQuery = "INSERT INTO bookingData.reservation_data_1 (user_id, movie_title, seat_number, reservation_date, reservation_time) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

            String seatNumbers = String.join(", ", SeatSelection.getSelectedButtons());

            insertStatement.setInt(1, userId);
            insertStatement.setString(2, movie.getMovie_title());
            insertStatement.setString(3, seatNumbers);
            insertStatement.setString(4, movie.getMovie_availability());
            insertStatement.setString(5, movie.getMovie_schedule());

            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = insertStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int reservationId = generatedKeys.getInt(1);
                    System.out.println("Reservation ID: " + reservationId);
                }
                generatedKeys.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
