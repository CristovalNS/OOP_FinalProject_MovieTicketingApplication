package com.example.oop_finalproject_2.purchaseconfirm;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.SeatManager;
import com.example.oop_finalproject_2.SeatSelection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PurchaseConfirmMovieP1 extends BasePurchaseConfirmTemplateController implements Initializable {

    @FXML
    private Label seat_test;

    @FXML
    private Label price_test;

    @FXML
    private Label date_test;

    @FXML
    private Button button_return;

    private SeatManager seatManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle); // Call the initialize method of the parent class to set the button cursors

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
                seat_test.setText(SeatSelection.getSelectedButtons() + "");
                date_test.setText(movieAvailability);
                price_test.setText(movieAvailability);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        button_return.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "purchase-ticket-movie-P1.fxml", "<APP NAME> - Guardians of The Galaxy Vol 3", null, null);
            }
        });
    }
}
