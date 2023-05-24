package com.example.oop_finalproject_2.purchaseticket;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.SeatManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PurchaseTicketMovieP1 extends BasePurchaseTicketTemplateController implements Initializable {
    @FXML
    private Button button_buy_ticket;

    @FXML
    private Button button_return;

    @FXML
    private Label label_movie_title;

    @FXML
    private Label label_movie_duration;

    @FXML
    private DatePicker date_movie_date;

    @FXML
    private Label label_movie_time;

    @FXML
    private Label label_movie_availability;

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

        date_movie_date.setStyle("-fx-font-family: Arial; -fx-font-size: 14px;");

        button_return.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "movie-p1.fxml", "<APP NAME> - Guardians of The Galaxy Vol 3", null, null);
            }
        });

        button_buy_ticket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "purchase-confirm-movie-P1.fxml", "<APP NAME> - Guardians of The Galaxy Vol 3", null, null);
            }
        });

    }
}
