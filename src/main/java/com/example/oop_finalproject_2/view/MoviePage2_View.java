package com.example.oop_finalproject_2.view;

import com.example.oop_finalproject_2.controller.BaseMovieTemplate_Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class MoviePage2_View extends BaseMovieTemplate_Controller implements Initializable {

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
            statement.setInt(1, 2);

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
    }
}