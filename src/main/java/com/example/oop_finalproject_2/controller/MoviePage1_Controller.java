package com.example.oop_finalproject_2.controller;

import com.example.oop_finalproject_2.domainmodel.MoviesDM;
import com.example.oop_finalproject_2.view.MoviePage1_View;

import java.sql.*;

public class MoviePage1_Controller {

    public void setMoviePage1UI(MoviePage1_View moviePage1UI) {}

    public MoviesDM getMovie(int movieId) {
        MoviesDM movie = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieData", "root", "*neoSQL01")) {
            String query = "SELECT * FROM movies WHERE movie_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, movieId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                movie = new MoviesDM();
                movie.setMovie_title(resultSet.getString("movie_title"));
                movie.setMovie_availability(resultSet.getString("movie_availability"));
                movie.setMovie_schedule(resultSet.getString("movie_schedule"));
                movie.setRelease_date(resultSet.getString("movie_release_date"));
                movie.setMovie_genre(resultSet.getString("movie_genre"));
                movie.setMovie_director(resultSet.getString("movie_director"));
                movie.setMovie_cast(resultSet.getString("movie_cast"));
                movie.setMovie_duration(resultSet.getString("movie_duration"));
                movie.setMovie_description(resultSet.getString("movie_description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

//    // Debugging purposes
//    public static void main(String[] args) {
//        // Create an instance of MoviePage1Controller
//        MoviePage1Controller moviePage1Controller = new MoviePage1Controller();
//
//        // Movie ID
//        int movieId = 1;
//
//        // Call the getMovie method on the moviePage1Controller instance
//        Movies movie = moviePage1Controller.getMovie(movieId);
//
//        // Print the retrieved movie details
//        System.out.println("Movie Title: " + movie.getMovie_title());
//        System.out.println("Movie Date: " + movie.getMovie_availability());
//        System.out.println("Movie Time: " + movie.getMovie_schedule());
//        System.out.println("Movie Duration: " + movie.getMovie_duration());
//        System.out.println("Movie Director: " + movie.getMovie_director());
//        System.out.println("Movie Cast: " + movie.getMovie_cast());
//        System.out.println("Movie Description: " + movie.getMovie_description());
//    }
}
