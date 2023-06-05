package com.example.oop_finalproject_2.view;

import com.example.oop_finalproject_2.*;
import com.example.oop_finalproject_2.controller.MoviePage1_Controller;
import com.example.oop_finalproject_2.domainmodel.Movies;
import com.example.oop_finalproject_2.controller.SeatManager_Controller;
import com.example.oop_finalproject_2.domainmodel.SeatSelection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PurchaseTicketMovieP1_View extends BasePurchaseTicketTemplate_View implements Initializable {
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

        // Create an instance of MoviePage1Controller
        MoviePage1_Controller movieController = new MoviePage1_Controller();

        // Movie ID
        int movieId = 1;

        // Call the getMovie method on the moviePage1Controller instance
        Movies movie = movieController.getMovie(movieId);

        if (movie != null) {
            label_movie_title.setText(movie.getMovie_title());
            label_movie_duration.setText(movie.getMovie_duration());
            label_movie_availability.setText(movie.getMovie_availability());
            label_movie_time.setText(movie.getMovie_schedule());
        }

        SeatSelection seatSelection = new SeatSelection();
        SeatManager_Controller seatManagerController = new SeatManager_Controller(seatSelection);

        Button[] buttons = new Button[]{button_A1, button_A2, button_A3, button_A4, button_A5, button_A6, button_A7, button_A8
                , button_B1, button_B2, button_B3, button_B4, button_B5, button_B6, button_B7, button_B8
                , button_C1, button_C2, button_C3, button_C4, button_C5, button_C6, button_C7, button_C8
                , button_D1, button_D2, button_D3, button_D4, button_D5, button_D6, button_D7, button_D8
                , button_E1, button_E2, button_E3, button_E4, button_E5, button_E6, button_E7, button_E8
                , button_F1, button_F2, button_F3, button_F4, button_F5, button_F6, button_F7, button_F8};

        seatManagerController.initializeButtons(buttons, seatManagerController);

        button_return.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "movie-p1.fxml", "<APP NAME> - Guardians of The Galaxy Vol 3", null, null);
            }
        });

        button_buy_ticket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (SeatSelection.getTotalSelectedSeats() == 0) {
                    System.out.println("No seats selected! Can't select purchase button.");
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

