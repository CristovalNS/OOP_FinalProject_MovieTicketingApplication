package com.example.oop_finalproject_2.view;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.controller.MoviePage1_Controller;
import com.example.oop_finalproject_2.controller.BaseMovieTemplate_Controller;
import com.example.oop_finalproject_2.domainmodel.MoviesDM;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MoviePage1_View extends BaseMovieTemplate_Controller implements Initializable {

    @FXML
    private Button button_buy_ticket;

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

    @FXML
    private Label label_available_date;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle); // Call the initialize method of the parent class to set the button cursors

        // Create an instance of MoviePage1Controller
        MoviePage1_Controller movieController = new MoviePage1_Controller();

        // Movie ID
        int movieId = 1;

        // Call the getMovie method on the moviePage1Controller instance
        MoviesDM movie = movieController.getMovie(movieId);

        if (movieController != null) {

            if (movie != null) {
                label_movie_name.setText(movie.getMovie_title());
                label_movie_desc.setText(movie.getMovie_description());
                label_releasedate_genre.setText("Release Date: " + movie.getRelease_date() + " | Duration: " + movie.getMovie_duration());
                label_movie_director.setText("Director: " + movie.getMovie_director());
                label_movie_cast.setText("Cast: " + movie.getMovie_cast());
                label_available_date.setText("Availability: " + movie.getMovie_availability() + ", " + movie.getMovie_schedule());
            }
        } else {
            System.err.println("MoviePage1Controller is null. Make sure to set the MoviePage1Controller before initializing MoviePage1_UI.");
        }

        button_buy_ticket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "purchase-ticket-movie-P1.fxml", "<APP NAME> - Guardians of The Galaxy Vol 3", null, null);
            }
        });
    }
}
