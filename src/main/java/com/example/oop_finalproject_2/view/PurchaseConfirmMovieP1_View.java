package com.example.oop_finalproject_2.view;

import com.example.oop_finalproject_2.*;
import com.example.oop_finalproject_2.controller.BasePurchaseConfirmTemplate_Controller;
import com.example.oop_finalproject_2.controller.MoviePage1_Controller;
import com.example.oop_finalproject_2.controller.PurchaseConfirmP1_Controller;
import com.example.oop_finalproject_2.domainmodel.MoviesDM;
import com.example.oop_finalproject_2.domainmodel.SeatSelectionDM;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PurchaseConfirmMovieP1_View extends BasePurchaseConfirmTemplate_Controller implements Initializable {

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

        // Create an instance of MoviePage1Controller
        MoviePage1_Controller movieController = new MoviePage1_Controller();

        // Movie ID
        int movieId = 1;

        // Call the getMovie method on the moviePage1Controller instance
        MoviesDM movie = movieController.getMovie(movieId);

        if (movie != null) {
            movie_title.setText(movie.getMovie_title());
            seat_test.setText(SeatSelectionDM.getSelectedButtons() + "");
            date_test.setText(movie.getMovie_availability());
            time_test.setText(movie.getMovie_schedule());
            duration_test.setText(movie.getMovie_duration());
            price_test.setText("Rp." + SeatSelectionDM.getTotalSelectedSeats() * 100000);
        }

        button_return.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PurchaseConfirmP1_Controller.releaseSelectedSeats();
                DBUtils.changeScene(event, "purchase-ticket-movie-P1.fxml", "<APP NAME> - Guardians of The Galaxy Vol 3", null, null);
            }
        });

        button_buy_ticket.setOnAction(event -> {
            PurchaseConfirmP1_Controller.reserveSeats();
            DBUtils.changeScene(event, "purchase-successful.fxml", "<APP NAME> - Purchase Successful!", null, null);
        });
    }
}
