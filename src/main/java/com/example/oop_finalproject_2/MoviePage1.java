package com.example.oop_finalproject_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class MoviePage1 extends BaseMovieTemplateController implements Initializable {

    @FXML
    private Button button_buy_ticket;
    @FXML
    private ImageView img_movie_poster;

    @FXML
    private Label label_movie_cast;

    @FXML
    private Label label_movie_desc;

    @FXML
    private Label label_movie_director;

    @FXML
    private Label label_movie_name;

    @FXML
    private Label label_releasedate_genre;

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
                String director = resultSet.getString("movie_director");
                String cast = resultSet.getString("movie_cast");
                String description = resultSet.getString("movie_description");
                String releaseDate = resultSet.getString("movie_release_date");
                String duration = resultSet.getString("movie_duration");
                String posterPath = resultSet.getString("movie_poster");

                // Set the retrieved values to the JavaFX labels and image view
                label_movie_name.setText(movieTitle);
                label_movie_director.setText("Director: " + director);
                label_movie_cast.setText("Cast: " + cast);
                label_movie_desc.setText(description);
                label_releasedate_genre.setText("Release Date: " + releaseDate + " | Duration: " + duration);

                //TODO: FIX THIS SHIT ~ Load and set the image from the file
//                Image image = new Image("file:" + posterPath);
//                img_movie_poster.setImage(image);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        button_buy_ticket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "base-purchase-ticket-template.fxml", "<APP NAME> - Purchasing Ticket", null, null);
            }
        });

    }
}
